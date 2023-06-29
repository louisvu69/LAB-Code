package ui;

public class Display {

    public void displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert from " + from + " to " + toCase1);
        System.out.println("2. Convert from " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
    }

    //display menu
    public void menu() {
        System.out.println("WELCOME TO BASE CONVERTER PROGRAM");
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

}
