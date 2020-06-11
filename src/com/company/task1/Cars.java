package com.company.task1;

public class Cars {
    String[] strArr = {"C100_1-100", "C200_1-120-1200",
            "C300_1-120-30", "C400_1-80-20",
            "C100_2-50", "C200_2-40-1000",
            "C300_2-200-45", "C400_2-10-20",
            "C100_3-10", "C200_3-170-1100",
            "C300_3-150-29", "C400_3-100-28",
            "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
    String[][] typeArr = {{"100", "легковой авто", ""},
            {"200", "грузовой авто", "объем перевезенного груза (см. куб.)"},
            {"300", "пассажирский транспорт", "число перевезенных пассажиров"},
            {"400", "тяжелая техника(краны)", "вес поднятых грузов тонн"}
    };
    // {расход на 100 км, стоимость 1л}
    Double[][] rashToplArr = {{12.5, 46.10}, {12.0, 48.90}, {11.5, 47.50}, {20.0, 48.90}};

    //String Arr[][];
    // массивы вида (гос номер, пробег, доп параметр)
    int[][] Arr100;
    int[][] Arr200;
    int[][] Arr300;
    int[][] Arr400;

    int countAllCar = strArr.length;
    int count100 = 0, count200 = 0, count300 = 0, count400 = 0;
    public Cars() {
        int typeCar;
        int numberCar;

// Считаем кол-во машин разных типов, т.е. длину массивов для каждого типа
        for (int i = 0; i < countAllCar; i++) {
             switch (strArr[i].substring(1, 4)) {
                case "100" ->  count100++;
                case "200" ->  count200++;
                case "300" -> count300++;
                case "400" ->  count400++;
            }
        }
        //инициализируем массивы для каждого типа
        int i100 = 0, i200 = 0, i300 = 0, i400 = 0; // текущая строка в каждом массиве
        Arr100 = new int[count100][3];
        Arr200 = new int[count200][3];
        Arr300 = new int[count300][3];
        Arr400 = new int[count400][3];

        for (int i = 0; i < countAllCar; i++) {
            String[] tempArr;
            //Заполняем все Arr
            tempArr = strArr[i].split("-");
            typeCar = Integer.valueOf(tempArr[0].substring(1, 4));
            numberCar = Integer.valueOf(tempArr[0].substring(5));
            switch (typeCar) {
                case 100 -> {
                    Arr100[i100][0] = numberCar;
                    for (int k = 1; k < tempArr.length; k++) {
                        Arr100[i100][k] = Integer.valueOf(tempArr[k]);
                    }
                    i100++;
                }
                case 200 -> {
                    for (int k = 1; k < tempArr.length; k++) {
                        Arr200[i200][0] = numberCar;
                        Arr200[i200][k] = Integer.valueOf(tempArr[k]);
                    }
                    i200++;

                }
                case 300 -> {
                    for (int k = 1; k < tempArr.length; k++) {
                        Arr300[i300][0] = numberCar;
                        Arr300[i300][k] = Integer.valueOf(tempArr[k]);
                    }
                    i300++;

                }
                case 400 -> {
                    for (int k = 1; k < tempArr.length; k++) {
                        Arr400[i400][0] = numberCar;
                        Arr400[i400][k] = Integer.valueOf(tempArr[k]);
                    }
                    i400++;

                }
            }
        }


    }
     /**
     * Считает расход для заданного массива
      * @param Arr - массив машин одного типа
      * @param typeCar - тип (100, 200, 300, 400)
      * @return сумму расходов от всех эл массива
      */
    public double rashodType(int[][] Arr, int typeCar, int countCar){
        int idxrashToplArr=typeCar/100-1;
        double summaRashOnKm=rashToplArr[idxrashToplArr][0]*rashToplArr[idxrashToplArr][1];
        double summaRash=0.0;
        for (int i = 0; i < countCar; i++) summaRash+=(double) Arr200[i][1]*summaRashOnKm;
        return ((double) Math.round( summaRash)/100);
    }

    /**
     * Считает и выводит расход для всех типов транспорта,  общий раход и мин.макс
     */
    public void rashodAllTypesCar(){
        double[] summGSM ={
        rashodType(Arr200,200,Arr200.length),
        rashodType(Arr100,100,Arr100.length),
        rashodType(Arr300,300,Arr300.length),
        rashodType(Arr400,400,Arr400.length)};
        double sumGSMAll=0.0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Стоимость расходов для типа '"+typeArr[i][1]+"': "+ summGSM[i]);
            sumGSMAll+=summGSM[i];
        }
          System.out.println("Общая стоимость расходов ГСМ "+ sumGSMAll);
        double minRashod=Math.min(Math.min(summGSM[0],summGSM[1]),Math.min(summGSM[2],summGSM[3]));
        double maxRashod=Math.max(Math.max(summGSM[0],summGSM[1]),Math.max(summGSM[2],summGSM[3]));
        int idx;
        for (idx = 0; idx <4 ; idx++) {
            if (summGSM[idx]==minRashod) break;
        }
        System.out.println("Минимальный расход для типа '"+typeArr[idx][1]+"': "+ summGSM[idx]);
        for (idx = 0; idx <4 ; idx++) {
            if (summGSM[idx]==maxRashod) break;
        }
        System.out.println("Максимальный расход для типа '"+typeArr[idx][1]+"': "+ summGSM[idx]);

    }

    /**
     *Сортирует массив(изменяет входной массив) по заданному полю
     * @param Arr - неотсортированный массив
     * @param sortField - индекс поля сортировки
     */
    public void sortArray(int[][] Arr, int sortField){

        int col = Arr[0].length; //ко-во колонок
        int str=Arr.length;     //кол-во строк
        int[] tempArr=new int[col];
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < str-1; i++) {
                if (Arr[i ][sortField] > Arr[i+1][sortField]) {
                    isSorted = false;
                   tempArr = Arr[i];
                    Arr[i] = Arr[i +1];
                    Arr[i +1] = tempArr;
                }
            }

        }
}

    /**
     * Выводит на экран отсортированный схлопнутый массив
     * @param Arr -  массив с дублями
     */
    public void shlopArr(int[][] Arr,int sortField){
        //Сорируем по номеру Авто
        sortArray(Arr,0);
    //создаем новый схлопнутый массив
    int newCount=0;
    int numberCar=0;
    for (int i = 0; i <Arr.length ; i++) {
        if (numberCar!=Arr[i][0]) {
            numberCar = Arr[i][0];
            newCount++;
        }
    }
    int[][] smallArr=new int [newCount][Arr[0].length];
    int idx=0;  //номер строки нового массива
    numberCar=Arr[0][0];
    for (int i = 0; i <Arr.length ; i++) {
        if (numberCar!=Arr[i][0]) {
            idx++;
            numberCar = Arr[i][0];
        }
        smallArr[idx][0]=Arr[i][0];
        for (int j = 1; j <Arr[0].length ; j++) {
            smallArr[idx][j]+=Arr[i][j];
        }

    }
        sortArray(smallArr,sortField);
        //Вывод на экран
        for (int i = 0; i < smallArr.length; i++) {
            String str1="";
            for (int j = 0; j <smallArr[0].length ; j++) {
                str1+=" "+smallArr[i][j];
            }
            System.out.println(str1);
        }

}
public void printSortArrays(){
        // сортировка по полую 1 - пробег, по полю2 - доп
     System.out.println(typeArr[0][0]+' '+typeArr[0][1]+typeArr[0][2]);
     shlopArr(Arr100,1);
    System.out.println(typeArr[1][0]+' '+typeArr[1][1]+typeArr[1][2]);
    shlopArr(Arr200,1);
    System.out.println(typeArr[2][0]+' '+typeArr[2][1]+typeArr[2][2]);
    shlopArr(Arr300,1);
    System.out.println(typeArr[3][0]+' '+typeArr[3][1]+typeArr[3][2]);
    shlopArr(Arr400,1);


    }
}




