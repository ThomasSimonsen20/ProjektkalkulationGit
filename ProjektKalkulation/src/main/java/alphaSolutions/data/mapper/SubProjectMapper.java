package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubProject;

import java.sql.*;
import java.util.ArrayList;

public class SubProjectMapper {

    public void createSubProject(SubProject subProject, int projectId) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subprojects (Project_Id, SubProject_Name, SubProject_Description) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, projectId);
            ps.setString(2, subProject.getSubProjectName());
            ps.setString(3, subProject.getSubProjectDescription());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            subProject.setSubProjectId(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<SubProject> getSubProjectsBasedOnProjectID(int id) {
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
                SubProject subProject = new SubProject(subProjectID, projectId, subProjectName, subProjectDescription);
                subProject.setEstimatetWorkHours(getSubProjectEstimatetWorkHours(subProject.getSubProjectId()));
                subProject.setSubProjectEWHId(getSubProjectEWHId(subProject.getSubProjectId()));
                subProjectList.add(subProject);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subProjectList;
    }

    public SubProject getSubProject(int id) {
        SubProject subProject = new SubProject();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM subprojects WHERE SubProject_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int subProjectID = rs.getInt("SubProject_Id");
                int projectId = rs.getInt("Project_Id");
                String subProjectName = rs.getString("SubProject_Name");
                String subProjectDescription = rs.getString("SubProject_Description");
                subProject.setSubProjectId(subProjectID);
                subProject.setProjectId(projectId);
                subProject.setSubProjectName(subProjectName);
                subProject.setSubProjectDescription(subProjectDescription);
                subProject.setSubProjectEWHId(getSubProjectEWHId(subProjectID));
                subProject.setEstimatetWorkHours(getSubProjectEstimatetWorkHours(subProjectID));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subProject;
    }


    public void updateSubProject(SubProject subProject) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE subprojects SET SubProject_Name = ?, SubProject_Description = ? WHERE SubProject_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, subProject.getSubProjectName());
            ps.setString(2, subProject.getSubProjectDescription());
            ps.setInt(3, subProject.getSubProjectId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateEstimatetWorkHours(SubProject subProject) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE subprojectsestimatetworkhours SET EstimatetWorkHours = ? WHERE SubProjectEWH_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, subProject.getEstimatetWorkHours());
            ps.setInt(2, subProject.getSubProjectEWHId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setSubProjectEstimatetWorkHours(SubProject subProject) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subprojectsestimatetworkhours (SubProject_Id, EstimatetWorkHours) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subProject.getSubProjectId());
            ps.setDouble(2, subProject.getEstimatetWorkHours());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            subProject.setSubProjectEWHId(id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public double getSubProjectEstimatetWorkHours(int id) {
        Double estimatetWorkHours = 0.0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT SubprojectsEstimatetWorkHours.EstimatetWorkHours\n" +
                    "FROM SubprojectsEstimatetWorkHours\n" +
                    "WHERE SubprojectsEstimatetWorkHours.SubProject_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                estimatetWorkHours = rs.getDouble("EstimatetWorkHours");

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estimatetWorkHours;
    }

    public int getSubProjectEWHId(int id) {
        int SubProjectEWHId = 0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT SubprojectsEstimatetWorkHours.SubProjectEWH_Id\n" +
                    "FROM SubprojectsEstimatetWorkHours\n" +
                    "WHERE SubprojectsEstimatetWorkHours.SubProject_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                SubProjectEWHId = rs.getInt("SubProjectEWH_Id");

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SubProjectEWHId;
    }
}
