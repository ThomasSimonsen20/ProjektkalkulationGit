package alphaSolutions.domainObjects;

import java.util.ArrayList;

public class Project {

    private int projectId;
    private String projectName;
    private String projectDescription;
    private ArrayList<SubProject> subProjects = new ArrayList<>();


    /*------------------------------------------------------------------*/
    /*----------------------Constructors--------------------------------*/
    /*------------------------------------------------------------------*/

    public Project(String projectName, String projectDescription) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public Project() {
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public int getProjectId() {
        return projectId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Setters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Adders--------------------------------------*/
    /*------------------------------------------------------------------*/

    public void addSubProjectToList(SubProject sP){
        subProjects.add(sP);
    }

}
