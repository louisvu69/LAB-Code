/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import entity.Employee;
import bo.EmployeeInputer;
import bo.EmployeeManager;
import utils.Validation;

/**
 *
 * @author My PC
 */
public class EmployeeManagementController {

    private EmployeeManager employeeManager;
    private EmployeeInputer employeeInputer;

    public EmployeeManagementController() {
        employeeManager = new EmployeeManager();
    }

    public Employee addEmployee() throws Exception {
        employeeInputer = new EmployeeInputer();
        employeeInputer.inputEmployeeInformation();
        Employee e = employeeInputer.getEmployee();
        return employeeManager.addEmployee(e);
    }

    public void displayAndSortBySalary() {
        ArrayList<Employee> list = employeeManager.getEmployeesList();
        System.out.println(Employee.DISPLAY_HEADER);
        employeeManager.displayAndSortBySalary(list);
    }

    public Employee deleteEmployee() throws Exception {
        int id = Integer.parseInt(Validation.getStringByRegex("Enter the id you want to delete: ", "Id must be in format xxxx (x is digit)!", "[0-9]{4}"));
        return employeeManager.deleteEmployeeById(id);
    }

    public Employee updateEmployee() throws Exception {
        int id = Integer.parseInt(Validation.getStringByRegex("Enter the id you want to update: ", "Id must be in format xxxx (x is digit)!", "[0-9]{4}"));
        employeeInputer = new EmployeeInputer();
        employeeInputer.updateEmployeeInformation();
        Employee e = employeeInputer.getEmployee();
        return employeeManager.updateEmployee(e, id);
    }

    public ArrayList<Employee> searchingEmployee() {
       
        String name = Validation.getStringByRegex("Enter employee's name: ", "Character only!", "[A-Za-z ]+");
        ArrayList<Employee> listFound = employeeManager.searchByName(name);
        return listFound;
    }

    public void displayList(ArrayList<Employee> listFound) {
        System.out.println(Employee.DISPLAY_HEADER);
        for (Employee e : listFound) {
            System.out.println(e);
        }
    }

}
