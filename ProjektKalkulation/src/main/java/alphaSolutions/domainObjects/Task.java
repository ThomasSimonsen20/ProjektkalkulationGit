package alphaSolutions.domainObjects;

public class Task {

    private int taskId;
    private int projectId;
    private int subProjectId;
    private String taskName;
    private String taskDescription;


    public Task(int projectId, int subProjectId, String taskName, String taskDescription) {
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

}


