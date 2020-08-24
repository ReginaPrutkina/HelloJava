package com.company.project;

import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        //Для отпарвкли с аккаута gmail потрбовалось дать разрешение на
        CurrencyService currencyService = new CurrencyService("//sberbank.ru");
        Scanner sc = new Scanner(System.in);
        String user_mail = "rprutkina@gmail.com";
        System.out.print("введите пароль для "+user_mail+": ");
        String user_pass = sc.nextLine();
        SendMail sender = new SendMail(user_mail,user_pass);
        sender.send("Test subject/Тест","Test message/Тесстовое сообщение","rprutkina@mail.ru");

    }
}
