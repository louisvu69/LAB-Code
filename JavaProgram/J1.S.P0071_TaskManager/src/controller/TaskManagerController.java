package controller;

import bo.TaskInputter;
import bo.TaskManager;
import entity.Task;
import utils.Validation;

public class TaskManagerController {

    private TaskInputter taskInputter;
    private final TaskManager taskManager;

    public TaskManagerController() {
        taskManager = new TaskManager();
    }

    public void addTask() {
        taskInputter = new TaskInputter();
        taskInputter.inputTaskInformation();
        Task s = taskInputter.getTask();
        taskManager.addTask(s);
    }

    public void displayTask() {
        System.out.printf(Task.DISPLAY_HEADER);
        for (Task s : taskManager.getTasks()) {
            System.out.println(s);
        }
    }

    public Task deleteTask() throws Exception {
        displayTask();
        int idDelete = Validation.getInputInt("Enter id: ", "Id must be an integer. Enter again: ");
        Task taskDelete = taskManager.deleteTaskbyId(idDelete);
        return taskDelete;
    }
}
