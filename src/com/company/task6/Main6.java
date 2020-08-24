package com.company.task6;
import javax.imageio.IIOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main6 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Задача 1 - ГСМ");
        UtilsCars utilsCars = new UtilsCars();
        String mode = "";
        Scanner sc = new Scanner(System.in);
        String GSMDirectory = "D:\\Users\\Lenovo\\IdeaProjects\\HelloJava\\GSM";
        UserAuthorization userAuthorization = new UserAuthorization();
        UserInfo userInfo = new UserInfo(userAuthorization.askUserLogin(),userAuthorization.askUserPassword());
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                 new FileOutputStream(GSMDirectory+"\\userinfo.ser"))){
            objectOutputStream.writeObject(userInfo);
            System.out.println(userInfo);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(GSMDirectory+"\\userinfo.ser"))){
            UserInfo userInfo1 = (UserInfo) objectInputStream.readObject();
            System.out.println(userInfo1);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Logging carlogger = new LogToFile(userInfo.userLogin, GSMDirectory + "\\log");

        do {
            System.out.print(" Для начала смены введите команду start, для выхода q > ");
            mode = sc.nextLine();
        } while (!(mode.equals("start") || mode.equals("q")));
        if (mode.equals("q"))
            return;
        System.out.println("Начало смены");
        carlogger.log("Начало смены. Введена команда " + mode);
        //Создаем уникальное имя файла для результатов смены
        String fileName = utilsCars.createUniqueFileName(GSMDirectory);
        //Вводим данные по смене и сохраняем их в файл
        ArrayList<Cars> carsList = dayResult(GSMDirectory, fileName,utilsCars);

        //конец смены
        do {
            System.out.print(" Для окончания смены введите команду end > ");
            mode = sc.nextLine();
        } while (!(mode.equals("end")));
        carlogger.log("Конец смены. Введена команда " + mode);
        utilsCars.endDay(fileName, carsList);

        // сортировки, и просмотр истории и файла
        mode = "";
        while (!mode.equals("q")) {
            System.out.println(" Для сортировки введите - sort, для просмотра истории - history, ");
            System.out.print(" для просмотра файла - history[имя файла], для выхода q > ");
            mode = sc.nextLine();
            switch (mode) {
                case "sort" ->{
                    carlogger.log("Конец смены. Введена команда " + mode);
                    utilsCars.sortDayResult(carsList);
                }
                case "history"-> {
                    carlogger.log("Конец смены. Введена команда " + mode);
                    utilsCars.historyDay(GSMDirectory);
                }
                case "q"->{ continue;
                }
                default -> {
                     if (mode.matches("history\\[\\w+\\.\\w+\\]")){
                        carlogger.log("Конец смены. Введена команда " + mode);
                        utilsCars.historyFile(GSMDirectory,mode.substring(mode.indexOf("[") + 1, mode.indexOf("]")));
                    } else System.out.println("неверный ввод");
                }
            }
        }
        System.out.println("Смена закрыта");
        carlogger.log("Конец смены. Введена команда " + mode);
    };

    static public ArrayList<Cars> dayResult(String GSMDirectory,String fileName,UtilsCars utilsCars ){
        Scanner sc = new Scanner(System.in);
        //Начало смены
        // Считываем входные данные из файла input
       List<String> inputList = new ArrayList<>();
        Path path = Paths.get(GSMDirectory + "\\input\\input.txt");
        if (Files.exists(path) && Files.isRegularFile(path)) {
            try {
                inputList = Files.readAllLines(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //Вводим дополнитeльно вручную
        System.out.print(" Введите результаты смены ");
        System.out.println("C<ТИП>_<ГОСНОМЕР>-<Пробег за день>-<Объем или вес грузов|Кол-во пассажиров> ");

        List<String> dayList = new ArrayList<>(inputList);
        try(FileWriter fileWriter = new FileWriter(fileName,true)) {
            for (String str : dayList) {
                fileWriter.write(str + "\n");
            }
            String dayResults = "";
            boolean valid = false;
            while (true) {
                System.out.print(" Введите данные или для завершения нажмите q >");
                dayResults = sc.nextLine();
                valid = (dayResults.matches("C100_\\d{1}-\\d+") ||
                        dayResults.matches("C[234]00_\\d{1}-\\d+-\\d+")) ;
                if (dayResults.equals("q")) break;
                if (valid){
                    dayList.add(dayResults);
                    fileWriter.write(dayResults + "\n");
                }
                else {
                    System.out.println("нверный шаблон ввода");
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        for (String str : dayList) {
                System.out.println(str);
        }
        return utilsCars.createCarsList(dayList);
    };
}
