package ui;

import bo.BankAction;
import utils.Validate;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale Vietnamese = new Locale("vi");
        Locale English = new Locale("en");
        BankAction b = new BankAction();
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choose one option: ");

        int choice = Validate.getInputIntLimit(1, 3, English);
        switch (choice) {
            case 1:
                b.login(Vietnamese);
                break;
            case 2:
                b.login(English);
                break;
        }
    }
}
