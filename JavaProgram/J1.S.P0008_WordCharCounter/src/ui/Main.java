package ui;
import java.util.Arrays;
import java.util.HashMap;
import utils.StringUtils;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> counter;
        String input = Validation.getStringWithErrMess("Enter your content: ", "Content can not be empty. Enter again: ");
        counter = StringUtils.countWord(input); 
        System.out.println(Arrays.asList(counter));
        counter = StringUtils.countChar(input);
        System.out.println(Arrays.asList(counter));
    }

}
