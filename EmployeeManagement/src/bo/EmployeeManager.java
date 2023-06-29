/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Employee;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author My PC
 */
public class EmployeeManager {

    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeesList() {
        return employees;
    }

    public Employee addEmployee(Employee e) throws Exception {
        if (!checkIsExist(e)) {
            employees.add(e);
            return e;
        }
        throw new Exception("Employee Id already exist");
    }

    public boolean checkIsExist(Employee e) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public Employee updateEmployee(Employee d, int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            d.setId(id);
            employees.set(index, d);
            return d;
        }
        throw new Exception("Employee not found!");
    }

    public Employee deleteEmployeeById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return employees.remove(index);
        }
        throw new Exception("Employee does not exist!");
    }

    public int searchById(int id) {
        for (int index = 0; index < employees.size(); index++) {
            if (employees.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public Employee getEmployeeById(int id) {
        int index = searchById(id);
        if (index != -1) {
            return employees.get(index);
        }
        return null;

    }

    public void displayAndSortBySalary(ArrayList<Employee> list) {
        Collections.sort(list, (Employee s1, Employee s2) -> Double.compare(s1.getSalary(), s2.getSalary()));
        for (Employee c : list) {
            System.out.println(c);
        }
    }

    public ArrayList<Employee> searchByName(String name) {
        ArrayList<Employee> ret = new ArrayList<>();
        for (Employee c : employees) {
            if ((c.getFirstName().toLowerCase().contains(name.toLowerCase()))
                    || (c.getLastName().toLowerCase().contains(name.toLowerCase()))
                    || (c.toString().toLowerCase().contains(name.toLowerCase()))) {
                ret.add(c);
            }
        }
        Collections.sort(ret, (Employee s1, Employee s2) -> Double.compare(s1.getSalary(), s2.getSalary()));
        return ret;
    }
    
}
