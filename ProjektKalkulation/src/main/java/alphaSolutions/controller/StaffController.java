package alphaSolutions.controller;

import alphaSolutions.data.mapper.Facade;
import alphaSolutions.domainObjects.Employee;
import alphaSolutions.domainObjects.SystemController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class StaffController {

    private final SystemController systemController = new SystemController(new Facade());
    private SessionInfomations sessionInfo = new SessionInfomations();

    @GetMapping("/staffOverview")
    public String staffOverview(Model model) {
        model.addAttribute("Staff", systemController.getAllStaff());
        return "staffOverview";
    }

    @GetMapping("/employee")
    public String employee(@RequestParam("id") int employeeId, Model model, WebRequest request) {
        Employee currentEmployee = systemController.getEmployee(employeeId);
        sessionInfo.employeeSessionInfo(request, currentEmployee);

        model.addAttribute("Employee", currentEmployee);

        return "employee";
    }
}
