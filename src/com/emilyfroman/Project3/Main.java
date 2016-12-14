package com.emilyfroman.Project3;

/**
 * Created by Emily on 12/2/2016.
 */

import java.io.*;
        import java.util.*;
        import java.io.File;
        import java.io.FileWriter;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.nio.file.StandardOpenOption;
        import java.util.ArrayList;
        import java.util.List;


class TaskList implements Iterable<Task> {
    public ArrayList<Task> taskList = new ArrayList<Task>();
    public void add(Task t) {
        taskList.add (t);
    }
    public void add(int i, Task t) {
        taskList.add (i, t);
    }
    public void remove(int number) {
        taskList.remove (number);
    }
    public Integer getSize() {
        return taskList.size();
    }
    public int getIndex(Task t){
        return taskList.indexOf(t);
    }
    @Override
    public Iterator<Task> iterator() {
        return taskList.iterator();
    }
    public int getPriority(Task t){
        return t.priority;
    }

    public void sort() {
        Collections.sort(taskList);
    }
    public void clear () {
        taskList.clear();
    }
}
class Task implements Comparable {
    // title, description, and priority
    String title;
    String description;
    int priority;
    Task(){
        title = Main.getStringKeyInput("Enter the new task's name.");
        description = Main.getStringKeyInput("Enter the new task's description.");
        priority = Main.getPriorityIntegerKeyInput("Enter the new task's priority");
    }
    Task(String title, String description, int priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }

    void display(){
        System.out.printf ("Title: " + title + " ");
        System.out.printf("Description: " + description + " " );
        System.out.println("Priority: " + priority);
    }

    @Override
    public int compareTo(Object o) {
        Task task = (Task) o;
        if (priority != task.priority)
            return (priority - task.priority);
        else
            return (title.compareTo(task.title));
    }
}
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String keyInput;
    public static int MAXKEYINPUT = 8;
    public static int MAXPRIORITY = 5;

    public static void main(String[] args) {
        System.out.println("Welcome to Project 3");
        TaskList taskList = new TaskList();
        boolean doneFlag = false;
        int integerKeyInput;
        while (! doneFlag) {
            displayMenu();
            integerKeyInput = getMenuIntegerKeyInput("Menu");
            if (integerKeyInput == 0) {
                doneFlag = true;
                break;
            }
            else {
                // System.out.println("You entered:" + integerKeyInput);
                switch (integerKeyInput) {
                    case 1: taskList.add(addATask());
                        break;
                    case 2: removeATask(taskList);
                        break;
                    case 3: updateATask(taskList);
                        break;
                    case 4: listAllTasks(taskList);
                        break;
                    case 5: listPriorityNumberTasks(taskList);
                        break;
                    case 6: taskList.sort();
                        break;
                    case 7: writeListToFile(taskList);
                        break;
                    case 8: readListFromFile(taskList);
                        break;
                    case 0:
                        break;
                } // end of switch
            } // end of else

        } // end of while (! doneFlag)
        System.out.println("bye bye from Project 3");
    } // public static void main(String[] args)

    private static void readListFromFile(TaskList taskList) {
        //
        if (taskList.getSize() !=0){
            taskList.clear();
        }
        try {
            File file = new File("tasklist.txt");
            // create the file if it doesn't exist
            if (!file.exists()) {
                return;
            };
//            FileReader fileReader = new FileReader(file.getName(), true);
            FileReader fileReader = new FileReader(file.getName());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String newContent;
/*            for (Task t:taskList){
                newContent = t.title + "::" + t.description + "::" + t.priority + System.lineSeparator();;
                bufferWriter.write(newContent);
            } */
            // loop through lines and add to taskList
            while ( (newContent = bufferedReader.readLine()) != null ) {
                // do something
                String[] tokens = newContent.split("::");
                int i = 0;
                String title ="", description="";
                int priority=0;
                for (String token:tokens){
                    switch (i) {
                        case 0: title = token;
                            break;
                        case 1: description = token;
                            break;
                        case 2: priority = Integer.parseInt(token);
                            break;
                    }
                    i++;
                }
                Task t = new Task(title, description, priority);
                taskList.add(t);
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //

    }

    private static void writeListToFile(TaskList taskList) {
        //
        try {
            File file = new File("tasklist.txt");
            // create the file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }
            else {
                file.delete();
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            String newContent;
            for (Task t:taskList){
                newContent = t.title + "::" + t.description + "::" + t.priority + System.lineSeparator();;
                bufferWriter.write(newContent);
            }
            bufferWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //
    }

    public static Task addATask(){
        // int taskNumber;
        // System.out.println("Enter task number: ");
        // taskNumber = getIntegerKeyInput();
        // System.out.println("Enter a description of the new task.");
        Task task = new Task();
        return (task);
    } // public static List<String> addATask(List<String> tasks)
    public static void removeATask(TaskList taskList) {
        int taskNumber;
        taskNumber = getAnyIntegerKeyInput("Enter the index of the task to remove.");
        if (taskNumber < taskList.getSize())
            taskList.remove(taskNumber);
    } //        public static List<String> removeATask(List<String> tasks) {
    public static void updateATask(TaskList taskList){
        int taskNumber;
        taskNumber = getAnyIntegerKeyInput("Enter the index of the task to update.");
        if (taskNumber < taskList.getSize()) {
            taskList.remove (taskNumber);
            Task task = new Task();
            taskList.add(taskNumber, task);
        }
    } // public static List<String> updateATask(List<String> tasks)
    public static void listAllTasks(TaskList taskList){
        Task task;
        for (Object t:taskList)
        {
            task = (Task) t;
            // Task index: 2, Name: task2, Description: task2 descr, Priority: 2
            System.out.printf("Task index: " + taskList.getIndex(task) + ", ");
            task.display();
        }
    } // public static void listAllTasks(List<String> tasks){
    public static void listPriorityNumberTasks(TaskList taskList){
        int priority;
        Task task;
        priority = getPriorityIntegerKeyInput("Enter a priority");
        for (Object t:taskList)
        {
            task = (Task) t;
            if (taskList.getPriority(task) == priority){
                System.out.printf("Task index: " + taskList.getIndex(task) + ", ");
                task.display();
            }
        }
    }
    public static int getAnyIntegerKeyInput(String promptMessage) {
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
                System.out.println("must enter integer try again");
                keyInput = scanner.nextLine();
            }
        } // end of while
        return (intInput);
    }
    public static int getPriorityIntegerKeyInput(String message) {
        int intInput = 0;
        boolean done = false;
        while (!done){
            intInput = getAnyIntegerKeyInput(message);
            if ((intInput < 0) || (intInput > MAXPRIORITY)) {
                System.out.println("Priority must be between 0 and " + MAXPRIORITY);
            }
            else
                done = true;
        }
        return (intInput);
    }
    public static int getMenuIntegerKeyInput(String message) {
        int intInput = 0;
        boolean done = false;
        while (!done){
            intInput = getAnyIntegerKeyInput(message);
            if ((intInput < 0) || (intInput > MAXKEYINPUT)) {
                System.out.println("Must enter between 0 and " + MAXKEYINPUT);
            }
            else
                done = true;
        } // end of while
        return (intInput);
    }
    public static String getStringKeyInput(String message){
        boolean done = false;
        while (!done){
            System.out.println(message);
            keyInput = scanner.nextLine();
            if (keyInput.equals("")) {
                System.out.println("Must enter a value");
            }
            else
                done = true;
        } // end of while
        return (keyInput);
    }
    public static void displayMenu() {
        // body
        System.out.println("Please choose an option:");
        System.out.println("1) Add a task.");
        System.out.println("2) Remove a task.");
        System.out.println("3) Update a task.");
        System.out.println("4) List all tasks.");
        System.out.println("5) List all tasks of a certain priority.");
        System.out.println("6) Sort all tasks.");
        System.out.println("7) Write tasks to File.");
        System.out.println("8) Read tasks from File.");
        System.out.println("0) Exit.");
    } // public static void displayMenu()
} // public class Main