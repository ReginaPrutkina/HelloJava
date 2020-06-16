package com.company.task2;

public class Main2 {
    public static void main(String[] args) {
        //Задача 1 - ГСМ
        Cars100 cars100 = new Cars100();
        Cars200 cars200 = new Cars200();
        Cars300 cars300 = new Cars300();
        Cars400 cars400 = new Cars400();
        //Проверка сортировки и схлопывания - вывод на экран
        //параметр - поле сортировки: 1 - гос номер, 2 - пробег
        //Проверки на ошибочный ввод поля сортировки нет
        cars100.shlopArr(1);
        cars200.shlopArr(2);
        cars300.shlopArr(1);
        cars400.shlopArr(2);

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
//****************************************
        //Задача 2- Связный список
        int[] testArr={1,21,3,4};
         Massiv listArr=new Massiv(testArr);
         //Втавка элемента
         listArr.addElement(17,1);
         //Добавление элемента
        listArr.addElement(8,8);
        //вывод списка
         listArr.printArr();
         //удаление элемента
         listArr.delElement(4);
         listArr.printArr();
         //Создание отсортированного списка - новый массив
         Massiv sortedList=listArr.sortArrUp();
         sortedList.printArr();
         //min, max, длина
        System.out.println("min "+listArr.minElement());
        System.out.println("max "+listArr.maxElement());
        System.out.println("длина "+listArr.lengthMassive());
    }
    }

