package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.*;

import java.util.ArrayList;

/*------------------------------------------------------------------*/
/*---------------------author; MF, TS, SK---------------------------*/
/*------------------------------------------------------------------*/

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

    /*------------------------------------------------------------------*/
    /*----------------------Creators-------------------------------------*/
    /*------------------------------------------------------------------*/

    public SubProject createSubProject(SubProject subProject, int projectId) {
        subProjectMapper.createSubProject(subProject, projectId);
        return subProject;
    }

    public Task createTask(Task task) {
        taskMapper.createTask(task);
        return task;
    }

    public SubTask createSubTask(SubTask subTask) {
        subTaskMapper.createSubTask(subTask);
        return subTask;
    }

    public void createTaskDependency(int taskId, int dependencyId) {
        taskMapper.createTaskDependency(taskId, dependencyId);
    }

    public void createSubTaskDependency(int subTaskId, int dependencyId) {
        subTaskMapper.createSubTaskDependency(subTaskId, dependencyId);
    }


    public void createSubProjectDependency(int subprojectId, int dependencyId) {
        subProjectMapper.createSubProjectDependency(subprojectId, dependencyId);
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/


    public ArrayList<Project> getAllProjects() {
        return projectMapper.getAllProjects();
    }

    public Project getProject(int id) {
        return projectMapper.getProject(id);
    }


    public ArrayList<SubProject> getSubProjectsBasedOnProjectID(int id) {
        return subProjectMapper.getSubProjectsBasedOnProjectID(id);
    }

    public SubProject getSubProject(int id) {
        return subProjectMapper.getSubProject(id);
    }


    public ArrayList<Task> getTasksBasedOnSubProjectID(int id) {
        return taskMapper.getTasksBasedOnSubProjectID(id);
    }


    public Task getTask(int id) {
        return taskMapper.getTask(id);
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

    public ArrayList<Task> getTaskDependencies(int taskId) {
        return taskMapper.getTaskDependencies(taskId);
    }

    public ArrayList<SubTask> getSubTaskDependencies(int subTaskId) {
        return  subTaskMapper.getSubTaskDependencies(subTaskId);
    }

    public SubTask getSubTask(int id) {
        return subTaskMapper.getSubTask(id);
    }

    public int getSubProjectIdBasedOnTaskId(int taskId) {
        return taskMapper.getSubProjectIdBasedOnTaskId(taskId);
    }

    public int getSubProjectDependencyIdFromDependencyName(String dependencyName){
        return subProjectMapper.getSubProjectDependencyIdFromDependencyName(dependencyName);
    }

    public int getTaskDependencyIdFromDependencyName(String dependencyName){
       return taskMapper.getTaskDependencyIdFromDependencyName(dependencyName);
    }

    public int getSubTaskDependencyIdFromDependencyName(String dependencyName){
        return subTaskMapper.getSubTaskDependencyIdFromDependencyName(dependencyName);
    }

    public ArrayList<SubProject> getSubProjectDependencies(int subProjectId) {
        return subProjectMapper.getSubProjectDependencies(subProjectId);
    }

    public double getTaskEstimatetWorkHoursSum(int taskId) {
        return taskMapper.getSubTasksEstimatetWorkHoursSum(taskId);
    }

    public double getSubProjectEstimatetWorkHoursSum(int subProjectId) {
        return subProjectMapper.getSubProjectEstimatetWorkHoursSum(subProjectId);
    }

    public double getProjectEstimatetWorkHoursSum(int projectId) {
        return projectMapper.getProjectEstimatetWorkHoursSum(projectId);
    }


    /*------------------------------------------------------------------*/
    /*----------------------Updaters-------------------------------------*/
    /*------------------------------------------------------------------*/


    public Project updateProject(Project project) {
        projectMapper.updateProject(project);
        return project;
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

    public void updateSubProjectsEstimatetWorkhours(int subProjectId, double eWH) {
        subProjectMapper.updateSubProjectsEstimatetWorkhours(subProjectId, eWH);
    }

    public void updateTasksEstimatetWorkhours(int taskId, double eWH) {
        taskMapper.updateTasksEstimatetWorkhours(taskId, eWH);
    }


    /*------------------------------------------------------------------*/
    /*----------------------Deletes-------------------------------------*/
    /*------------------------------------------------------------------*/


    public Project deleteProject(Project project) {
        projectMapper.deleteProject(project);
        return project;
    }

    public SubProject deleteSubProject(SubProject subProject) {
        subProjectMapper.deleteSubProject(subProject);
        return subProject;
    }

    public Task deleteTask(Task task) {
        taskMapper.deleteTask(task);
        return task;
    }

    public SubTask deleteSubTask(SubTask subTask) {
        subTaskMapper.deleteSubTask(subTask);
        return subTask;
    }



}
