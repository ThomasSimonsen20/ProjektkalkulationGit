package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.SubProject;
import alphaSolutions.domainObjects.Task;

import java.sql.*;
import java.util.ArrayList;

/*------------------------------------------------------------------*/
/*---------------------author; Thomas S-----------------------------*/
/*------------------------------------------------------------------*/

public class SubProjectMapper {

    /*------------------------------------------------------------------*/
    /*----------------------Creators------------------------------------*/
    /*------------------------------------------------------------------*/

    public void createSubProject(SubProject subProject, int projectId) {
        Connection con = DBManager.getConnection();
        try {
            con.setAutoCommit(false);

            PreparedStatement psCreateSubProjectTable = createSubProjectTable(subProject, projectId);
            subProject.setSubProjectId(getGeneratedKeys(psCreateSubProjectTable));

            PreparedStatement psCreateSubProjectsEstimatetWorkhoursTable = createSubProjectsEstimatetWorkhoursTable(subProject);
            subProject.setSubProjectEWHId(getGeneratedKeys(psCreateSubProjectsEstimatetWorkhoursTable));

            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createSubProjectDependency(int subprojectId, int dependencyId) {

        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subProjectDependencies (SubProject_Id, SubProjectDependency_Id) VALUES (?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subprojectId);
            ps.setInt(2, dependencyId);
            ps.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException dupEntry){
            System.out.println("Duplicate entry");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public int getGeneratedKeys(PreparedStatement ps) {
        int id = 0;
        try {
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            id = ids.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public ArrayList<SubProject> getSubProjectsBasedOnProjectID(int id) {
        ArrayList<SubProject> subProjectList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM subprojects WHERE Project_Id = ?";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int subProjectID = rs.getInt("SubProject_Id");
                int projectId = rs.getInt("Project_Id");
                String subProjectName = rs.getString("SubProject_Name");
                String subProjectDescription = rs.getString("SubProject_Description");
                SubProject subProject = new SubProject(subProjectID, projectId, subProjectName, subProjectDescription);
                setSubprojectsEstimatetWorkHoursTable(subProject);
                subProjectList.add(subProject);
            }

        }
        catch (SQLException ex) {
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
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int subProjectID = rs.getInt("SubProject_Id");
                int projectId = rs.getInt("Project_Id");
                String subProjectName = rs.getString("SubProject_Name");
                String subProjectDescription = rs.getString("SubProject_Description");

                subProject.setSubProjectId(subProjectID);
                subProject.setProjectId(projectId);
                subProject.setSubProjectName(subProjectName);
                subProject.setSubProjectDescription(subProjectDescription);

                setSubprojectsEstimatetWorkHoursTable(subProject);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subProject;
    }

    public ArrayList<SubProject> getSubProjectDependencies(int subProject_Id) {
        ArrayList<SubProject> subProjectDependenciesList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT Subprojects.Project_Id, Subprojects.Subproject_Id, Subprojects.Subproject_Name, Subprojects.Subproject_Description\n" +
                    "FROM Subprojectdependencies\n" +
                    "LEFT JOIN Subprojects ON Subprojectdependencies.SubprojectDependency_Id = Subprojects.Subproject_Id\n" +
                    "WHERE Subprojectdependencies.Subproject_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subProject_Id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int dependencySubProjectId = rs.getInt("SubProject_Id");
                int projectId = rs.getInt("Project_Id");
                String subProjectName = rs.getString("SubProject_Name");
                String subProjectDescription = rs.getString("SubProject_Description");
                SubProject subProject = new SubProject(dependencySubProjectId, projectId, subProjectName, subProjectDescription);
                subProjectDependenciesList.add(subProject);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subProjectDependenciesList;
    }

    public int getSubProjectDependencyIdFromDependencyName(String dependencyName) {
        int dependency_id = 0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT SubProjects.SubProject_Id FROM SubProjects WHERE SubProjects.SubProject_Name = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, dependencyName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dependency_id = rs.getInt("SubProject_Id");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dependency_id;
    }

    public double getSubProjectEstimatetWorkHoursSum(int subProjectId) {
        double sum = 0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT Sum(TasksEstimatetWorkHours.EstimatetWorkHours) AS Sum\n" +
                    "FROM TasksEstimatetWorkHours\n" +
                    "LEFT JOIN Tasks ON TasksEstimatetWorkHours.Task_Id = Tasks.Task_Id\n" +
                    "WHERE Tasks.SubProject_Id= ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subProjectId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                sum = rs.getDouble("Sum");
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sum;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Setters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public void setSubprojectsEstimatetWorkHoursTable(SubProject subProject) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT EstimatetWorkHours, SubProjectEWH_Id\n" +
                    "FROM SubprojectsEstimatetWorkHours\n" +
                    "WHERE SubProject_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subProject.getSubProjectId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                subProject.setEstimatetWorkHours(rs.getDouble("EstimatetWorkHours"));
                subProject.setSubProjectEWHId(rs.getInt("SubProjectEWH_Id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    /*------------------------------------------------------------------*/
    /*----------------------Updaters------------------------------------*/
    /*------------------------------------------------------------------*/

    public void updateSubProject(SubProject subProject) {
        Connection con = DBManager.getConnection();
        try {
            con.setAutoCommit(false);

            updateSubProjectTable(subProject);
            updateSubProjectsEstimatetWorkhours(subProject);

            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateSubProjectTable(SubProject subProject) {
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

    public void updateSubProjectsEstimatetWorkhours(SubProject subProject) {
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


    public void updateSubProjectsEstimatetWorkhours(int subProjectId, double eWH) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE subprojectsestimatetworkhours SET EstimatetWorkHours = ? WHERE SubProject_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, eWH);
            ps.setInt(2, subProjectId);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    /*------------------------------------------------------------------*/
    /*----------------Prepared Statement Generators---------------------*/
    /*------------------------------------------------------------------*/

    public PreparedStatement createSubProjectTable(SubProject subProject, int projectId) {
        PreparedStatement ps = null;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subprojects (Project_Id, SubProject_Name, SubProject_Description) VALUES (?,?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, projectId);
            ps.setString(2, subProject.getSubProjectName());
            ps.setString(3, subProject.getSubProjectDescription());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ps;
    }

    public PreparedStatement createSubProjectsEstimatetWorkhoursTable(SubProject subProject) {
        PreparedStatement ps = null;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subprojectsestimatetworkhours (SubProject_Id, EstimatetWorkHours) VALUES (?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subProject.getSubProjectId());
            ps.setDouble(2, subProject.getEstimatetWorkHours());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ps;
    }


    /*------------------------------------------------------------------*/
    /*----------------------------Deleters-------------------------------*/
    /*------------------------------------------------------------------*/

    public void deleteSubProject(SubProject subProject) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "DELETE FROM alphasolutions.subprojects WHERE subprojects.SubProject_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subProject.getSubProjectId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}