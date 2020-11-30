package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.Project;

import java.util.ArrayList;

public class Facade {

    private ProjectMapper projectMapper = new ProjectMapper();

    public Project createProject(Project project) {
        projectMapper.createProject(project);
        return project;
    }

    public ArrayList<Project> getAllProjects() {
       return projectMapper.getAllProjects();
    }
}
