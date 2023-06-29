package bo;

import entity.Task;
import utils.Validation;

public class TaskInputter {

    private Task t;

    public Task getTask() {
        return t;
    }

    private void inputInfomation() {
        t = new Task();
        t.setRequirementName(Validation.getInputString("Enter requirement: ", "Requirement can not be empty. Enter again: ", "[A-Za-z0-9 ]+"));
        t.setTaskTypeId(Validation.getInputTaskTypeId());
        t.setDate(Validation.getInputDate("Enter date with format DD-MM-YYYY: ", "Enter date with proper format: "));
        t.setPlanFrom(Validation.getInputPlan("Enter plan starting time: ", "Plan time should be from 8.0, 8.5, 9.0, 9.5 ...to 17.5. Enter again: "));
        t.setPlanTo(Validation.getInputPlan("Enter plan ending time: ", "Plan time should be from 8.0, 8.5, 9.0, 9.5 ... to 17.5. Enter again: "));
        t.setAssign(Validation.getInputString("Enter asignee name: ", "Name should contain only letter. Enter again: ", "[A-Za-z ]+"));
        t.setReviewer(Validation.getInputString("Enter reviewer name: ", "Name should contain only letter. Enter again: ", "[A-Za-z ]+"));
    }

    public Task inputTaskInformation() {
        inputInfomation();
        return t;
    }
}
