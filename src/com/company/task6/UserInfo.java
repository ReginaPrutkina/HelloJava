package com.company.task6;

import java.io.*;
import java.util.Scanner;

public class UserInfo implements Serializable, Externalizable {
    public String userPassword;
    public String userLogin;
    private static final long serialVersionUID = 1L;

    public UserInfo() { };
    public UserInfo(String userLogin, String userPassword){
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    };

    private String askUserLogin(){
        Scanner sc = new Scanner(System.in);
        String userLogin;
        do {
            System.out.print("Введите login: > ");
            userLogin = sc.nextLine();
        } while (userLogin.isEmpty());
        return userLogin;
    };

    private String askUserPassword(){
        Scanner sc = new Scanner(System.in);
        String userPassword;
        do {
            System.out.print("Введите пароль: > ");
            userPassword = sc.nextLine();
        } while (userPassword.isEmpty());
        return userPassword;
    };
       @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(userLogin);
        out.writeObject(encodeString(userPassword));
    }
    public String encodeString(String data){
        return data+"*";
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        userLogin = (String) in.readObject();
        userPassword = decodeString((String) in.readObject());
    }
    private String decodeString(String data){
        return data.substring(0,data.length()-1);
    }

    @Override
    public String toString() {
        return "login: "+userLogin+"\n"+"password: "+userPassword;
    }
}
