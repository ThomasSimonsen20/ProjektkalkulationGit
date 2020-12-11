package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.SubProject;
import alphaSolutions.domainObjects.SubTask;
import alphaSolutions.domainObjects.Task;

import java.sql.*;
import java.util.ArrayList;

public class SubTaskMapper {

    /*------------------------------------------------------------------*/
    /*----------------------Creators------------------------------------*/
    /*------------------------------------------------------------------*/

    public void createSubTask(SubTask subTask) {
        Connection con = DBManager.getConnection();
        try {
            con.setAutoCommit(false);

            PreparedStatement psCreateSubTasksTable = createSubTasksTable(subTask);
            subTask.setSubTaskId(getGeneratedKeys(psCreateSubTasksTable));

            PreparedStatement psCreateSubTasksEstimatetWorkHours = createSubTasksEstimatetWorkHours(subTask);
            subTask.setSubtasksEWHId(getGeneratedKeys(psCreateSubTasksEstimatetWorkHours));

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

    public PreparedStatement createSubTasksTable(SubTask subTask) {
        PreparedStatement ps = null;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subtasks (Project_Id, Task_Id, SubTask_Description) VALUES (?,?,?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subTask.getProjectId());
            ps.setInt(2, subTask.getTaskId());
            ps.setString(3, subTask.getSubTaskDescription());
            ps.setString(4, subTask.getSubTaskName());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ps;
    }

    public PreparedStatement createSubTasksEstimatetWorkHours(SubTask subTask) {
        PreparedStatement ps = null;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subtaskestimatetworkhours (Subtask_Id, EstimatetWorkHours) VALUES (?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subTask.getSubTaskId());
            ps.setDouble(2, subTask.getEstimatetWorkHours());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ps;
    }

    public void createSubTaskDependency(int subTaskId, int dependencyId) {

        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subTaskDependencies (SubTask_Id, SubTaskDependency_Id) VALUES (?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subTaskId);
            ps.setInt(2, dependencyId);
            ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    private int getDependencyIdFromDependencyName(String dependencyName){
        int dependency_id = 0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT SubTasks.Task_Id FROM SubTasks WHERE SubTasks.Task_Name = ?;";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, dependencyName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                dependency_id = rs.getInt("Task_Id");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dependency_id;
    }

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


    public ArrayList<SubTask> getSubTasksBasedOnTaskId(int id) {
        ArrayList<SubTask> subTasksList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM subtasks WHERE Task_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int subTaskId = rs.getInt("SubTask_Id");
                int projectId = rs.getInt("Project_Id");
                int taskId = rs.getInt("Task_Id");
                String subTaskName = rs.getString("SubTask_Name");
                String subTaskDescription = rs.getString("SubTask_Description");
                SubTask subTask = new SubTask(subTaskId, projectId, taskId, subTaskName, subTaskDescription);
                getSubTasksEstimatetWorkHoursTable(subTask);
                subTasksList.add(subTask);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subTasksList;
    }

    public SubTask getSubTask(int id) {
        SubTask subTask = new SubTask();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM subtasks WHERE SubTask_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int subTaskId = rs.getInt("SubTask_Id");
                int taskId = rs.getInt("Task_Id");
                int projectId = rs.getInt("Project_Id");
                String subTaskName = rs.getString("SubTask_Name");
                String subTaskDescription = rs.getString("SubTask_Description");

                subTask.setSubTaskId(subTaskId);
                subTask.setTaskId(taskId);
                subTask.setProjectId(projectId);
                subTask.setSubTaskName(subTaskName);
                subTask.setSubTaskDescription(subTaskDescription);
                getSubTasksEstimatetWorkHoursTable(subTask);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subTask;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Updaters------------------------------------*/
    /*------------------------------------------------------------------*/

    public void updateSubTask(SubTask subTask) {
        Connection con = DBManager.getConnection();
        try {
            con.setAutoCommit(false);

            updateSubTaskTable(subTask);
            updateSubTasksEstimatetWorkhours(subTask);

            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateSubTaskTable(SubTask subTask) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE subtasks SET SubTask_Description = ? WHERE SubTask_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, subTask.getSubTaskDescription());
            ps.setInt(2, subTask.getSubTaskId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateSubTasksEstimatetWorkhours(SubTask subTask) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE subtaskestimatetworkhours SET EstimatetWorkHours = ? WHERE SubTaskEWH_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, subTask.getEstimatetWorkHours());
            ps.setInt(2, subTask.getSubtasksEWHId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getSubTasksEstimatetWorkHoursTable(SubTask subTask) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT EstimatetWorkHours, SubTaskEWH_Id\n" +
                    "FROM subtaskestimatetworkhours\n" +
                    "WHERE Subtask_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subTask.getSubTaskId());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                subTask.setEstimatetWorkHours(rs.getDouble("EstimatetWorkHours"));
                subTask.setSubtasksEWHId(rs.getInt("SubTaskEWH_Id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
      }
    }

}
