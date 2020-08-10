package com.company.iolesson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_io {
    public static void main(String[] args) {
        //читаем режим
        System.out.println("Выберите режим ( 1 - write  или 2 - read)");
        Scanner sc = new Scanner(System.in);
        int regim = sc.nextInt();
        if (regim==1)
             writeCommand();
        else if (regim==2)
            readCommand();
        else System.out.println("неверный режим");

    }
    public static void writeCommand()  {
        Boolean validInput = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = sc.nextLine();
        System.out.println("вы ввели " + str);
        int strSize = str.length();
        System.out.println("Введите кол-во символов для поиска");
        int countChars = sc.nextInt();
        System.out.println("вы ввели " + countChars);
        System.out.println("введите через пробел " + countChars + " символа");
        sc.nextLine();
        String charsStr = sc.nextLine();
        System.out.println("вы ввели " + charsStr);
        List<String> charsArray = Arrays.asList(charsStr.split(" "));
        // проверяем кол-во введенных значений
        if (charsArray.size() != countChars) {
            System.out.println("неверное кол-во символов");
            validInput = false;

        }
        // проверяем, что введены символы
        if (validInput)
            for (int i = 0; i < countChars - 1; i++) {
                if (charsArray.get(i).length() != 1) {
                    System.out.println("неверный ввод");
                    validInput = false;
                }
            }
                if (validInput) {
                    //готовим файл
                    String fileName = "D:\\Users\\Lenovo\\IdeaProjects\\HelloJava\\2file.txt";
                    File newDescFile = new File(fileName);
                    //if (!newDescFile.exists())
                    try (
                            FileWriter newFile = new FileWriter(newDescFile);){

                    for (String chr : charsArray) {
                        int cnt = 0;
                        cnt = freqCharInText(chr.charAt(0), str);
                        // пишем в файл
                        System.out.println("'" + chr.charAt(0) + "' " + cnt + " ");
                        newFile.write("'" + chr.charAt(0) + "' " + cnt + " "+cnt*100/str.length()+"%\n");
                    }
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }


    public static int freqCharInText(char ch, String text){

        // перводим строку в массив  символов
        char[] arrText = text.toCharArray();
        int count = 0;
        for (int i = 0; i < arrText.length; i++) {
            if (ch == arrText[i])
                count++;
        }
        return count;
    }
    public static void readCommand(){

    }
}

