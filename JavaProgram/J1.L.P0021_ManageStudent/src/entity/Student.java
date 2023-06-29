package entity;

public class Student implements Comparable<Student> {

    public static String DISPLAY_FORMAT = "%-5s|%-15s|%-8s|%-8s\n";
    public static String DISPLAY_HEADER = String.format(DISPLAY_FORMAT, "ID", "Student name", "Semester", "Course");
    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int compareTo(Student t) {
        return t.studentName.compareTo(this.studentName);
    }

    @Override
    public String toString() {
        return String.format(DISPLAY_FORMAT, id, studentName, semester, courseName);
    }
}
