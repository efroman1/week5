package com.emilyfroman.week_04;

/**
 * Created by Emily on 10/2/2016.
 */
import java.util.*;

public class Main {
    static List<String> getCities() {
        List<String> cities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city:");
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            cities.add(input);
            System.out.println("Enter a city:");
            input = scanner.nextLine();
        }
        return cities;
    }

     static Map<String, int[]> getTemperatures(List<String> cities) {
          Map<String, int[]> temperatureMap = new TreeMap<>();

         Scanner scanner = new Scanner(System.in);
         for (String city: cities) {
             System.out.println("Enter the five average temps (separated by spaces) for " + city);
             String tempString = scanner.nextLine();

             int[] tempArray = new int[5];
             String[] tempStringArray = tempString.split(" ");
             for (int i=0; i<5; i++) {
                tempArray[i] = Integer.parseInt(tempStringArray[i]);
             }
             temperatureMap.put(city, tempArray);
         }
         return temperatureMap;
     }

   static void displayAverage(Map<String, int[]> tempMap) {
           for (String city: tempMap.keySet()) {
               int[] tempArray = tempMap.get(city);
               int average = 0;
               for (int temp: tempArray) {
                   average += temp;
               }
               average /= 5;

               System.out.println("The average temperature for " + city + " is " + average);
           }
   }

    public static void main(String[] args) {
            List<String> cities = getCities();
            Map<String, int[]> temperatures = getTemperatures(cities);
            displayAverage(temperatures);

    }
}

