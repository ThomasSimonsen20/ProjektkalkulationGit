package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubProject;

import java.sql.*;
import java.util.ArrayList;

public class SubProjectMapper {

    public void createSubProject(SubProject subProject) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subprojects (Project_Id, SubProject_Name, SubProject_Description) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subProject.getProjectId());
            ps.setString(2, subProject.getSubProjectName());
            ps.setString(3, subProject.getSubProjectDescription());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            subProject.setSubProjectID(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<SubProject> getSubProjectBasedOnProjectID(int id) {
        ArrayList<SubProject> subProjectList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM subprojects WHERE Project_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int subProjectID = rs.getInt("SubProject_Id");
                int projectId = rs.getInt("Project_Id");
                String subProjectName = rs.getString("SubProject_Name");
                String subProjectDescription = rs.getString("SubProject_Description");
                SubProject subProject = new SubProject(projectId, subProjectName, subProjectDescription);
                subProject.setSubProjectID(subProjectID);
                subProjectList.add(subProject);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subProjectList;
    }
}
