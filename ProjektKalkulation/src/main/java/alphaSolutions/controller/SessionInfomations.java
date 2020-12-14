package alphaSolutions.controller;

import alphaSolutions.domainObjects.*;
import org.springframework.web.context.request.WebRequest;

public class SessionInfomations {

    public void projectSessionInfo(WebRequest request, Project project) {
        request.setAttribute("project", project, WebRequest.SCOPE_SESSION);
    }

    public void subProjectSessionInfo(WebRequest request, SubProject subProject) {
        request.setAttribute("subProject", subProject, WebRequest.SCOPE_SESSION);
    }

    public void taskSessionInfo(WebRequest request, Task task) {
        request.setAttribute("task", task, WebRequest.SCOPE_SESSION);
    }

    public void subTaskSessionInfo(WebRequest request, SubTask subTask) {
        request.setAttribute("subTask", subTask, WebRequest.SCOPE_SESSION);
    }

    public void employeeSessionInfo(WebRequest request, Employee employee) {
        request.setAttribute("employee", employee, WebRequest.SCOPE_SESSION);
    }
}
