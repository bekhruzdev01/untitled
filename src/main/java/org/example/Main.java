package org.example;

import lombok.SneakyThrows;
import org.example.dbService.DbService;
import org.example.model.Result;

import java.util.Scanner;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        DbService dbService = new DbService();
        Scanner sc = new Scanner(System.in);
        Result result = new Result();
        int step = 0;
        while (step != -1) {
            System.out.println("1-Exit,2-Save,3-View,4-Delete");
            step = sc.nextInt();
            switch (step){
                case 1:
                    System.out.print("Name:");
                    String name = sc.next();
                    dbService.addCountry(name,result);
                    break;
            }
        }
    }
}