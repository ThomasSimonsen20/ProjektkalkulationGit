package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubProject;
import alphaSolutions.domainObjects.SubTask;
import alphaSolutions.domainObjects.Task;

import java.util.ArrayList;

public class Facade {

    private ProjectMapper projectMapper = new ProjectMapper();
    private SubProjectMapper subProjectMapper = new SubProjectMapper();
    private TaskMapper taskMapper = new TaskMapper();
    private SubTaskMapper subTaskMapper = new SubTaskMapper();

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

    public SubProject createSubProject(SubProject subProject, int projectId) {
        subProjectMapper.createSubProject(subProject, projectId);
        return subProject;
    }

    public ArrayList<SubProject> getSubProjectBasedOnProjectID(int id) {
        return subProjectMapper.getSubProjectsBasedOnProjectID(id);
    }

    public SubProject getSubProject(int id) {
        return subProjectMapper.getSubProject(id);
    }

    public Task createTask(Task task) {
        taskMapper.createTask(task);
        return task;
    }

    public ArrayList<Task> getTasksBasedOnSubProjectID(int id) {
        return taskMapper.getTasksBasedOnSubProjectID(id);
    }

    public Task getTask(int id) {
        return taskMapper.getTask(id);
    }

    public SubTask createSubTask(SubTask subTask) {
        subTaskMapper.createSubTask(subTask);
        return subTask;
    }

    public ArrayList<SubTask> getSubTasksBasedOnTaskId(int id) {
        return subTaskMapper.getSubTasksBasedOnTaskId(id);
    }
}
