package alphaSolutions.domainObjects;

public class SubTask {

    private int subTaskId;
    private int projectId;
    private int taskId;
    private String subTaskDescription;
    private double EstimatetWorkHours;
    private int subtasksEWHId;

    public SubTask(int subTaskId, int projectId, int taskId, String subTaskDescription) {
        this.subTaskId = subTaskId;
        this.projectId = projectId;
        this.taskId = taskId;
        this.subTaskDescription = subTaskDescription;
    }

    public SubTask() {
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public int getSubTaskId() {
        return subTaskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getSubTaskDescription() {
        return subTaskDescription;
    }

    public double getEstimatetWorkHours() {
        return EstimatetWorkHours;
    }

    public int getSubtasksEWHId() {
        return subtasksEWHId;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Setters-------------------------------------*/
    /*------------------------------------------------------------------*/


    public void setSubTaskId(int subTaskId) {
        this.subTaskId = subTaskId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setSubTaskDescription(String subTaskDescription) {
        this.subTaskDescription = subTaskDescription;
    }

    public void setEstimatetWorkHours(double estimatetWorkHours) {
        EstimatetWorkHours = estimatetWorkHours;
    }

    public void setSubtasksEWHId(int subtasksEWHId) {
        this.subtasksEWHId = subtasksEWHId;
    }
}
