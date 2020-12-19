package alphaSolutions.controller;

import alphaSolutions.data.mapper.Facade;
import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubProject;
import alphaSolutions.domainObjects.SystemController;
import alphaSolutions.domainObjects.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class TaskController {

    private final SystemController systemController = new SystemController(new Facade());
    private SessionInfomations sessionInfo = new SessionInfomations();


    @GetMapping("/task")
    public String task(@RequestParam("id") int idSubProject, Model model, WebRequest request) {
        SubProject currentSubProject = systemController.getSubProject(idSubProject);
        sessionInfo.subProjectSessionInfo(request, currentSubProject);

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
        String taskEstimatetWorkHours = request.getParameter("taskEstimatetWorkHours");

        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setProjectId(project.getProjectId());
        task.setSubProjectId(subProject.getSubProjectId());
        task.setEstimatetWorkHours(Double.parseDouble(taskEstimatetWorkHours));

        systemController.createTask(task);

        model.addAttribute("subproject", subProject);
        model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectID(subProject.getSubProjectId()));

        return "tasks";
    }


    @PostMapping("/createTaskDependency/submit")
    public String createDependencySubmit(@RequestParam("id") int idTask,WebRequest request, Model model){

        SubProject subProject = (SubProject) request.getAttribute("subProject", WebRequest.SCOPE_SESSION);

        String test = request.getParameter("dependency");
        int dependency = systemController.getTaskDependencyIdFromDependencyName(test);

        if(dependency > 0) {
            systemController.createTaskDependency(idTask, dependency);
        }


        model.addAttribute("subproject", subProject);
        model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectID(subProject.getSubProjectId()));


        return "tasks";
    }

    @GetMapping("/updateTask")
    public String updateTask(@RequestParam("id") int idTask, WebRequest request, Model model) {
        Task currentTask = systemController.getTask(idTask);
        sessionInfo.taskSessionInfo(request, currentTask);
        model.addAttribute("task", currentTask);
        return "updateTask";
    }

    @PostMapping("/updateTask/submit")
    public String updateTaskSubmit(WebRequest request, Model model) {
        SubProject subProject = (SubProject) request.getAttribute("subProject", WebRequest.SCOPE_SESSION);
        Task task = (Task) request.getAttribute("task", WebRequest.SCOPE_SESSION);

        String taskName = request.getParameter("taskName");
        String taskDescription = request.getParameter("taskDescription");
        String taskEstimatetWorkHours = request.getParameter("taskEstimatetWorkHours");

        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setEstimatetWorkHours(Double.parseDouble(taskEstimatetWorkHours));

        systemController.updateTask(task);

        model.addAttribute("subproject", subProject);
        model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectID(subProject.getSubProjectId()));

        return "tasks";
    }

    @GetMapping("/deleteTask/submit")
    public String deleteTaskSubmit(WebRequest request, Model model) {
        SubProject subProject = (SubProject) request.getAttribute("subProject", WebRequest.SCOPE_SESSION);
        Task task = (Task) request.getAttribute("task", WebRequest.SCOPE_SESSION);

        systemController.deleteTask(task);

        model.addAttribute("subproject", subProject);
        model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectID(subProject.getSubProjectId()));

        return "tasks";
    }

    @GetMapping("/backToTasks")
    public String BacktoSubProject(WebRequest request, Model model) {
        SubProject subProject = (SubProject) request.getAttribute("subProject", WebRequest.SCOPE_SESSION);
        model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectID(subProject.getSubProjectId()));
        model.addAttribute("subproject", subProject);
        return "tasks";
    }

}
