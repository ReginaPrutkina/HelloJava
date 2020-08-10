package com.company.iolesson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {
    public static void main(String[] args) {
        //Не пишет в файл
        File nf = new File("test1.txt");
        try (
                FileWriter fw = new FileWriter(nf)){
            fw.write("dfsfd");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //NIO - ok. Пишет в файл
        Path pf = Paths.get("test2.txt");
        try {
            Files.createFile(pf);
            Files.writeString(pf, "aaaaa");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filename.txt"), "utf-8"))) {
            writer.write("something");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        // Не пишет в файл
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("test3.txt")))){
            bufferedWriter.write("lalala" );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
