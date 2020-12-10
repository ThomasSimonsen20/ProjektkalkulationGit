package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.*;

import java.util.ArrayList;

public class Facade {

    private ProjectMapper projectMapper = new ProjectMapper();
    private SubProjectMapper subProjectMapper = new SubProjectMapper();
    private TaskMapper taskMapper = new TaskMapper();
    private SubTaskMapper subTaskMapper = new SubTaskMapper();
    private EmployeeMapper employeeMapper = new EmployeeMapper();

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

    public ArrayList<Task> getTasksBasedOnSubProjectIdOmitCurrentTask(int idSubProject, int idTask) {
        return taskMapper.getTasksBasedOnSubProjectIdOmitCurrentTask(idSubProject, idTask);
    }

    public ArrayList<String> getTaskNamesBySubProjectIdOmitCurrentAndDependentTasks(int idSubProject, int idTask) {
        return taskMapper.getTaskNamesBySubProjectIdOmitCurrentAndDependentTasks(idSubProject, idTask);
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

    public ArrayList<Employee> getAllStaff() {
        return employeeMapper.getAllStaff();
    }

    public Employee getEmployee(int employeeId) {
        return employeeMapper.getEmployee(employeeId);
    }

    public ArrayList<String> getSkillsForCertainEmployee(int employeeId) {
        return employeeMapper.getSkillsForCertainEmployee(employeeId);
    }

    public Project updateProject(Project project) {
        projectMapper.updateProject(project);
        return project;
    }

    public ArrayList<Task> getTaskDependencies(int taskId) {
        return taskMapper.getTaskDependencies(taskId);
    }


    public SubProject updateSubProject(SubProject subProject) {
        subProjectMapper.updateSubProject(subProject);
        return subProject;
    }



    public Task updateTask(Task task) {
        taskMapper.updateTask(task);
        return task;
    }

    public SubTask updateSubTask(SubTask subTask) {
        subTaskMapper.updateSubTask(subTask);
        return subTask;
    }

    public SubTask getSubTask(int id) {
        return subTaskMapper.getSubTask(id);
    }

    public int getSubProjectIdBasedOnTaskId(int taskId) {
        return taskMapper.getSubProjectIdBasedOnTaskId(taskId);
    }


    public void createTaskDependency(int taskId, int dependencyId) {
        taskMapper.createTaskDependency(taskId, dependencyId);
    }

    public void createSubTaskDependency(int subTaskId, String dependency) {
        subTaskMapper.createSubTaskDependency(subTaskId, dependency);
    }


}
