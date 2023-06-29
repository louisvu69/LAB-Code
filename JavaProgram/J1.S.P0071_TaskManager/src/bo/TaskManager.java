package bo;

import entity.Task;
import java.util.ArrayList;

public class TaskManager {

    private final ArrayList<Task> tasks;
    private int lastId = 0;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task addTask(Task s) {
        s.setId(++lastId);
        tasks.add(s);
        return s;
    }

    public Task deleteTaskbyId(int id) throws Exception {
        int index = searchTaskById(id);
        if (index != -1) {
            return tasks.remove(index);
        }
        throw new Exception("Task does not exist!");
    }

    private int searchTaskById(int id) {
        for (int index = 0; index < tasks.size(); index++) {
            if (tasks.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

}
