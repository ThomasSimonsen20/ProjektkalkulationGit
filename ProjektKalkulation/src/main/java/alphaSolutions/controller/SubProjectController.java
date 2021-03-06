package alphaSolutions.controller;


import alphaSolutions.data.mapper.Facade;
import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubProject;
import alphaSolutions.domainObjects.SystemController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/*------------------------------------------------------------------*/
/*---------------------author; Mikkel F-----------------------------*/
/*------------------------------------------------------------------*/

@Controller
public class SubProjectController {

    private final SystemController systemController = new SystemController(new Facade());
    private SessionInfomations sessionInfo = new SessionInfomations();

    @GetMapping("/subProject")
    public String subProject(@RequestParam("id") int idProject, Model model, WebRequest request) {
        Project currentProject = systemController.getProject(idProject);
        sessionInfo.projectSessionInfo(request, currentProject);

        model.addAttribute("subProject", systemController.getSubProjectsBasedOnProjectID(idProject));
        model.addAttribute("project", currentProject);

        return "subProjects";
    }

    @GetMapping("/createSubProject")
    public String createSubProject() {
        return "createSubProject";
    }

    @PostMapping("/createSubProject/submit")
    public String createSubProjectSubmit(WebRequest request, SubProject subProject, Model model){
        Project currentProject = (Project) request.getAttribute("project",WebRequest.SCOPE_SESSION);

        String subProjectName = request.getParameter("subProjectName");
        String subProjectDescription = request.getParameter("subProjectDescription");
        String subProjectEstimatetWorkHours = request.getParameter("subProjectEstimatetWorkHours");

        subProject.setSubProjectName(subProjectName);
        subProject.setSubProjectDescription(subProjectDescription);
        subProject.setEstimatetWorkHours(Double.parseDouble(subProjectEstimatetWorkHours));

        systemController.createSubProject(subProject, currentProject.getProjectId());

        model.addAttribute("subProject", systemController.getSubProjectsBasedOnProjectID(currentProject.getProjectId()));
        model.addAttribute("project", currentProject);

        return "subProjects";
    }

    @GetMapping("/updateSubProject")
    public String updateSubProject(@RequestParam("id") int idSubProject, WebRequest request, Model model) {
        SubProject currentSubProject = systemController.getSubProject(idSubProject);
        sessionInfo.subProjectSessionInfo(request, currentSubProject);
        model.addAttribute("subProject", currentSubProject);
        return "updateSubProject";
    }

    @PostMapping("/updateSubProject/submit")
    public String updateSubProjectSubmit(WebRequest request, Model model) {
        Project currentProject = (Project) request.getAttribute("project", WebRequest.SCOPE_SESSION);
        SubProject subProject = (SubProject) request.getAttribute("subProject", WebRequest.SCOPE_SESSION);

        String subProjectName = request.getParameter("subProjectName");
        String subProjectDescription = request.getParameter("subProjectDescription");
        String subProjectEstimatetWorkHours = request.getParameter("subProjectEstimatetWorkHours");

        subProject.setSubProjectName(subProjectName);
        subProject.setSubProjectDescription(subProjectDescription);
        subProject.setEstimatetWorkHours(Double.parseDouble(subProjectEstimatetWorkHours));

        systemController.updateSubProject(subProject);

        model.addAttribute("subProject", systemController.getSubProjectsBasedOnProjectID(currentProject.getProjectId()));
        model.addAttribute("project", currentProject);

        return "subProjects";

    }

    @PostMapping("/createSubProjectDependency/submit")
    public String createDependencySubmit(@RequestParam("id") int idSubProject,WebRequest request, Model model){
        Project currentProject = (Project) request.getAttribute("project", WebRequest.SCOPE_SESSION);

        String getDependency = request.getParameter("dependency");
        int dependency = systemController.getSubProjectDependencyIdFromDependencyName(getDependency);

        if (dependency > 0) {
            systemController.createSubProjectDependency(idSubProject, dependency);
        }

        model.addAttribute("subProject", systemController.getSubProjectsBasedOnProjectID(currentProject.getProjectId()));
        model.addAttribute("project", currentProject);

        return "subProjects";
    }


    @GetMapping("/deleteSubProject/submit")
    public String deleteSubProjectSubmit(WebRequest request, Model model) {
        Project currentProject = (Project) request.getAttribute("project", WebRequest.SCOPE_SESSION);
        SubProject subProject = (SubProject) request.getAttribute("subProject", WebRequest.SCOPE_SESSION);

        systemController.deleteSubProject(subProject);

        model.addAttribute("subProject", systemController.getSubProjectsBasedOnProjectID(currentProject.getProjectId()));
        model.addAttribute("project", currentProject);
        return "subProjects";
    }


    @GetMapping("/backToSubProject")
    public String BacktoSubProject(WebRequest request, Model model) {
        Project currentProject = (Project) request.getAttribute("project", WebRequest.SCOPE_SESSION);
        model.addAttribute("subProject", systemController.getSubProjectsBasedOnProjectID(currentProject.getProjectId()));
        model.addAttribute("project", currentProject);
        return "subProjects";
    }

}
