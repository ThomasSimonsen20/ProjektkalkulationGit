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

    public SubProject createSubProject(SubProject subProject, int projectId) {
        facade.createSubProject(subProject, projectId);
        return subProject;
    }

    public ArrayList<SubProject> getSubProjectBasedOnProjectID(int id) {
        return facade.getSubProjectBasedOnProjectID(id);
    }

    public SubProject getSubProject(int id) {
        return facade.getSubProject(id);
    }

    public Task createTask(Task task) {
        facade.createTask(task);
        return task;
    }

    public ArrayList<Task> getTasksBasedOnSubProjectID(int id) {
        return facade.getTasksBasedOnSubProjectID(id);
    }

    public Task getTask(int id) {
        return facade.getTask(id);
    }

    public SubTask createSubTask(SubTask subTask) {
        facade.createSubTask(subTask);
        return subTask;
    }
    public ArrayList<SubTask> getSubTasksBasedOnTaskId(int id) {
        return facade.getSubTasksBasedOnTaskId(id);
    }
}
