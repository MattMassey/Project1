package com.company.week1;
import java.util.*;

public class Main {
    private static ArrayList<String> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userTask;
        String userDescription;

        System.out.println("(1) Add a task.\n(2) Remove a task.\n(3) Update a task.\n" +
                "(4) List all tasks.\n(0) Exit.");
        int choice = Integer.parseInt(input.nextLine());
        while (choice != 0) {
            switch(choice) {
                case 1:
                    System.out.println("Name of task?");
                    userTask = input.nextLine();
                    System.out.println("Description?");
                    userDescription = input.nextLine();
                    addTask(userTask, userDescription);
                    break;
                case 2:
                    System.out.println("Which task do you want to remove? (Name)");
                    userTask = input.nextLine();
                    removeTask(userTask);
                    break;
                case 3:
                    System.out.println("Which task do you want to change? (Name)");
                    userTask = input.nextLine();
                    System.out.println("New description?");
                    userDescription = input.nextLine();
                    updateTask(userTask, userDescription);
                    break;
                case 4:
                    for (int i = 0; i < taskList.size(); i++) {
                        if (i%2==0) {
                            System.out.println(taskList.get(i));
                        } else {
                            System.out.println("-- " + taskList.get(i));
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("(1) Add a task.\n(2) Remove a task.\n(3) Update a task.\n" +
                    "(4) List all tasks.\n(0) Exit.");
            choice = Integer.parseInt(input.nextLine());
        }
        System.out.println("Goodbye!");
    }

    static void addTask(String task, String description) {
        taskList.add(task);
        taskList.add(description);
    }

    static void updateTask(String task, String newDescription) {
        for (int i = 0; i < taskList.size(); i += 2) {
            if (taskList.get(i).equalsIgnoreCase(task)) {
                taskList.set(i+1, newDescription);
            }
        }
    }

    static void removeTask(String task) {
        for (int i = 0; i < taskList.size(); i += 2) {
            if (taskList.get(i).equalsIgnoreCase(task)) {
                taskList.remove(i);
                taskList.remove(i+1);
            }
        }
    }
}
