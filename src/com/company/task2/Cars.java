package com.company.task2;

public class Cars {
    static String[] strArr = {"C100_1-100", "C200_1-120-1200",
            "C300_1-120-30", "C400_1-80-20",
            "C100_2-50", "C200_2-40-1000",
            "C300_2-200-45", "C400_2-10-20",
            "C100_3-10", "C200_3-170-1100",
            "C300_3-150-29", "C400_3-100-28",
            "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
    double rashod100km=0;
    double cost1lGSM= 0;
    int type=0;
    String typeName="";
    String dopZnach="";
    int [][]carsArr;
    //Создаем статические входные данные - массив int
    static  int[][]intArr=new int[strArr.length][4];
    static {
        createIntArr();
        sortArray(intArr,1);
    }
    protected static void createIntArr(){
            for (int i = 0; i < strArr.length; i++) {
            String[] tempArr;
            tempArr = strArr[i].split("-");
            intArr[i][0] = Integer.parseInt(tempArr[0].substring(1, 4));
            intArr[i][1] = Integer.parseInt(tempArr[0].substring(5));
            for (int j = 1; j <tempArr.length ; j++) {
                intArr[i][j+1] = Integer.parseInt(tempArr[j]);
            }

            }

    }

    /**
     *Сортирует массив(изменяет входной массив) по заданному полю
     * @param Arr - неотсортированный массив
     * @param sortField - индекс поля сортировки
     */
    public static void sortArray(int[][] Arr, int sortField){
        int col = Arr[0].length; //ко-во колонок
        int str=Arr.length;     //кол-во строк
        int[] tempArr;
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
     * @param sortField -  поле сортировки (нет проверки на неверный ввод!!)
     */
    public void shlopArr(int sortField){
        //Сорируем по номеру Авто
        sortArray(carsArr,1);
        //создаем новый схлопнутый массив
        int newCount=0;
        int numberCar=0;
        for (int i = 0; i <carsArr.length ; i++) {
            if (numberCar!=carsArr[i][1]) {
                numberCar = carsArr[i][1];
                newCount++;
            }
        }
        int[][] smallArr=new int [newCount][carsArr[0].length];
        int idx=0;  //номер строки нового массива
        numberCar=carsArr[0][1];
        for (int i = 0; i <carsArr.length ; i++) {
            if (numberCar!=carsArr[i][1]) {
                idx++;
                numberCar = carsArr[i][1];
            }
            //поля тип и номер не суммируем
            smallArr[idx][0]=carsArr[i][0];
            smallArr[idx][1]=carsArr[i][1];
            //поля пробега и доп значений - суммируем
            for (int j = 2; j <carsArr[0].length ; j++) {
                smallArr[idx][j]+=carsArr[i][j];
            }

        }
        sortArray(smallArr,sortField);
        //Вывод на экран
        System.out.println(typeName);
        System.out.println("Тип Гос_номер  Пробег "+dopZnach);
        for (int i = 0; i < smallArr.length; i++) {
            String str1="";
            for (int j = 0; j <smallArr[0].length ; j++) {
                str1+=" "+smallArr[i][j];
            }
            System.out.println(str1);
        }

    }
    /**
     * Считает расход для заданного массива
     * @return сумму расходов от всех эл массива carsArr
     */
    public double rashodType(){
        double summaRashOnKm=rashod100km*cost1lGSM;
        double summaRash=0.0;
        for (int i = 0; i < carsArr.length; i++) summaRash+=(double) carsArr[i][2]*summaRashOnKm;
        return ((double) Math.round( summaRash)/100);
    }


}
