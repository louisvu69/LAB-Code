/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Employee;
import utils.Validation;

/**
 *
 * @author My PC
 */
public class EmployeeInputer {
                            
    private Employee e;

    public Employee getEmployee() {
        return e;
    }

    public EmployeeInputer() {
        e = new Employee();
    }


    private void inputInformation() {
        e.setId(Integer.parseInt(Validation.getStringByRegex("Enter id: ", "Id must be in format xxxx (x is digit)!", "[0-9]{4}")));
        e.setFirstName(Validation.getStringByRegex("Enter first name: ", "Character only!", "[A-Za-z ]+"));
        e.setLastName(Validation.getStringByRegex("Enter last name: ", "Character only!", "[A-Za-z ]+"));
        e.setPhone(Integer.parseInt(Validation.getStringByRegex("Enter phone: ", "Phone must be in format xxxxxxx(8) (x is digit)!", "[0-9]{7}")));
        e.setEmail(Validation.getMail("Enter mail: ", "Invalid format!s"));
        System.out.println("Enter address: ");
        e.setAddress(Validation.inputString());
        e.setDob(Validation.getInputDate("Enter date of birth: ", "Invalid format! Data must be in format: dd/MM/yyyy"));
        e.setSex(Validation.setSex());
        e.setSalary(Validation.getDouble("Enter salary: ", 1, Double.MAX_VALUE));
        e.setAgency(Validation.getStringByRegex("Enter agency: ", "Character only!", "[A-Za-z ]+"));
    }
    
    private void updateInformation() {
        e.setFirstName(Validation.getStringByRegex("Enter first name: ", "Character only!", "[A-Za-z ]+"));
        e.setLastName(Validation.getStringByRegex("Enter last name: ", "Character only!", "[A-Za-z ]+"));
        e.setPhone(Integer.parseInt(Validation.getStringByRegex("Enter new phone: ", "Id must be in format xxxxxxx(7) (x is digit)!", "[0-9]{7}")));
        e.setEmail(Validation.getMail("Enter new mail: ", "Invalid format!s"));
        System.out.println("Enter new address: ");
        e.setAddress(Validation.inputString());
        e.setDob(Validation.getInputDate("Enter new date of birth: ", "Invalid format! Data must be in format: dd/MM/yyyy"));
        e.setSex(Validation.setSex());
        e.setSalary(Validation.getDouble("Enter new salary: ", 0.0000001, Double.MAX_VALUE));
        e.setAgency(Validation.getStringByRegex("Enter new agency: ", "Character only!", "[A-Za-z ]+"));
    }
    
    public Employee inputEmployeeInformation() {
        inputInformation();
        return e;
    }
    
    public Employee updateEmployeeInformation(){
        updateInformation();
        return e;
    }
    
}
