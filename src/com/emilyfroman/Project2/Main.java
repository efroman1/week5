package com.emilyfroman.Project2;
/*
 created by Emily Froman
 11/26/16
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task
{
    //variables
    String title;
    String description;
    int priority;

    Task()
    {
        title = Main.getStringKeyInput("Enter the new task's name.");
        description = Main.getStringKeyInput("Enter the new task's description.");
        priority = Main.getPriorityIntegerKeyInput("Enter the new task's priority");
    }

    public int getPriority()
    {
        return priority;
    }

    void display()
    {
        System.out.println("Title: " + title + " Description: " + description + " Priority: " + priority);

    }
}

public class Main
{
    static Scanner scanner = new Scanner(System.in);
    static String keyInput;

    public static void main(String[] args)
    {
        ArrayList<Task> taskArray = new ArrayList<>();
        boolean done = false;
        int input;

        while (!done) {
            displayMenu();
            input = getMenuInput("Menu");
            if (input == 0) {
                break;
            }
            else {
                switch (input)
                {
                    case 1: taskArray = addTask(taskArray);
                        break;
                    case 2: taskArray = removeTask(taskArray);
                        break;
                    case 3: taskArray = updateTask(taskArray);
                        break;
                    case 4: listAllTasks(taskArray);
                        break;
                    case 5: listPriorityNumberTasks(taskArray);
                        break;
                    case 0:
                        break;
                }
            }
        }
    }

    public static void displayMenu()
    {
        System.out.println("Please choose an option:");
        System.out.println("1) Add a task.");
        System.out.println("2) Remove a task.");
        System.out.println("3) Update a task.");
        System.out.println("4) List all tasks.");
        System.out.println("5) List all tasks of a certain priority.");
        System.out.println("0) Exit.");
    }

    public static ArrayList<Task> addTask(ArrayList<Task> taskArray)
    {
        Task task = new Task();
        taskArray.add(task);
        return taskArray;
    }
    public static ArrayList<Task> removeTask(ArrayList<Task> taskArray)
    {
        int taskNumber;
        taskNumber = getAnyIntegerKeyInput("Task to remove: ");
        if (taskNumber < taskArray.size())
            taskArray.remove(taskNumber);
        return taskArray;
    }
    public static ArrayList<Task> updateTask(ArrayList<Task> taskArray)
    {
        int taskNumber;
        taskNumber = getAnyIntegerKeyInput("Task to update: ");
        if (taskNumber < taskArray.size()) {
            taskArray.remove (taskNumber);
            Task task = new Task();
            taskArray.add(taskNumber, task);
        }
        return taskArray;
    }

    public static void listAllTasks(List<Task> taskArray)
    {
        int last;
        last = taskArray.size();
        for (int i=0; i < last; i++)
        {
            System.out.printf("Task: " + i + ", ");
            taskArray.get(i).display();
        }
    }

    public static void listPriorityNumberTasks(List<Task> taskArray)
    {
        int priority;
        int last;

        priority = getPriorityIntegerKeyInput("Enter a priority");
        last = taskArray.size();
        for (int i=0; i < last; i++)
        {
            if (taskArray.get(i).getPriority() == priority){
                System.out.printf("Task: " + i + ", ");
                taskArray.get(i).display();
            }
        }
    }
    public static int getAnyIntegerKeyInput(String promptMessage)
    {
        int intInput = 0;
        boolean done = false;
        while (!done){
            try{
                System.out.println(promptMessage);
                keyInput = scanner.nextLine();
                intInput = Integer.parseInt(keyInput);
                done = true;
            }
            catch (NumberFormatException e){
                System.out.println("Must enter integer try again");
                keyInput = scanner.nextLine();
            }
        }
        return intInput;
    }
    public static int getPriorityIntegerKeyInput(String message)
    {
        int intInput = 0;
        boolean done = false;
        while (!done){
            intInput = getAnyIntegerKeyInput(message);
            if ((intInput < 0) || (intInput > 5)) {
                System.out.println("Priority must be between 0 and 5");
            }
            else
                done = true;
        }
        return (intInput);
    }
    public static int getMenuInput(String message)
    {
        int intInput = 0;
        boolean done = false;
        while (!done){
            intInput = getAnyIntegerKeyInput(message);
            if ((intInput < 0) || (intInput > 5)) {
                System.out.println("Must enter between 0 and 5");
            }
            else
                done = true;
        }
        return (intInput);
    }
    public static String getStringKeyInput(String message)
    {
        boolean done = false;
        while (!done){
            System.out.println(message);
            keyInput = scanner.nextLine();
            if (keyInput == null) {
                System.out.println("Must enter a value");
            }
            else
                done = true;
        }
        return keyInput;
    }

}
