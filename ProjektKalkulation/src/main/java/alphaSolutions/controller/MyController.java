package alphaSolutions.controller;

import alphaSolutions.data.mapper.Facade;
import alphaSolutions.domainObjects.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MyController {

    private final SystemController systemController = new SystemController(new Facade());

    @GetMapping("/")
    public String getHome() {
        return "redirect:/allProjects";
    }


    @GetMapping("/allProjects")
    public String allProjects(Model model) {
        model.addAttribute("Project", systemController.getAllProjects());
        return "allProjects";
    }

    @GetMapping("/staffOverview")
    public String staffOverview(Model model) {
        model.addAttribute("Staff", systemController.getAllStaff());
        return "staffOverview";
    }

    @GetMapping("/employee")
    public String employee(@RequestParam("id") int employeeId, Model model, WebRequest request) {
        Employee currentEmployee = systemController.getEmployee(employeeId);
        employeeSessionInfo(request, currentEmployee);

        model.addAttribute("Employee", currentEmployee);

        return "employee";
    }

    @GetMapping("/createProject")
    public String createProject() {
        return "createProject";
    }

    @PostMapping("/createProject/submit")
    public String createProjectSubmit(WebRequest request, Project project){
        String projectName = request.getParameter("projectName");
        String projectDescription = request.getParameter("projectDescription");

        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);

        systemController.createProject(project);

        return "redirect:/allProjects";
    }

    @GetMapping("/updateProject")
    public String updateProject(@RequestParam("id") int idProject, WebRequest request) {
        Project currentProject = systemController.getProject(idProject);
        projectSessionInfo(request, currentProject);
        return "updateProject";
    }

    @PostMapping("/updateProject/submit")
    public String updateProjectSubmit(Model model, WebRequest request) {
        Project project = (Project) request.getAttribute("project",WebRequest.SCOPE_SESSION);

        String projectName = request.getParameter("projectName");
        String projectDescription = request.getParameter("projectDescription");

        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);

        systemController.updateProject(project);

        return "redirect:/allProjects";
    }


    @GetMapping("/subProject")
    public String subProject(@RequestParam("id") int idProject, Model model, WebRequest request) {
        Project currentProject = systemController.getProject(idProject);
        projectSessionInfo(request, currentProject);

        model.addAttribute("subProject", systemController.getSubProjectBasedOnProjectID(idProject));
        model.addAttribute("Project", currentProject);

        return "subProjects";
    }

    @GetMapping("/createSubProject")
    public String createSubProject() {
        return "createSubProject";
    }

    @PostMapping("/createSubProject/submit")
    public String createSubProjectSubmit(WebRequest request, SubProject subProject, Model model){

        Project project = (Project) request.getAttribute("project",WebRequest.SCOPE_SESSION);

        String subProjectName = request.getParameter("subProjectName");
        String subProjectDescription = request.getParameter("subProjectDescription");

        subProject.setSubProjectName(subProjectName);
        subProject.setSubProjectDescription(subProjectDescription);

        systemController.createSubProject(subProject, project.getProjectId());

        model.addAttribute("subProject", systemController.getSubProjectBasedOnProjectID(project.getProjectId()));

        return "subProjects";
    }

    @GetMapping("/task")
    public String task(@RequestParam("id") int idSubProject, Model model, WebRequest request) {
        SubProject currentSubProject = systemController.getSubProject(idSubProject);
        subProjectSessionInfo(request, currentSubProject);

        model.addAttribute("subproject", currentSubProject);
        model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectID(idSubProject));

        return "tasks";
    }

    @GetMapping("/createTask")
    public String createTask() {
        return "createTask";
    }

    @PostMapping("/createTask/submit")
    public String createTaskSubmit(WebRequest request, Task task, Model model){

        Project project = (Project) request.getAttribute("project",WebRequest.SCOPE_SESSION);
        SubProject subProject = (SubProject) request.getAttribute("subProject", WebRequest.SCOPE_SESSION);

        String taskName = request.getParameter("taskName");
        String taskDescription = request.getParameter("taskDescription");

        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setProjectId(project.getProjectId());
        task.setSubProjectId(subProject.getSubProjectId());

        systemController.createTask(task);

        model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectID(subProject.getSubProjectId()));

        return "tasks";
    }

    @GetMapping("/subTask")
    public String subTask(@RequestParam("id") int idTask, Model model, WebRequest request) {
        Task currentTask = systemController.getTask(idTask);
        taskSessionInfo(request, currentTask);

        model.addAttribute("task", currentTask);
        model.addAttribute("subTasks", systemController.getSubTasksBasedOnTaskId(idTask));

        return "subTasks";
    }

    @GetMapping("/createSubTask")
    public String createSubTask() {
        return "createSubTask";
    }

    @PostMapping("/createSubTask/submit")
    public String createSubTaskSubmit(WebRequest request, SubTask subTask, Model model){

        Project project = (Project) request.getAttribute("project",WebRequest.SCOPE_SESSION);
        Task task = (Task) request.getAttribute("task", WebRequest.SCOPE_SESSION);

        String subTaskDescription = request.getParameter("subTaskDescription");

        subTask.setProjectId(project.getProjectId());
        subTask.setTaskId(task.getTaskId());
        subTask.setSubTaskDescription(subTaskDescription);

       systemController.createSubTask(subTask);

        model.addAttribute("subTasks", systemController.getSubTasksBasedOnTaskId(task.getTaskId()));

       return "subTasks";
    }


    private void projectSessionInfo(WebRequest request, Project project) {
        request.setAttribute("project", project, WebRequest.SCOPE_SESSION);
    }

    private void subProjectSessionInfo(WebRequest request, SubProject subProject) {
        request.setAttribute("subProject", subProject, WebRequest.SCOPE_SESSION);
    }

    private void taskSessionInfo(WebRequest request, Task task) {
        request.setAttribute("task", task, WebRequest.SCOPE_SESSION);
    }

    private void employeeSessionInfo(WebRequest request, Employee employee) {
        request.setAttribute("employee", employee, WebRequest.SCOPE_SESSION);
    }
}
