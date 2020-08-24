package com.company.task6;

import java.util.Scanner;

public class UserAuthorization {
    public String askUserLogin(){
        Scanner sc = new Scanner(System.in);
        String userLogin;
        do {
            System.out.print("Введите login: > ");
            userLogin = sc.nextLine();
        } while (userLogin.isEmpty());
        return userLogin;
    };

    public String askUserPassword(){
        Scanner sc = new Scanner(System.in);
        String userPassword;
        do {
            System.out.print("Введите пароль: > ");
            userPassword = sc.nextLine();
        } while (userPassword.isEmpty());
        return userPassword;
    };
}
