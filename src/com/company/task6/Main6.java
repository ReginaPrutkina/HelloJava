package com.company.task6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main6 {

    public static void main(String[] args) {
        System.out.println("Задача 1 - ГСМ");
        List<String> inputList = new ArrayList<>();
                //= Arrays.asList("C100_1-100", "C200_1-120-1200",
            /*    "C300_1-120-30", "C400_1-80-20",
                "C100_2-50", "C200_2-40-1000",
                "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100",
                "C300_3-150-29", "C400_3-100-28",
                "C100_1-300", "C200_1-100-750", "C300_1-32-15");*/
        UtilsCars utilsCars = new UtilsCars();

        String mode = "";
        Scanner sc = new Scanner(System.in);
        String GSMDirectory = "D:\\Users\\Lenovo\\IdeaProjects\\HelloJava\\GSM";
        Logging carlogger = new LogToFile("MyUser",GSMDirectory+"\\log");
        do {
            System.out.print(" Для начала смены введите команду start, для выхода q > ");
            mode = sc.nextLine();
        } while (!(mode.equals("start") || mode.equals("q")));
        if (mode.equals("q"))
            return;
        System.out.println("Начало смены");
        carlogger.log("Начало смены. Введена команда "+ mode);

        //Начало смены
        // Считываем входнын данные из файла

        Path path = Paths.get(GSMDirectory + "\\input\\input.txt");
        if (Files.exists(path) && Files.isRegularFile(path)) {
            try {
                inputList = Files.readAllLines(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String fileName= createUniqueFileName(GSMDirectory);
       // System.out.println(fileName);
        try(FileWriter fileWriter = new FileWriter(fileName)) {
            for (String str : inputList) {
                fileWriter.write(str + "\n");
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        //Вводим данные с консоли, если хотим и пишем результаты дня в файл
        ArrayList<Cars> carsList = dayResult(fileName,inputList);

        //конец смены
                do {
                    System.out.print(" Для окончания смены введите команду end > ");
                    mode = sc.nextLine();
                } while (!(mode.equals("end")));
                carlogger.log("Конец смены. Введена команда "+ mode);
                endDay(fileName,carsList,utilsCars);

       // сортировки и просмотр истории
        System.out.print(" Для сортировки введите - sort, для просмотра истории - history, для выхода q > ");
        mode = sc.nextLine();
        while (!mode.equals("q")) {
            if (mode.equals("sort")) {
                carlogger.log("Конец смены. Введена команда "+ mode);
                sortDayResult(carsList);
            } else if (mode.equals("history")) {
                carlogger.log("Конец смены. Введена команда "+ mode);
                historyDay(GSMDirectory);
            }else {
                System.out.println("неверный ввод");
            }
            System.out.print(" Для сортировки введите - sort, для просмотра истории - history, для выхода q > ");

            mode = sc.nextLine();
        }
        System.out.println("Смена закрыта");
        carlogger.log("Конец смены. Введена команда "+ mode);

    }

    static public String createUniqueFileName(String GSMDirectory){
        int fileCnt = 0; //кол-во файлов в директории
        File nf = new File(GSMDirectory);
        // создаем уникальное имя файла <кол-во файлов в директории +1> + "day.txt"
        fileCnt = nf.listFiles().length;
        String fileName = GSMDirectory+"\\"+Integer.toString(fileCnt+1)+"day.txt";
        System.out.println(fileCnt);
        nf = new File(fileName);
        while (nf.exists()){
            fileCnt++;
            fileName = GSMDirectory+"\\"+Integer.toString(fileCnt+1)+"day.txt";
            nf = new File(fileName);
        }
        return fileName;
    };

    static public ArrayList<Cars> createCarsList(List<String> inputList){
        ArrayList<Cars> carsList = new ArrayList<>();
        List<String> tempArray;
        int type, run, addParam = 0;
        String gosNumber;
        for (String str : inputList
        ) {
            tempArray = Arrays.asList(str.split("-"));
            type = Integer.parseInt(tempArray.get(0).substring(1, 4));
            gosNumber = tempArray.get(0).substring(1);
            run = Integer.parseInt(tempArray.get(1));
            if (type != 100) {
                addParam = Integer.parseInt(tempArray.get(2));
                CarsOthers car = new CarsOthers(gosNumber, type, run, addParam);
                if (carsList.contains(car)) {
                    carsList.get(carsList.indexOf(car)).run = carsList.get(carsList.indexOf(car)).run + run;
                    ((CarsOthers)carsList.get(carsList.indexOf(car))).addParam = ((CarsOthers)carsList.get(carsList.indexOf(car))).addParam + addParam;
                }else
                    carsList.add(new CarsOthers(gosNumber, type, run, addParam));
            } else {
                Cars car = new Cars100(gosNumber, type, run);
                if (carsList.contains(car)) {
                    carsList.get(carsList.indexOf(car)).run = carsList.get(carsList.indexOf(car)).run + run;
                }else
                    carsList.add(new Cars100(gosNumber, type, run));
            }

        }
        return carsList;
    };

    static public ArrayList<Cars> dayResult(String fileName, List<String> inputList){
        Scanner sc = new Scanner(System.in);
        System.out.print(" Введите результаты смены ");
        System.out.println("C<ТИП>_<ГОСНОМЕР>-<Пробег за день>-<Объем или вес грузов|Кол-во пассажировПассажиров> ");
        System.out.print(" Введите данные или для завершения нажмите q >");
        String dayResults = sc.nextLine();
        //проверка ввода
        Boolean valid = (dayResults.matches("C100_\\d{1}\\-\\d+") ||
                dayResults.matches("C[234]00_\\d{1}\\-\\d+\\-\\d+")) ;

        List<String> dayList = new ArrayList<>();
        dayList.addAll(inputList);
        try(FileWriter fileWriter = new FileWriter(fileName,true)) {
            while (!dayResults.equals("q")) {
                if (valid){
                    dayList.add(dayResults);
                    fileWriter.write(dayResults + "\n");
                }
                else {
                    System.out.println("нверный шаблон ввода");
                }
                System.out.print(" Введите данные или для завершения нажмите q >");
                dayResults = sc.nextLine();
                valid = (dayResults.matches("C100_\\d{1}\\-\\d+") ||
                        dayResults.matches("C[234]00_\\d{1}\\-\\d+\\-\\d+")) ;
            }
        }catch (IOException ex){
            ex.printStackTrace();

        }
        for (String str : dayList) {
                System.out.println(str);
        }
            return createCarsList(dayList);

    };

    static public void endDay(String fileName, ArrayList<Cars> carsList, UtilsCars utilsCars){
        double r100 = utilsCars.fuelExpenseForType(carsList,100);
        double r200 = utilsCars.fuelExpenseForType(carsList,200);
        double r300 = utilsCars.fuelExpenseForType(carsList,300);
        double r400 = utilsCars.fuelExpenseForType(carsList,400);
        double rAll = r100 + r200 + r300 + r400;

        try(FileWriter fileWriter = new FileWriter(fileName,true)) {
            fileWriter.write("Расход ГСМ всего на легковые автомобили " + r100+ "\n");
            fileWriter.write("Расход ГСМ всего на грузовые авто " + r200+ "\n");
            fileWriter.write("Расход ГСМ всего на пассажирский транспорт " + r300+ "\n");
            fileWriter.write("Расход ГСМ всего на тяжелую технику, краны " + r400+ "\n");
            fileWriter.write("Расход ГСМ всего " + rAll+ "\n");

            double minRashod = Math.min(Math.min(r100, r200), Math.min(r300, r400));
            double maxRashod = Math.max(Math.max(r100, r200), Math.max(r300, r400));
            if (minRashod == r100)
                fileWriter.write("Минимальный расход для типа 'легковые авто': " + r100+ "\n");
            else if (minRashod == r200)
                fileWriter.write("Минимальный расход для типа 'грузоваые авто': " + r200+ "\n");
            else if (minRashod == r300)
                fileWriter.write("Минимальный расход для типа 'пассажирский транспорт': " + r300+ "\n");
            else if (minRashod == r400)
                fileWriter.write("Минимальный расход для типа 'тяжелая техника': " + r400+ "\n");

            if (maxRashod == r100)
                fileWriter.write("Максимальный расход для типа 'легковые авто': " + r100+ "\n");
            else if (maxRashod == r200)
                fileWriter.write("Максимальный расход для типа 'грузоваые авто': " + r200+ "\n");
            else if (maxRashod == r300)
                fileWriter.write("Максимальный расход для типа 'пассажирский транспорт':" + r300+ "\n");
            else if (maxRashod == r400)
                fileWriter.write("Максимальный расход для типа 'тяжелая техника': " + +r400+ "\n");
        }catch (IOException ex){
            ex.printStackTrace();

        }


    };

    static public void sortDayResult(ArrayList<Cars> carsList){
        Scanner sc = new Scanner(System.in);
        String mode = "";
        do {
            System.out.println(" Введите тип машин и  парамтер сортировки через пробел, для выхода нажмите q ");
            System.out.println("Тип: 100 - легковые авто, 200 - пассажирский транспорт, 300 - грузовые авто, 400 - тяжелая техника, краны ");
            System.out.println("Параметр сортировки 1 - пробег, 2 - доп. значение (Объем или вес грузов|Кол-во пассажировПассажиров), 12 - пробег и доп значение >");
            System.out.print("> ");
            mode = sc.nextLine();
            //проверка ввода
            Boolean valid = (mode.matches("100 [1]") ||
                    mode.matches("[234]00 [12]") ||
                    mode.matches("[234]00 12"));

            while (!mode.equals("q") && !valid) {
                System.out.println("нверный шаблон ввода");
                System.out.print(" Введите данные или для завершения нажмите q >");
                mode = sc.nextLine();
                valid = (mode.matches("100 [1]") ||
                        mode.matches("[234]00 [12]") ||
                        mode.matches("[234]00 12"));

            }
            if (valid) {
                Comparator carComparator = null;
                int type = Integer.parseInt(mode.substring(0, 3));
                int param = Integer.parseInt(mode.substring(4));
                switch (param) {
                    case 1 -> {
                        carComparator = new CarRunComparator();
                    }
                    case 2 -> {
                        carComparator = new CarAddParamComparator();
                    }
                    case 12 -> {
                        carComparator = new CarRunComparator().thenComparing(new CarAddParamComparator());
                    }
                }
                try {
                    sortCarsList(carsList, carComparator, type);
                } catch (MyException exception) {
                    exception.printStackTrace();
                }
            }
        } while (!mode.equals("q"));
    };

    public static void historyDay(String GSMDirectory) {
        Path path = Paths.get(GSMDirectory);
        if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS) || !Files.isDirectory(path)) {
            System.out.println("Директория " + GSMDirectory + " не существует");
             return;
        }

        for (String fname : path.toFile().list()
        ) {
            System.out.println(fname);

        }
        System.out.print(" Для просмотра файла введите - history[имя файла], для выхода нажмите q > ");
        Scanner sc = new Scanner(System.in);
        String mode = "";
        mode = sc.nextLine();
        while (!mode.matches("history\\[\\w+\\.\\w+\\]") && !mode.equals("q")) {
            System.out.println("неверный ввод");
            System.out.print(" Для просмотра файла введите - history[имя файла], для выхода нажмите q > ");
            mode = sc.nextLine();
        };
        if (!mode.equals("q")) {
            String fname = mode.substring(mode.indexOf("[") + 1, mode.indexOf("]"));
            System.out.println(fname);
            path = Paths.get(GSMDirectory + "\\" + fname);
            if (Files.exists(path) && Files.isRegularFile(path)) {
                try {
                    List<String> fileContent = Files.readAllLines(path);
                    for (String str : fileContent) {
                        System.out.println(str);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

        static public void sortCarsList (ArrayList<Cars> carsList, Comparator<Cars> carsComparator, int type)
    throws MyException {
        ArrayList<Cars> carsListShort=new ArrayList<>();
        try{
        // Создаем отдельный список для машин одного типа,
        // чтобы корретно отрабатывали компараторы для CarsOther по доп значениям
        for (Cars car : carsList )
        { if (car.type == type)
            carsListShort.add(car);
        }

            carsListShort.sort(carsComparator);
        } catch (ClassCastException exception) {
            throw new MyException("Неверный тип входного параметра",exception);
        } catch (NullPointerException exception){
            throw new MyException("Параметр не может быть null",exception);
        } catch (Exception exception){
            throw new MyException("Неизвестная ошибка",exception);
        }


        for (Cars car : carsListShort )
            System.out.println(car);

    }
    static public void printExpenseRating (UtilsCars utilsCars, ArrayList<Cars> carsList){
        double r100 = utilsCars.fuelExpenseForType(carsList,100);
        double r200 = utilsCars.fuelExpenseForType(carsList,200);
        double r300 = utilsCars.fuelExpenseForType(carsList,300);
        double r400 = utilsCars.fuelExpenseForType(carsList,400);
        double rAll = r100 + r200 + r300 + r400;

        System.out.println("Расход ГСМ всего на легковые автомобили " + r100);
        System.out.println("Расход ГСМ всего на грузовые авто " + r200);
        System.out.println("Расход ГСМ всего на пассажирский транспорт " + r300);
        System.out.println("Расход ГСМ всего на тяжелую технику, краны " + r400);
        System.out.println("Расход ГСМ всего " + rAll);

        double minRashod = Math.min(Math.min(r100, r200), Math.min(r300, r400));
        double maxRashod = Math.max(Math.max(r100, r200), Math.max(r300, r400));
        if (minRashod == r100)
            System.out.println("Минимальный расход для типа 'легковые авто': " + r100);
        else if (minRashod == r200)
            System.out.println("Минимальный расход для типа 'грузоваые авто': " + r200);
        else if (minRashod == r300)
            System.out.println("Минимальный расход для типа 'пассажирский транспорт': " + r300);
        else if (minRashod == r400)
            System.out.println("Минимальный расход для типа 'тяжелая техника': " + r400);

        if (maxRashod == r100)
            System.out.println("Максимальный расход для типа 'легковые авто': " + r100);
        else if (maxRashod == r200)
            System.out.println("Максимальный расход для типа 'грузоваые авто': " + r200);
        else if (maxRashod == r300)
            System.out.println("Максимальный расход для типа 'пассажирский транспорт':" + r300);
        else if (maxRashod == r400)
            System.out.println("Максимальный расход для типа 'тяжелая техника': " + +r400);
    }
}
