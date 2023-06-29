package ui;

import controller.TaskManagerController;
import entity.Task;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        TaskManagerController tmc = new TaskManagerController();
        while (true) {
            System.out.println("========= Task program =========");
            System.out.println(" 1. Add task");
            System.out.println(" 2. Delete task");
            System.out.println(" 3. Display task");
            System.out.println(" 4. Exit");
            int choice = Validation.getinputIntLimit("Enter your choice: ", "Must input an integer number!", "Must input an integer in range [1,4]: ", 1, 4);
            switch (choice) {
                case 1:
                    tmc.addTask();
                    System.out.println("Add task successfully!");
                    break;
                case 2:
                    try {
                        Task deleteTask = tmc.deleteTask();
                        System.out.println("Delete task successfully! Here is the info of deleted task: ");
                        System.out.println(deleteTask);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Here is the task list: ");
                    tmc.displayTask();
                    break;
                case 4:
                    return;
            }

        }
    }
}
