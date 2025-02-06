package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int a = 3;
        int b = 4;
        int c = 5;

        if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
            System.out.println("Треугольник возможен");
        }
        else {System.out.println("Треугольник невозможен!");
        }
    }
}