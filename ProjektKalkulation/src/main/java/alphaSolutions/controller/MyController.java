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

    @GetMapping("/createProject")
    public String createProject() {
        return "createProject";
    }

    @GetMapping("/allProjects")
    public String allProjects(Model model) {
        model.addAttribute("Project", systemController.getAllProjects());
        return "allProjects";
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

    @GetMapping("/subProject")
    public String test(@RequestParam("id") int idProject,Model model, WebRequest request) {
        Project currentProject = systemController.getProject(idProject);
        projectSessionInfo(request, currentProject);

        model.addAttribute("Project", currentProject);
        model.addAttribute("subProject", systemController.getSubProjectBasedOnProjectID(idProject));

        return "subProjects";
    }

    @GetMapping("/createSubProject")
    public String createSubProject() {
        return "createSubProject";
    }

    @PostMapping("/createSubProject/submit")
    public String createSubProjectSubmit(WebRequest request, SubProject subProject){
        Project project = (Project) request.getAttribute("Project",WebRequest.SCOPE_SESSION);

        String subProjectName = request.getParameter("subProjectName");
        String subProjectDescription = request.getParameter("subProjectDescription");

        //subProject.setProjectId(project.getProjectId());
        subProject.setSubProjectName(subProjectName);
        subProject.setSubProjectDescription(subProjectDescription);

        systemController.createSubProject(subProject);

        return "redirect:/subProjects";
    }

    private void projectSessionInfo(WebRequest request, Project project) {
        request.setAttribute("project", project, WebRequest.SCOPE_SESSION);
    }
}
