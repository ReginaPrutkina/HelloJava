package com.company.task3;

public class SimpleNumbers implements SimpleNumberUtils{
    int[] arrSimpleNumbers;
    SimpleNumbers(int maxNumber) {
        if (maxNumber >= 2) {
            boolean[] arrBoolean = new boolean[maxNumber+1];
            this.fillArrayTrue(arrBoolean);
            arrBoolean[0] = arrBoolean[1] = false; //Удаляем числа, которые точно не простые 0 и 1
            this.reshetoEratosfena(arrBoolean);
           // Итоговый массив
            arrSimpleNumbers = new int[this.countTrueElements(arrBoolean)];
            for (int i = 0, j = 0; i < arrBoolean.length; i++) {
                if (arrBoolean[i])
                    arrSimpleNumbers[j++] = i;
            }
        }else {
            System.out.println("Невозможно создать массив");
            arrSimpleNumbers= new int[]{};
        }

    }
    @Override
    public int countTrueElements(boolean[] arrBoolean){
        int count = 0;
        for (int i = 0; i < arrBoolean.length; i++) {
            if (arrBoolean[i])
                count++;
        }
        return count;
    }

    @Override
    public void printArray(int maxSymbolsInStr, int maxStrOnPage,int[] intArr) {
        // Вывод
        int  currentStrPos= 0; //текущая позиция в строке
        int currentStr = 0;  // номер строки на странице
        for (int a: intArr) {
            System.out.print(a + " ");
            currentStrPos += String.valueOf(a).length() + 1;
            if (currentStrPos >= maxSymbolsInStr) {
                // Переход на новую строку
                System.out.println();
                currentStrPos = 0;
                currentStr++;
            }
            if (currentStr >= maxStrOnPage) {
                System.out.println("--------Новая cтраница--------");
                currentStr = 0;
            }
        }
    }
}

