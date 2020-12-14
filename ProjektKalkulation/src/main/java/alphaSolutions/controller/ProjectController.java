package alphaSolutions.controller;

import alphaSolutions.data.mapper.Facade;
import alphaSolutions.domainObjects.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

// hello
@Controller
public class ProjectController {

    private final SystemController systemController = new SystemController(new Facade());
    private SessionInfomations sessionInfo = new SessionInfomations();

    @GetMapping("/")
    public String getHome() {
        return "redirect:/projects";
    }


    @GetMapping("/projects")
    public String allProjects(Model model) {
        model.addAttribute("Project", systemController.getAllProjects());
        return "Projects";
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

        return "redirect:/projects";
    }


    @GetMapping("/updateProject")
    public String updateProject(@RequestParam("id") int idProject, WebRequest request, Model model) {
        Project currentProject = systemController.getProject(idProject);
        sessionInfo.projectSessionInfo(request, currentProject);
        model.addAttribute("project", currentProject);
        return "updateProject";
    }

    @PostMapping("/updateProject/submit")
    public String updateProjectSubmit(WebRequest request) {
        Project project = (Project) request.getAttribute("project",WebRequest.SCOPE_SESSION);

        String projectName = request.getParameter("projectName");
        String projectDescription = request.getParameter("projectDescription");

        project.setProjectName(projectName);
        project.setProjectDescription(projectDescription);

        systemController.updateProject(project);

        return "redirect:/projects";
    }

}
