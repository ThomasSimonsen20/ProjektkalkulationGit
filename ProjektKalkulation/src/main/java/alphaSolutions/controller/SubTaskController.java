package alphaSolutions.controller;

import alphaSolutions.data.mapper.Facade;
import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubTask;
import alphaSolutions.domainObjects.SystemController;
import alphaSolutions.domainObjects.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SubTaskController {

    private final SystemController systemController = new SystemController(new Facade());
    private SessionInfomations sessionInfo = new SessionInfomations();

    @GetMapping("/subTask")
    public String subTask(@RequestParam("id") int idTask, Model model, WebRequest request) {
        Task currentTask = systemController.getTask(idTask);
        sessionInfo.taskSessionInfo(request, currentTask);
        int idSubProject = systemController.getSubProjectIdBasedOnTaskId(idTask);

        model.addAttribute("task", currentTask);
        model.addAttribute("subTasks", systemController.getSubTasksBasedOnTaskId(idTask));
        //model.addAttribute("tasks", systemController.getTasksBasedOnSubProjectIdOmitCurrentTask(idSubProject, idTask));
        model.addAttribute("tasks", systemController.getTaskNamesBySubProjectIdOmitCurrentAndDependentTasks(idSubProject, idTask));


        return "subTasks";
    }

    @GetMapping("/createSubTask")
    public String createSubTask() {
        return "createSubTask";
    }

    @PostMapping("/createSubTask/submit")
    public String createSubTaskSubmit(WebRequest request, SubTask subTask, Model model){


        Project project = (Project) request.getAttribute("project",WebRequest.SCOPE_SESSION);
        Task currentTask = (Task) request.getAttribute("task", WebRequest.SCOPE_SESSION);

        String subTaskDescription = request.getParameter("subTaskDescription");
        String subTaskEstimatetWorkHours = request.getParameter("subTaskEstimatetWorkHours");

        subTask.setProjectId(project.getProjectId());
        subTask.setTaskId(currentTask.getTaskId());
        subTask.setSubTaskDescription(subTaskDescription);
        subTask.setEstimatetWorkHours(Double.parseDouble(subTaskEstimatetWorkHours));

        systemController.createSubTask(subTask);

        model.addAttribute("subTasks", systemController.getSubTasksBasedOnTaskId(currentTask.getTaskId()));
        model.addAttribute("task", currentTask);


        return "subTasks";
    }

    @GetMapping("/updateSubTask")
    public String updateSubTask(@RequestParam("id") int idSubTask, WebRequest request) {
        SubTask currentSubTask = systemController.getSubTask(idSubTask);
        sessionInfo.subTaskSessionInfo(request, currentSubTask);
        return "updateSubTask";
    }

    @PostMapping("/updateSubTask/submit")
    public String updateSubTaskSubmit(WebRequest request, Model model) {
        Task task = (Task) request.getAttribute("task", WebRequest.SCOPE_SESSION);

        SubTask subTask = (SubTask) request.getAttribute("subTask", WebRequest.SCOPE_SESSION);

        String subTaskDescription = request.getParameter("subTaskDescription");
        String subTaskEstimatetWorkHours = request.getParameter("subTaskEstimatetWorkHours");

        subTask.setEstimatetWorkHours(Double.parseDouble(subTaskEstimatetWorkHours));
        subTask.setSubTaskDescription(subTaskDescription);

        systemController.updateSubTask(subTask);

        model.addAttribute("subTasks", systemController.getSubTasksBasedOnTaskId(task.getTaskId()));

        return "subTasks";
    }
}
