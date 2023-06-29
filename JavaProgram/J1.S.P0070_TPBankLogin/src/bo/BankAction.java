package bo;

import utils.Validate;
import java.util.Locale;
import java.util.Scanner;
import model.LoginInfo;

public class BankAction {

    private static final Scanner in = new Scanner(System.in);
    LoginInfo lf = new LoginInfo();

    public void login(Locale language) {
        inputAccountNumber(language);
        inputPassword(language);
        inputCaptcha(language);
    }

    private void inputAccountNumber(Locale language) {
        while (true) {
            Validate.getWordLanguage(language, "enterAccountNumber");
            String accountNumber = in.nextLine();
            if (Validate.isValidAccount(accountNumber)) {
                lf.setAccountNumber(accountNumber);
                break;
            } else {
                Validate.getWordLanguage(language, "errCheckInputAccount");
            }
        }
    }

    private void inputPassword(Locale language) {

        while (true) {
            Validate.getWordLanguage(language, "enterPassword");
            String password = in.nextLine();
            if (Validate.isValidPassword(password)) {
                lf.setPassword(password);
                break;
            } else {
                Validate.getWordLanguage(language, "errCheckPassword");
            }
        }
    }

    private void inputCaptcha(Locale language) {
        String captchaGenerated = Validate.getCaptchaText();
        while (true) {
            System.out.println(captchaGenerated);
            Validate.getWordLanguage(language, "enterCaptcha");
            String captchaInput = in.nextLine();
            if (Validate.isValidCaptcha(captchaInput, captchaGenerated)) {
                lf.setCaptcha(captchaInput);
                Validate.getWordLanguage(language, "loginSuccess");
                break;
            } else {
                Validate.getWordLanguage(language, "errCaptchaIncorrect");
            }
        }
    }
}
