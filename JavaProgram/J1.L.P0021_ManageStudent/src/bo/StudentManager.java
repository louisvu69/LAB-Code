package bo;

import java.util.ArrayList;
import java.util.Collections;
import entity.Student;
import java.util.HashMap;

public class StudentManager {

    private final ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student s) throws Exception {
        if (!isDuplicate(s.getId(), s.getStudentName(), s.getSemester(), s.getCourseName())) {
            students.add(s);
            return s;
        }
        throw new Exception("Duplicate data!");
    }

    public Student updateStudent(String id, Student s) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            if (!isDuplicate(s.getId(), s.getStudentName(), s.getSemester(), s.getCourseName())) {
                students.set(index, s);
                s.setId(id);
                return s;
            }
            throw new Exception("Duplicate information!");
        }
        throw new Exception("Student not found!");
    }

    public Student deleteStudentById(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return students.remove(index);
        }
        throw new Exception("Student does not exist!");
    }

    private int searchById(String id) {
        for (int index = 0; index < students.size(); index++) {
            if (students.get(index).getId().equalsIgnoreCase(id)) {
                return index;
            }
        }
        return -1;
    }

    public Student getStudentById(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return students.get(index);
        }
        throw new Exception("Id not found");
    }

    public HashMap<String, Integer> getReport() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student student : students) {
            String key = student.getId() + "#" + // '#' is the regex
                    String.format("%15s", student.getStudentName()) + "|" +
                    String.format("%7s", student.getCourseName());
            if (reports.containsKey(key)) {
                int courseTotal = reports.get(key);
                reports.put(key, courseTotal + 1);
            } else {
                reports.put(key, 1);
            }
        }
        return reports;
    }

    private boolean isDuplicate(String id, String studentName, String semester, String courseName) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)
                    && s.getStudentName().equalsIgnoreCase(studentName)
                    && s.getSemester().equalsIgnoreCase(semester)
                    && s.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> searchByNameAndSort(String name) {
        ArrayList<Student> ret = new ArrayList<>();
        for (Student s : students) {
            if (s.getStudentName().contains(name)) {
                ret.add(s);
            }
        }
        Collections.sort(ret);
        return ret;
    }
}
