package alphaSolutions.domainObjects;

import java.util.ArrayList;

public class SubProject {

    private int subProjectID;
    private int projectId;
    private String subProjectName;
    private String subProjectDescription;
    private ArrayList<Task> tasks = new ArrayList<>();
    //private Organizer organizer = new Organizer();


    /*------------------------------------------------------------------*/
    /*----------------------Constructors--------------------------------*/
    /*------------------------------------------------------------------*/

    public SubProject(int projectId, String subProjectName, String subProjectDescription) {
        this.projectId = projectId;
        this.subProjectName = subProjectName;
        this.subProjectDescription = subProjectDescription;
        //organizer.
    }

    public SubProject() {
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public int getSubProjectID() {
        return subProjectID;
    }

    public String getSubProjectName() {
        return subProjectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getSubProjectDescription() {
        return subProjectDescription;
    }


    /*------------------------------------------------------------------*/
    /*----------------------Setters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setSubProjectID(int subProjectID) {
        this.subProjectID = subProjectID;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public void setSubProjectDescription(String subProjectDescription) {
        this.subProjectDescription = subProjectDescription;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Adders--------------------------------------*/
    /*------------------------------------------------------------------*/

    public void addTaskToList(Task t){
        tasks.add(t);
    }
}
