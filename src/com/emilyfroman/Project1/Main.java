package com.emilyfroman.Project1;

/**
 * Created by Emily on 11/27/2016.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();
        boolean done = false;
        int input;

        while (!done)
        {
            displayMenu();
            input = getInput();
            if (input == 0) {
                break;
            }
            else {
                switch (input) {
                    case 1: tasks = addTask(tasks);
                        break;
                    case 2: tasks = removeTask(tasks);
                        break;
                    case 3: tasks = updateTask(tasks);
                        break;
                    case 4: listAllTasks(tasks);
                        break;
                }
            }
        }
    }
    public static void displayMenu()
    {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit.");
    }
    public static List<String> addTask(List<String> tasks)
    {
        String task;
        System.out.println("Enter a description: ");
        task = getStringKeyInput();
        tasks.add(task);
        return (tasks);
    }

    public static List<String> removeTask(List<String> tasks)
    {
        int taskNumber;
        System.out.println("Enter the index of the task to remove.");
        taskNumber = getInput();
        tasks.remove(taskNumber);
        return (tasks);
    }

    public static List<String> updateTask(List<String> tasks)
    {
        int taskNumber;
        String task;
        System.out.println("Enter the index of the task to update.");
        taskNumber = getInput();
        System.out.println("Enter the new description of the task.");
        task = getStringKeyInput();
        tasks.remove (taskNumber);
        tasks.add(taskNumber, task);
        return (tasks);
    }

    public static void listAllTasks(List<String> tasks){
        int last;
        last = tasks.size();
        for (int i=0; i < last; i++)
        {
            System.out.println(i + ". " + tasks.get(i));
        }
    }

    public static int getInput()
    {
        String inString;
        Scanner scanner = new Scanner(System.in);
        inString = scanner.nextLine();
        return (Integer.parseInt(inString));
    }

    public static String getStringKeyInput()
    {
        String inString;
        Scanner scanner = new Scanner(System.in);
        inString = scanner.nextLine();
        return (inString);
    }

}