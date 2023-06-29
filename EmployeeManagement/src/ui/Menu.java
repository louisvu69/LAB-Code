/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Employee;
import utils.Validation;
import java.util.ArrayList;
import controller.EmployeeManagementController;

/**
 *
 * @author My PC
 */
public class Menu {

    private EmployeeManagementController controller = new EmployeeManagementController();
    boolean isExit;

    public void displayMenu() {
        System.out.println("WELCOME TO EMPLOYEE MANAGEMENT");
        System.out.println("1.Add employees \n"
                + "2.Update employees\n"
                + "3.Remove employees\n"
                + "4.Search employees\n"
                + "5.Sort employees by salary\n"
                + "6.Exit");
        System.out.println("Enter your choice: ");
    }

    public int getChoice() {
        return Validation.getInt("", "Invalid input", "Please enter from 1 to 6 ", 1, 6);
    }

    public void run(int choice) throws Exception {
        try {
            switch (choice) {
                case 1:
                    try {
                        do {
                            Employee addEmployee = controller.addEmployee();
                            System.err.println("Add Employee success!");
                            System.out.println(addEmployee);
                        } while (Validation.pressYNtoContinue("Do you want to add more? (Y/N): "));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Employee updateEmployee = controller.updateEmployee();
                        System.err.println("Update success!");
                        System.out.println(updateEmployee);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Employee deleteEmployee = controller.deleteEmployee();
                        System.err.println("Delete success!");
                        System.out.println("Here is the information of the person that you had deleted: ");
                        System.out.println(deleteEmployee);
                    } catch (Exception e) {
//                        e.printStackTrace();
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        ArrayList<Employee> list = controller.searchingEmployee();
                        System.out.println("\tLIST FOUND:");
                        controller.displayList(list);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    controller.displayAndSortBySalary();
                    break;
                case 6:
                    isExit = true;
                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
