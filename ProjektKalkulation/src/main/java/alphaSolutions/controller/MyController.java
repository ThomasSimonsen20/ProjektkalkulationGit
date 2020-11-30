package alphaSolutions.controller;

import alphaSolutions.data.mapper.Facade;
import alphaSolutions.domainObjects.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MyController {

    private final SystemController systemController = new SystemController(new Facade());

    @GetMapping("/")
    public String getHome() {
        return "redirect:/allProjects";
    }

    @GetMapping("/createProject")
    public String createProject(Model model, Project project) {
       // model.addAttribute("project", project);
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

    @GetMapping("/test")
    public String test() {
        return "/projectFileTest";
    }

    private void projectSessionInfo(WebRequest request, Project project) {
        request.setAttribute("project", project, WebRequest.SCOPE_SESSION);
    }
}
