package com.company.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main5_1 {

    public static void main(String[] args) {
        System.out.println("Задача 1 - ГСМ");
        List<String> inputList = Arrays.asList("C100_1-100", "C200_1-120-1200",
                "C300_1-120-30", "C400_1-80-20",
                "C100_2-50", "C200_2-40-1000",
                "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100",
                "C300_3-150-29", "C400_3-100-28",
                "C100_1-300", "C200_1-100-750", "C300_1-32-15");
        UtilsCars utilsCars = new UtilsCars();
        // создаем список объектов-машин из списка строк
        ArrayList<Cars> carsList = createCarsList(inputList);


        //  Вывод на печать без сортировки.
        utilsCars.printCarsList(carsList);

        //Сортировки коллекции с компараторами
        System.out.println("Сортировка по пробегу тип 100 и тип 200:");
        Comparator<Cars> carRunComparator = new CarRunComparator();
        try {
            sortCarsList(carsList, carRunComparator, 100);
        } catch (MyException exception) {
            exception.printStackTrace();
        }
        try {
            sortCarsList(carsList, carRunComparator, 200);
        } catch (MyException exception) {
            exception.printStackTrace();
        }
        System.out.println("Сортировка по доп значению тип 300:");
        Comparator carAddParamComparator = new CarAddParamComparator();
        //Провоцируем ClassCastException
        try {
            sortCarsList(carsList, carAddParamComparator, 100);
        } catch (MyException exception) {
           // System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        System.out.println("Сортировка по пробегу и доп значению тип 400:");

            Comparator<Cars> carRunAddParamComparator = new CarRunComparator().thenComparing(carAddParamComparator);
        try {
            sortCarsList(carsList, carRunAddParamComparator, 400);
        } catch (MyException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        //Провоцируем NullPointerException
        try{
            sortCarsList(null, carRunAddParamComparator, 400);
        } catch (MyException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }

        //Расход топлива на каждый тип машин
        printExpenseRating(utilsCars, carsList);

    }

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
            } else {Cars car = new Cars100(gosNumber, type, run);
                if (carsList.contains(car)) {
                carsList.get(carsList.indexOf(car)).run = carsList.get(carsList.indexOf(car)).run + run;
                }else
                carsList.add(new Cars100(gosNumber, type, run));
            }

        }
        return carsList;
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
