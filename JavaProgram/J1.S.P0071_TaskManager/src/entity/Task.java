package entity;

public class Task {

    public static String DISPLAY_FORMAT = "%-3s|%-10s|%-20s|%-12s|%-6.1f|%-20s|%-20s\n";
    public static final String DISPLAY_FORMAT_HEADER = "%-3s|%-10s|%-20s|%-12s|%-6s|%-20s|%-20s\n";
    public static String DISPLAY_HEADER = String.format(DISPLAY_FORMAT_HEADER, "ID", "Task type", "Name", "Date", "Time", "Asignee", "Reviewer");
    private int id;
    private String taskTypeId;
    private String requirementName;
    private String date;
    private String planFrom;
    private String planTo;
    private String assign;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assign, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return String.format(DISPLAY_FORMAT, id, taskTypeId, requirementName, date,
                Double.parseDouble(planTo) - Double.parseDouble(planFrom), assign, reviewer);
    }
}
