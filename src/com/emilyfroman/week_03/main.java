package com.emilyfroman.week_03;

/**
 * Created by Emily on 10/2/2016.
 */

import java.util.Scanner;
public class main {
    static double fToC(double fahrenheit){
        double celsius = 5.0 /9 * (fahrenheit - 32);
        return celsius;
    }

    static void displayTemp(double temperature){
        System.out.println("The temperature is " + temperature + ".");
    }

    static double userInput(){
        System.out.println("Enter a Fahrenheit temperature.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double doubleInput = Double.parseDouble(input);
        return doubleInput;
    }

    public static void main(String[] args){
        double userTemperature = userInput();
        while (userTemperature >= -460){
            double celsius = fToC(userTemperature);
            displayTemp(celsius);
            userTemperature = userInput();
        }

    }
}
