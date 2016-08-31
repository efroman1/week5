package com.emilyfroman.week_01;

public class Main {

    public static void main(String[] args) {
        //Initialize variables using the assignment operator
        String city = "Dublin";
        int zipCode = 43017;
        float [] temperatures = {99,95,78,88,90};


        //Calculates average from array

        float averageTemp = (temperatures[0] + temperatures[1] + temperatures[2]
                + temperatures[3] + temperatures[4]) / 5;


        //Display
        System.out.println("City: "+ city +" Zip Code: "+ zipCode
                + " Average High Temperature: " + averageTemp );

    }
}
