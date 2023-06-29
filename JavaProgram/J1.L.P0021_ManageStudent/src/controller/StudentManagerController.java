package controller;

import bo.StudentInputter;
import bo.StudentManager;
import entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Validation;

public class StudentManagerController {

    private StudentInputter studentInputter;
    private final StudentManager studentManager;

    public StudentManagerController() {
        studentManager = new StudentManager();
    }

    public void displayStudentList() {
        System.out.print(Student.DISPLAY_HEADER);
        for (Student s : studentManager.getStudents()) {
            System.out.println(s);
        }
    }

    public void createStudent() throws Exception {
        while (true) {
            studentInputter = new StudentInputter();
            studentInputter.inputStudentInformation();
            Student s = studentInputter.getStudent();
            studentManager.addStudent(s);
            if (studentManager.getStudents().size() > 10) {
                boolean yesorno = Validation.checkInputYN("Continue(Y) or stop(N) adding student: ", "Must be Y/y or N/n. Enter again: ");
                if (!yesorno) {
                    System.out.println("List of students:");
                    displayStudentList();
                    break;
                }
            }
        }
    }

    public void searchAndSortStudent() {
        String name = Validation.getInputString("Enter student name: ", "Student name must contain only letter. Enter again: ", "[A-Za-z ]+");
        ArrayList<Student> listFound = studentManager.searchByNameAndSort(name);
        if (listFound.isEmpty()) {
            System.err.println("Not found!");
        } else {
            System.out.println("The list of students found:");
            for (int i = listFound.size() - 1; i >= 0; i--) {
                listFound.get(i).toString();
            }
        }
    }

    public Student updateStudent() throws Exception {
        String id = Validation.getInputString("Enter id: ", "ID must have number or letter. Enter again: ", "[0-9A-Za-z ]+");
        Student s = studentManager.getStudentById(id);
        studentInputter = new StudentInputter();
        s = studentInputter.inputStudentInformation();
        return studentManager.updateStudent(id, s);
    }

    public Student deleteStudent() throws Exception {
        String id = Validation.getInputString("Enter id: ", "ID must have number or letter. Enter again: ", "[0-9A-Za-z ]+");
        return studentManager.deleteStudentById(id);
    }

    public void reportStudent() {
        HashMap<String, Integer> reports = new HashMap<>();
        reports = studentManager.getReport();
        System.out.println("Here is the report: ");
        for (String key : reports.keySet()) {
            System.out.println(key.split("#")[1] + "|" + reports.get(key));
        }
    }

    public void generateStudent() throws Exception {
        studentManager.addStudent(new Student("S1", "Student One", "Fall", ".NET"));
        studentManager.addStudent(new Student("S1", "Student One", "Summer", ".NET"));
        studentManager.addStudent(new Student("S2", "Student Two", "Summer", ".NET"));
        studentManager.addStudent(new Student("S2", "Student Two", "Fall", "Java"));
        studentManager.addStudent(new Student("S2", "Student Two", "Spring", "Java"));
        studentManager.addStudent(new Student("S2", "Student Two", "Summer", "Java"));
        studentManager.addStudent(new Student("S3", "Student Three", "Fall", "Java"));
        studentManager.addStudent(new Student("S4", "Student Four", "Summer", "C/C++"));
        studentManager.addStudent(new Student("S4", "Student Four", "Spring", "C/C++"));
        studentManager.addStudent(new Student("S5", "Student Five", "Fall", "Java"));
    }

}
