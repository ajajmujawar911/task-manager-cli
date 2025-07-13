package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to Task Manager!");
        printMenu();

        while (true) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine().trim();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    tasks.add(new Task(desc));
                    System.out.println("Task added!");
                    break;

                case "list":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ". " + tasks.get(i));
                        }
                    }
                    break;

                case "done":
                    System.out.print("Enter task number to mark as done: ");
                    int index = Integer.parseInt(scanner.nextLine()) - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index).complete();
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Unknown command.");
                    printMenu();
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nCommands:");
        System.out.println("add   - Add a new task");
        System.out.println("list  - List all tasks");
        System.out.println("done  - Mark a task as done");
        System.out.println("exit  - Exit the program");
    }
}

