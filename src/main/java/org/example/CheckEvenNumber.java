package org.example;

import java.util.Scanner;

public class CheckEvenNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        if ((num1%2==0) && (num2%2==0)){
            System.out.println("Оба числа четные");
        } else if ((num1%2==0) || (num2%2==0)) {
            System.out.println("Одно из чисел нечетное");
        } else {System.out.println("Оба числа нечетные");
            }
        }
    }