package com.company.task3;

public interface SimpleNumberUtils {
    // Заполняем массив true
    default void fillArrayTrue(boolean[] arrBoolean) {
      for (int i = 0; i < arrBoolean.length; i++) {
            arrBoolean[i] = true;
        }
       }
    // Алгоритм Решето Эратосфена
    default void reshetoEratosfena(boolean[] arrBoolean) {
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
    int countTrueElements(boolean[] arrBoolean);
    void printArray(int maxSymbolsInStr, int maxStrOnPage,int[] intArr);
}
