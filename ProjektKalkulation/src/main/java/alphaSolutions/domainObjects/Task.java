package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.Facade;

import java.util.ArrayList;

public class Task {

    private int taskId;
    private int projectId;
    private int subProjectId;
    private String taskName;
    private String taskDescription;
    private double EstimatetWorkHours;
    private int tasksEWHId;
    //Arraylist dependencies
    private final SystemController systemController = new SystemController(new Facade());



    public Task(int taskId, int projectId, int subProjectId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.projectId = projectId;
        this.subProjectId = subProjectId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public Task() {
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getSubProjectId() {
        return subProjectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public ArrayList<Task> getTaskDependencies(){
        return systemController.getTaskDependencies(this.taskId);
    }

    public double getEstimatetWorkHours() {
        return EstimatetWorkHours;
    }

    public int getTasksEWHId() {
        return tasksEWHId;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Setters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setSubProjectId(int subProjectId) {
        this.subProjectId = subProjectId;
    }

    public void setEstimatetWorkHours(double estimatetWorkHours) {
        EstimatetWorkHours = estimatetWorkHours;
    }

    public void setTasksEWHId(int tasksEWHId) {
        this.tasksEWHId = tasksEWHId;
    }
}


