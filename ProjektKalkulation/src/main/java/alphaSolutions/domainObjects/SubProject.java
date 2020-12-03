package alphaSolutions.domainObjects;

public class SubProject {

    private int subProjectId;
    private int projectId;
    private String subProjectName;
    private String subProjectDescription;
    private double EstimatetWorkHours;
    private int subProjectEWHId;



    /*------------------------------------------------------------------*/
    /*----------------------Constructors--------------------------------*/
    /*------------------------------------------------------------------*/

    public SubProject(int projectId, String subProjectName, String subProjectDescription) {
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
        return EstimatetWorkHours;
    }

    public int getSubProjectEWHId() {
        return subProjectEWHId;
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
        EstimatetWorkHours = estimatetWorkHours;
    }

    public void setSubProjectEWHId(int subProjectEWHId) {
        this.subProjectEWHId = subProjectEWHId;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Adders--------------------------------------*/
    /*------------------------------------------------------------------*/

}
