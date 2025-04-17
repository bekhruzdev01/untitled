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
    }
}