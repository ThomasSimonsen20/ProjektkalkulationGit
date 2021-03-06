package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.Facade;

import java.util.ArrayList;

/*------------------------------------------------------------------*/
/*---------------------author; MF, TS, SK---------------------------*/
/*------------------------------------------------------------------*/

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

    public void createSubProjectDependency(int subprojectId, int dependencyId){
        facade.createSubProjectDependency(subprojectId, dependencyId);

    }

    public void createTaskDependency(int taskId, int dependencyId) {
        facade.createTaskDependency(taskId, dependencyId);
    }

    public void createSubTaskDependency(int subTaskId, int dependencyId) {
        facade.createSubTaskDependency(subTaskId, dependencyId);
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public SubTask getSubTask(int id) {
        return facade.getSubTask(id);
    }

    public ArrayList<Project> getAllProjects() {
        return facade.getAllProjects();
    }

    public Project getProject(int id) {
        return facade.getProject(id);
    }

    public ArrayList<SubProject> getSubProjectsBasedOnProjectID(int id) {
        return facade.getSubProjectsBasedOnProjectID(id);
    }

    public SubProject getSubProject(int id) {
        return facade.getSubProject(id);
    }

    public ArrayList<Task> getTasksBasedOnSubProjectID(int id) {
        return facade.getTasksBasedOnSubProjectID(id);
    }


    public ArrayList<SubTask> getSubTaskDependencies(int subTaskId) {
        return  facade.getSubTaskDependencies(subTaskId);
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

    public ArrayList<Task> getTaskDependencies(int taskId) {
        return facade.getTaskDependencies(taskId);
    }

    public int getSubProjectIdBasedOnTaskId(int taskId){
        return facade.getSubProjectIdBasedOnTaskId(taskId);
    }

    public int getTaskDependencyIdFromDependencyName(String dependencyName){
        return facade.getTaskDependencyIdFromDependencyName(dependencyName);
    }

    public int getSubTaskDependencyIdFromDependencyName(String dependencyName){
        return facade.getSubTaskDependencyIdFromDependencyName(dependencyName);
    }

    public int getSubProjectDependencyIdFromDependencyName(String dependencyName){
        return facade.getSubProjectDependencyIdFromDependencyName(dependencyName);
    }

    public ArrayList<SubProject> getSubProjectDependencies(int subProjectId) {
        return facade.getSubProjectDependencies(subProjectId);
    }

    public double getTaskEstimatetWorkHoursSum(int taskId) {
        return facade.getTaskEstimatetWorkHoursSum(taskId);
    }

    public double getSubProjectEstimatetWorkHoursSum(int subProjectId) {
        return facade.getSubProjectEstimatetWorkHoursSum(subProjectId);
    }

    public double getProjectEstimatetWorkHoursSum(int projectId) {
        return facade.getProjectEstimatetWorkHoursSum(projectId);
    }



    /*------------------------------------------------------------------*/
    /*----------------------Updaters--------------------------------------*/
    /*------------------------------------------------------------------*/


    public Project updateProject(Project project) {
        facade.updateProject(project);
        return project;
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

    public void updateSubProjectsEstimatetWorkhours(int subProjectId, double eWH) {
        facade.updateSubProjectsEstimatetWorkhours(subProjectId, eWH);
    }

    public void updateTasksEstimatetWorkhours(int taskId, double eWH) {
        facade.updateTasksEstimatetWorkhours(taskId, eWH);
    }


    /*------------------------------------------------------------------*/
    /*----------------------Deleters-------------------------------------*/
    /*------------------------------------------------------------------*/


    public Project deleteProject(Project project) {
        facade.deleteProject(project);
        return project;
    }

    public SubProject deleteSubProject(SubProject subProject) {
        facade.deleteSubProject(subProject);
        return subProject;
    }

    public Task deleteTask(Task task) {
        facade.deleteTask(task);
        return task;
    }

    public SubTask deleteSubTask(SubTask subTask) {
        facade.deleteSubTask(subTask);
        return subTask;
    }



}
