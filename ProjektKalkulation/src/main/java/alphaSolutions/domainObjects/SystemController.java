package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.Facade;

import java.util.ArrayList;

public class SystemController {

    private final Facade facade;

    /*------------------------------------------------------------------*/
    /*----------------------Constructors--------------------------------*/
    /*------------------------------------------------------------------*/

    public SystemController(Facade facade) {
        this.facade = facade;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Creators-------------------------------------*/
    /*------------------------------------------------------------------*/

    public Project createProject(Project project) {
        facade.createProject(project);
        return project;
    }

    public SubProject createSubProject(SubProject subProject, int projectId) {
        facade.createSubProject(subProject, projectId);
        return subProject;
    }

    public Task createTask(Task task) {
        facade.createTask(task);
        return task;
    }

    public SubTask createSubTask(SubTask subTask) {
        facade.createSubTask(subTask);
        return subTask;
    }


    public SubTask setSubTaskEstimatetWorkHours(SubTask subTask) {
        facade.setSubTaskEstimatetWorkHours(subTask);
        return subTask;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public ArrayList<Project> getAllProjects() {
        return facade.getAllProjects();
    }

    public Project getProject(int id) {
        return facade.getProject(id);
    }

    public ArrayList<SubProject> getSubProjectBasedOnProjectID(int id) {
        return facade.getSubProjectBasedOnProjectID(id);
    }

    public SubProject getSubProject(int id) {
        return facade.getSubProject(id);
    }

    public ArrayList<Task> getTasksBasedOnSubProjectID(int id) {
        return facade.getTasksBasedOnSubProjectID(id);
    }

    public Task getTask(int id) {
        return facade.getTask(id);
    }

    public ArrayList<SubTask> getSubTasksBasedOnTaskId(int id) {
        return facade.getSubTasksBasedOnTaskId(id);
    }

    public ArrayList<Employee> getAllStaff() {
        return facade.getAllStaff();
    }

    public Employee getEmployee(int employeeId) {
        return facade.getEmployee(employeeId);
    }

    public ArrayList<String> getSkillsForCertainEmployee(int employeeId) {
        return facade.getSkillsForCertainEmployee(employeeId);
    }

    public Project updateProject(Project project) {
        facade.updateProject(project);
        return project;
    }

    public ArrayList<String> getTaskDependencies(int taskId) {
        return facade.getTaskDependencies(taskId);
    }


    public SubProject updateSubProject(SubProject subProject) {
        facade.updateSubProject(subProject);
        return subProject;
    }

    public Task updateTask(Task task) {
        facade.updateTask(task);
        return task;
    }

    public SubTask updateSubTask(SubTask subTask) {
        facade.updateSubTask(subTask);
        return subTask;
    }

    public SubTask getSubTask(int id) {
        return facade.getSubTask(id);
    }
}
