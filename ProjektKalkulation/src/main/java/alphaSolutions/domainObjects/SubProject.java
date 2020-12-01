package alphaSolutions.domainObjects;

public class SubProject {

    int subProjectID;
    int projectId;
    String subProjectName;
    String subProjectDescription;


    public SubProject(int projectId, String subProjectName, String subProjectDescription) {
        this.projectId = projectId;
        this.subProjectName = subProjectName;
        this.subProjectDescription = subProjectDescription;
    }

    public int getSubProjectID() {
        return subProjectID;
    }

    public void setSubProjectID(int subProjectID) {
        this.subProjectID = subProjectID;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getSubProjectName() {
        return subProjectName;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public String getSubProjectDescription() {
        return subProjectDescription;
    }

    public void setSubProjectDescription(String subProjectDescription) {
        this.subProjectDescription = subProjectDescription;
    }
}
