package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubProject;

import java.util.ArrayList;

public class Facade {

    private ProjectMapper projectMapper = new ProjectMapper();
    private SubProjectMapper subProjectMapper = new SubProjectMapper();

    public Project createProject(Project project) {
        projectMapper.createProject(project);
        return project;
    }

    public ArrayList<Project> getAllProjects() {
       return projectMapper.getAllProjects();
    }

    public Project getProject(int id) {
        return projectMapper.getProject(id);
    }

    public SubProject createSubProject(SubProject subProject) {
        subProjectMapper.createSubProject(subProject);
        return subProject;
    }

    public ArrayList<SubProject> getSubProjectBasedOnProjectID(int id) {
        return subProjectMapper.getSubProjectBasedOnProjectID(id);
    }
}
