package com.company.task6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class UtilsCars {

  public void printCarsList(Collection<Cars> carsCollection)

    {
        for (Object car:carsCollection
             ) {
            System.out.println(car);

        }
    }

     // Считает расход топлива для заданного типа
    public double fuelExpenseForType(Collection<Cars> carsCollection, int type) {
        double sumOfExpense=0;
        for (Cars car : carsCollection)
            if (car.type==type) {
                sumOfExpense += (double) car.run * car.paramsDT.cost1lGSM*car.paramsDT.rashod100km;
            }
        return ((double) Math.round(sumOfExpense) / 100);
        };
     public String createUniqueFileName(String GSMDirectory){
        int fileCnt; //кол-во файлов в директории
        File nf = new File(GSMDirectory);
        // создаем уникальное имя файла <кол-во файлов в директории +1> + "day.txt"
        fileCnt = nf.listFiles().length;
        String fileName = GSMDirectory+"\\"+ (fileCnt + 1) +"day.txt";
        nf = new File(fileName);
        while (nf.exists()){
            fileCnt++;
            fileName = GSMDirectory+"\\"+(fileCnt+1)+"day.txt";
            nf = new File(fileName);
        }
         System.out.println("Имя файла "+fileName);
        return fileName;
    };

     public String authorization(){
         String userName ;
         Scanner sc = new Scanner(System.in);
         System.out.print("Введите имя оператора: > ");
         userName = sc.nextLine();
         return userName.trim().isEmpty()? "unknownUSER": userName;
     };

    public ArrayList<Cars> createCarsList(List<String> inputList){
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
    public void sortDayResult(ArrayList<Cars> carsList){
        Scanner sc = new Scanner(System.in);
        String mode = "";
        do {
            System.out.println(" Введите тип машин и  парамтер сортировки через пробел, для выхода нажмите q ");
            System.out.println("Тип: 100 - легковые авто, 200 - пассажирский транспорт, 300 - грузовые авто, 400 - тяжелая техника, краны ");
            System.out.println("Параметр сортировки 1 - пробег, 2 - доп. значение (Объем или вес грузов|Кол-во пассажировПассажиров), 12 - пробег и доп значение >");
            System.out.print("> ");
            mode = sc.nextLine();
            //проверка ввода
            boolean valid = (mode.matches("100 [1]") ||
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

    public void historyDay(String GSMDirectory) {
        Path path = Paths.get(GSMDirectory);
        if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS) || !Files.isDirectory(path)) {
            System.out.println("Директория " + GSMDirectory + " не существует");
            return;
        }
        for (String fname : path.toFile().list()) {
            System.out.println(fname);
        }
    };

    public void historyFile(String GSMDirectory,String fname) {

        Path path = Paths.get(GSMDirectory + "\\" + fname);
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
        else {
            System.out.println("файл " + GSMDirectory + "\\" + fname + " не найден");
            return;
        }
    }



    public void sortCarsList (ArrayList<Cars> carsList, Comparator<Cars> carsComparator, int type)
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
    public void printExpenseRating (UtilsCars utilsCars, ArrayList<Cars> carsList){
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

    public void endDay(String fileName, ArrayList<Cars> carsList){
        double r100 = this.fuelExpenseForType(carsList,100);
        double r200 = this.fuelExpenseForType(carsList,200);
        double r300 = this.fuelExpenseForType(carsList,300);
        double r400 = this.fuelExpenseForType(carsList,400);
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

    }
