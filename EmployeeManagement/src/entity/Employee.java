/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author My PC
 */
public class Employee {

    public static String TO_STRING_FORMAT = "%-4s|%-20s|%-10s|%-20s|%-17s|%-15s|%-5s|%-10s|%-15s\n";
    public static String HEADER_FORMAT = "%-4s|%-20s|%-10s|%-20s|%-17s|%-15s|%-5s|%-10s|%-15s\n";
    public static String DISPLAY_HEADER = String.format(HEADER_FORMAT, "ID", "Full Name", "Phone", "Email", "Address", "Date of Birth", "Sex", "Salary", "Agency");

    private int id;
    private String firstName;
    private String lastName;
    private int phone;
    private String email;
    private String address;
    private String dob;
    private String sex;
    private double salary;
    private String agency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, int phone, String email, String address, String dob, String sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, id, firstName
                + " " + lastName, phone, email, address, dob, sex, salary, agency);
    }

    public static void    main(String[] args) {
        System.out.println(entity.Employee.DISPLAY_HEADER);
    }
}
