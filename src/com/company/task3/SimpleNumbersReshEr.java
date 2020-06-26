package com.company.task3;

public class SimpleNumbersReshEr implements SimpleNumberUtils,SimpleNumberPrint{
    public int[] arrSimpleNumbers;
    private boolean[] arrBoolean;
    SimpleNumbersReshEr(int maxNumber) {
        if (maxNumber >= 2) {
            arrBoolean = new boolean[maxNumber+1];
            this.fillArrayTrue();
            arrBoolean[0] = arrBoolean[1] = false; //Удаляем числа, которые точно не простые 0 и 1
            this.reshetoEratosfena();
           // Итоговый массив
            arrSimpleNumbers = this.createSimpleNumbersArray();
        }else {
            System.out.println("Невозможно создать массив");
            arrSimpleNumbers= new int[]{};
        }

    }
    // Заполняем массив true
    private void fillArrayTrue() {
        for (int i = 0; i < arrBoolean.length; i++) {
            arrBoolean[i] = true;
        }
    }
    // Алгоритм Решето Эратосфена
    private void reshetoEratosfena() {
        int kratNumber;
        for (int numberOut = 2; numberOut < Math.sqrt(arrBoolean.length) + 1; numberOut++) {
            // Вычеркиваем числа кратные данному числу
            if (arrBoolean[numberOut]) {
                for (kratNumber = 2 * numberOut; kratNumber < arrBoolean.length; kratNumber += numberOut) {
                    arrBoolean[kratNumber] = false;
                }
            }
        }
    }
    private int countTrueElements(){
        int count = 0;
        for (int i = 0; i < arrBoolean.length; i++) {
            if (arrBoolean[i])
                count++;
        }
        return count;
    }

    @Override
    public int[] createSimpleNumbersArray() {
        int[] arrSimpleNumbers = new int[this.countTrueElements()];
        for (int i = 0, j = 0; i < arrBoolean.length; i++) {
            if (arrBoolean[i])
                arrSimpleNumbers[j++] = i;
        }
        return arrSimpleNumbers;
    }

    @Override
    public void printArray(int maxSymbolsInStr, int maxStrOnPage) {
        // Вывод
        int  currentStrPos= 0; //текущая позиция в строке
        int currentStr = 0;  // номер строки на странице
        for (int a: arrSimpleNumbers) {
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

