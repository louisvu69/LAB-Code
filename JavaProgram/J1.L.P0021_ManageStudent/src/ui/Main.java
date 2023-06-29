package ui;

import controller.StudentManagerController;
import entity.Student;
import utils.Validation;

public class Main {

    public static void main(String[] args) throws Exception {
        StudentManagerController smc = new StudentManagerController();
        smc.generateStudent();
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println(" 1. Create");
            System.out.println(" 2. Find and Sort");
            System.out.println(" 3. Update/Delete");
            System.out.println(" 4. Report");
            System.out.println(" 5. Exit");
            System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
            int choice = Validation.getinputInt("Enter your choice: ", "Must input an integer number!", "Must input an integer in range [1,5]: ", 1, 5);
            switch (choice) {
                case 1:
                    try {
                        smc.createStudent();
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 2:
                    smc.searchAndSortStudent();
                    break;
                case 3:
                    boolean updateordelete = Validation.checkInputUD("Do you want to update(U) or delete(D): ", "Must be U/u or D/d. Enter again: ");
                    if (!updateordelete) {
                        try {
                            Student deletedStudent = smc.deleteStudent();
                            System.out.println("Delete student success! Here is the info of deleted student: ");
                            System.out.println(deletedStudent);
                            System.out.println("Here is the student list after remove: ");
                            smc.displayStudentList();
                        } catch (Exception ex) {
                            System.err.println(ex.getMessage());
                        }
                    } else {
                        try {
                            Student updateStudent = smc.updateStudent();
                            System.out.println("Update student success! Here is the info of updated student: ");
                            System.out.println(updateStudent);
                            System.out.println("Here is the student list after update: ");
                            smc.displayStudentList();
                        } catch (Exception ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                    break;
                case 4:
                    smc.reportStudent();
                    break;
                case 5:
                    return;
            }

        }
    }
}
