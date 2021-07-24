/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 1 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */

import java.util.Scanner;

public class App {
    public static double calcBAC(double ozConsumed, double weight, int hoursPassed, boolean isMan) {
        double r = isMan ? 0.73 : 0.66;

        double BAC = (ozConsumed * 5.14 / weight * r) - (0.015 * hoursPassed);
        return BAC;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double A = 0, W = 0;
        int H = 0, sex = 0;

        try {
            System.out.print("Enter a 1 if you are male or 2 if you are female: ");
            sex = Integer.parseInt(in.nextLine());
            System.out.print("How many ounces of alcohol did you have? ");
            A = Double.parseDouble(in.nextLine());
            System.out.print("What is your weight, in pounds? ");
            W = Double.parseDouble(in.nextLine());
            System.out.print("How many hours has it been since your last drink? ");
            H = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("that is not a numeric input. try again.");
        }

        double bac = calcBAC(A, W, H, (sex == 1));
        String output = (bac > 0.08) ? "It is not legal for you to drive"
                                     : "It is legal for you to drive";

        System.out.printf("your BAC is %.6f\n%s", bac, output);

    }
}
