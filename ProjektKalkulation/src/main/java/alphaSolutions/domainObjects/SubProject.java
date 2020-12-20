package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.Facade;

import java.util.ArrayList;

/*------------------------------------------------------------------*/
/*---------------------author; Thomas S-----------------------------*/
/*------------------------------------------------------------------*/

public class SubProject {

    private int subProjectId;
    private int projectId;
    private String subProjectName;
    private String subProjectDescription;
    private double estimatetWorkHours;
    private int subProjectEWHId;
    private final SystemController systemController = new SystemController(new Facade());


    /*------------------------------------------------------------------*/
    /*----------------------Constructors--------------------------------*/
    /*------------------------------------------------------------------*/

    public SubProject(int subProjectId, int projectId, String subProjectName, String subProjectDescription) {
        this.subProjectId = subProjectId;
        this.projectId = projectId;
        this.subProjectName = subProjectName;
        this.subProjectDescription = subProjectDescription;
    }

    public SubProject() {
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public int getSubProjectId() {
        return subProjectId;
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

    public double getEstimatetWorkHours() {
        double tasksOfCurrentSubProjectEWHSum = systemController.getSubProjectEstimatetWorkHoursSum(this.subProjectId);
        if(tasksOfCurrentSubProjectEWHSum > 0) {
            systemController.updateSubProjectsEstimatetWorkhours(this.subProjectId, tasksOfCurrentSubProjectEWHSum);
            return tasksOfCurrentSubProjectEWHSum;
        } else {
            systemController.updateSubProjectsEstimatetWorkhours(this.subProjectId, Math.max(tasksOfCurrentSubProjectEWHSum, this.estimatetWorkHours));
            return Math.max(tasksOfCurrentSubProjectEWHSum, this.estimatetWorkHours);
        }
    }

    public int getSubProjectEWHId() {
        return subProjectEWHId;
    }

    public ArrayList<SubProject> getSubProjectDependencies(){
        return systemController.getSubProjectDependencies(this.subProjectId);
    }

    /*------------------------------------------------------------------*/
    /*----------------------Setters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setSubProjectId(int subProjectId) {
        this.subProjectId = subProjectId;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public void setSubProjectDescription(String subProjectDescription) {
        this.subProjectDescription = subProjectDescription;
    }

    public void setEstimatetWorkHours(double estimatetWorkHours) {
        this.estimatetWorkHours = estimatetWorkHours;
    }

    public void setSubProjectEWHId(int subProjectEWHId) {
        this.subProjectEWHId = subProjectEWHId;
    }



}
