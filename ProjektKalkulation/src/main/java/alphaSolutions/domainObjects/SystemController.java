package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.Facade;

import java.util.ArrayList;

public class SystemController {

    private final Facade facade;

    public SystemController(Facade facade) {
        this.facade = facade;
    }

    public Project createProject(Project project) {
        facade.createProject(project);
        return project;
    }

    public ArrayList<Project> getAllProjects() {
        return facade.getAllProjects();
    }

    public Project getProject(int id) {
        return facade.getProject(id);
    }

    public SubProject createSubProject(SubProject subProject) {
        facade.createSubProject(subProject);
        return subProject;
    }

    public ArrayList<SubProject> getSubProjectBasedOnProjectID(int id) {
        return facade.getSubProjectBasedOnProjectID(id);
    }
}
