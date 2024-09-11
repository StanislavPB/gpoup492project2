package org.gpoup492project2.services;

import java.util.Scanner;

public class UserInput {

    public int inputInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int input = scanner.nextInt();
        return input;
    }

    public double inputDouble(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        double input = scanner.nextDouble();
        return input;
    }

    public String inputText(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }
}