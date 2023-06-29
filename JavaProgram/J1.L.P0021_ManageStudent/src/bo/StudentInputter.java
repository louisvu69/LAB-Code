package bo;

import entity.Student;
import utils.Validation;

public class StudentInputter {

    private Student s;

    public Student getStudent() {
        return s;
    }

    private void inputInfomation() {
        s = new Student();
        s.setId(Validation.getInputString("Enter id: ", "ID must have number or letter. Enter again: ", "[0-9A-Za-z]+"));
        s.setStudentName(Validation.getInputString("Enter student name: ", "Student name must contain only letter. Enter again: ", "[A-Za-z ]+"));
        s.setSemester(Validation.getInputSemester("Enter semester: ", "There are only 3 semesters : Spring, Summer and Fall. Enter again: "));
        s.setCourseName(Validation.getInputCourse("Enter course: ", "There are only 3 courses : Java, .NET and C/C++ . Enter again: "));
    }

    public Student inputStudentInformation() {
        inputInfomation();
        return s;
    }

}
