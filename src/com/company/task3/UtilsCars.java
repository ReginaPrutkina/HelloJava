package com.company.task3;

public class UtilsCars {
    //создает массив машин с полями int из массива строк
    public   int[][] createIntArr(String[] strArr) {
        int[][] intArr = new int[strArr.length][4];
        for (int i = 0; i < strArr.length; i++) {
            String[] tempArr;
            tempArr = strArr[i].split("-");
            intArr[i][0] = Integer.parseInt(tempArr[0].substring(1, 4));
            intArr[i][1] = Integer.parseInt(tempArr[0].substring(5));
            for (int j = 1; j < tempArr.length; j++) {
                intArr[i][j + 1] = Integer.parseInt(tempArr[j]);
            }

        }
        return intArr;
    }

    /**
     * Сортирует массив(изменяет входной массив) по заданному полю
     *
     * @param Arr       - неотсортированный массив
     * @param sortField - индекс поля сортировки
     */
    public void sortArray(int[][] Arr, int sortField) {
        int col = Arr[0].length; //ко-во колонок
        int str = Arr.length;     //кол-во строк
        int[] tempArr;
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < str - 1; i++) {
                if (Arr[i][sortField] > Arr[i + 1][sortField]) {
                    isSorted = false;
                    tempArr = Arr[i];
                    Arr[i] = Arr[i + 1];
                    Arr[i + 1] = tempArr;
                }
            }

        }
    }

    /**
     * Возвращает отсортированный схлопнутый массив
     * int[][] carsArr - массив машин одного типа, схлопывание идет только по гос номеру
     * @param sortField -  поле сортировки (нет проверки на неверный ввод!!)
     */
    public int[][] shlopArr(int[][] carsArr, int sortField) {
        //Сорируем по номеру Авто
        sortArray(carsArr, 1);
        //создаем новый схлопнутый массив
        int newCount = 0;
        int numberCar = 0;
        for (int i = 0; i < carsArr.length; i++) {
            if (numberCar != carsArr[i][1]) {
                numberCar = carsArr[i][1];
                newCount++;
            }
        }
        int[][] smallArr = new int[newCount][carsArr[0].length];
        int idx = 0;  //номер строки нового массива
        numberCar = carsArr[0][1];
        for (int i = 0; i < carsArr.length; i++) {
            if (numberCar != carsArr[i][1]) {
                idx++;
                numberCar = carsArr[i][1];
            }
            //поля тип и номер не суммируем
            smallArr[idx][0] = carsArr[i][0];
            smallArr[idx][1] = carsArr[i][1];
            //поля пробега и доп значений - суммируем
            for (int j = 2; j < carsArr[0].length; j++) {
                smallArr[idx][j] += carsArr[i][j];
            }

        }
        sortArray(smallArr, sortField);

        return smallArr;

    }
    public void printArr(int[][] carsArr, String typeName) {
        System.out.println(typeName);
        System.out.println("Тип Гос_номер  Пробег " );
        for (int i = 0; i < carsArr.length; i++) {
            String str1 = "";
            for (int j = 0; j < carsArr[0].length; j++) {
                str1 += " " + carsArr[i][j];
            }
            System.out.println(str1);
        }
    }
    public void printArr(int[][] carsArr, String typeName,String dopZnach) {
        System.out.println(typeName);
        System.out.println("Тип Гос_номер  Пробег " + dopZnach);
        for (int i = 0; i < carsArr.length; i++) {
            String str1 = "";
            for (int j = 0; j < carsArr[0].length; j++) {
                str1 += " " + carsArr[i][j];
            }
            System.out.println(str1);
        }
    }
    }
