package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.Project;

import java.sql.*;
import java.util.ArrayList;

public class ProjectMapper {

    public void createProject(Project project) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO projects (Project_Name, Project_Description) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, project.getProjectName());
            ps.setString(2, project.getProjectDescription());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            project.setProjectId(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Project> getAllProjects() {
        ArrayList<Project> projectList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM projects";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int projectId = rs.getInt("Project_Id");
                String projectName = rs.getString("Project_Name");
                String projectDescription = rs.getString("Project_Description");
                Project project = new Project(projectName, projectDescription);
                project.setProjectId(projectId);
                projectList.add(project);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return projectList;
    }

    public Project getProject(int id) {
        Project project = new Project();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM projects WHERE Project_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int projectId = rs.getInt("Project_Id");
                String projectName = rs.getString("Project_Name");
                String projectDescription = rs.getString("Project_Description");
                project.setProjectId(projectId);
                project.setProjectName(projectName);
                project.setProjectDescription(projectDescription);
                //Project project = new Project(projectName, projectDescription);
                //project.setProjectId(projectId);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return project;
    }


}
