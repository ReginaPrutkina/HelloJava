package com.company.task2;

import org.w3c.dom.ls.LSOutput;

public class Main2 {
    public static void main(String[] args) {
//        //Задача 1 - ГСМ
        System.out.println("Задача 1 - ГСМ");
        String[] strArr = {"C100_1-100", "C200_1-120-1200",
                "C300_1-120-30", "C400_1-80-20",
                "C100_2-50", "C200_2-40-1000",
                "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100",
                "C300_3-150-29", "C400_3-100-28",
                "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        //Создаем через класс утилит целочисленный массив машин intCarsArr из строкового
        UtilsCars utils=new UtilsCars();
        int[][] intCarsArr=utils.createIntArr(strArr);
       //Создаем экзепляры классов машин
        Cars100 cars100 = new Cars100(intCarsArr,100,"легковые авто",46.10,12.5);
        Cars200 cars200 = new Cars200(intCarsArr,200,"грузовой авто",48.90,12.0);
        Cars300 cars300 = new Cars300(intCarsArr,300,"пассажирский транспорт",47.50,11.5);
        Cars400 cars400 = new Cars400(intCarsArr,400,"тяжелая техника(краны)",48.90,20.0);
//Проерка сортировки и схлопывания
        utils.printArr(utils.shlopArr(cars100.carsArr,2),cars100.typeName);
        utils.printArr(utils.shlopArr(cars200.carsArr,1),cars200.typeName,cars200.dopZnach);


        // расход для всех типов транспорта,  общий раход и мин.макс
        double r100 = cars100.rashodType();
        double r200 = cars200.rashodType();
        double r300 = cars300.rashodType();
        double r400 = cars400.rashodType();
        double rAll=r100+r200+r300+r400;

        System.out.println("Расход ГСМ всего на " + cars100.typeName + " " + r100);
        System.out.println("Расход ГСМ всего на " + cars200.typeName + " " + r200);
        System.out.println("Расход ГСМ всего на " + cars300.typeName + " " + r300);
        System.out.println("Расход ГСМ всего на " + cars400.typeName + " " + r400);
        System.out.println("Расход ГСМ всего "+ rAll);

        double minRashod = Math.min(Math.min(r100,r200), Math.min(r300,r400));
        double maxRashod = Math.max(Math.max(r100,r200), Math.max(r300,r400));
        if (minRashod==r100)
            System.out.println("Минимальный расход для типа '" + cars100.typeName + "': " + r100);
        else if (minRashod==r200)
            System.out.println("Минимальный расход для типа '" + cars200.typeName + "': " + r200);
        else if (minRashod==r300)
            System.out.println("Минимальный расход для типа '" + cars300.typeName + "': " + r300);
        else if (minRashod==r400)
            System.out.println("Минимальный расход для типа '" + cars400.typeName + "': " + r400);

        if (maxRashod==r100)
            System.out.println("Максимальный расход для типа '" + cars100.typeName + "': " + r100);
        else if (maxRashod==r200)
            System.out.println("Максимальный расход для типа '" + cars200.typeName + "': " + r200);
        else if (maxRashod==r300)
            System.out.println("Максимальный расход для типа '" + cars300.typeName + "': " + r300);
        else if (maxRashod==r400)
            System.out.println("Максимальный расход для типа '" + cars400.typeName + "': " + r400);
////****************************************
//        //Задача 2- Связный список
//        int[] testArr={1,21,3,4};
//         Massiv listArr=new Massiv(testArr);
//         //Втавка элемента
//         listArr.addElement(17,1);
//         //Добавление элемента
//        listArr.addElement(8,8);
//        //вывод списка
//         listArr.printArr();
//         //удаление элемента
//         listArr.delElement(4);
//         listArr.printArr();
//         //Создание отсортированного списка - новый массив
//         Massiv sortedList=listArr.sortArrUp();
//         sortedList.printArr();
//         //min, max, длина
//        System.out.println("min "+listArr.minElement());
//        System.out.println("max "+listArr.maxElement());
//        System.out.println("длина "+listArr.lengthMassive());

        //***************************************
        //задача 3 - калькулятор
        System.out.println("задача 3 - калькулятор");
        int iA=5;
        int iB=8;
        double dA=5.0;
        double dB=8.0;
        byte bA=5;
        float fB= 8.0f;
        Calculator calc=new Calculator();
        System.out.println(calc.calcPow2(5.0));


    }
    }

