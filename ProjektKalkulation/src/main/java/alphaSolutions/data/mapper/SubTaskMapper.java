package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.SubProject;
import alphaSolutions.domainObjects.SubTask;
import alphaSolutions.domainObjects.Task;

import java.sql.*;
import java.util.ArrayList;

public class SubTaskMapper {

    public void createSubTask(SubTask subTask) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subtasks (Project_Id, Task_Id, SubTask_Description) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subTask.getProjectId());
            ps.setInt(2, subTask.getTaskId());
            ps.setString(3, subTask.getSubTaskDescription());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            subTask.setSubTaskId(id);

            SQL = "INSERT INTO subtaskestimatetworkhours (Subtask_Id, EstimatetWorkHours) VALUES (?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subTask.getSubTaskId());
            ps.setDouble(2, subTask.getEstimatetWorkHours());
            ps.executeUpdate();

            ids = ps.getGeneratedKeys();
            ids.next();
            id = ids.getInt(1);
            subTask.setSubtasksEWHId(id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
                String subTaskDescription = rs.getString("SubTask_Description");
                SubTask subTask = new SubTask(subTaskId, projectId, taskId, subTaskDescription);
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
                String subTaskDescription = rs.getString("SubTask_Description");

                subTask.setSubTaskId(subTaskId);
                subTask.setTaskId(taskId);
                subTask.setProjectId(projectId);
                subTask.setSubTaskDescription(subTaskDescription);
                getSubTasksEstimatetWorkHoursTable(subTask);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subTask;
    }

    public void updateSubTask(SubTask subTask) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE subtasks SET SubTask_Description = ? WHERE SubTask_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, subTask.getSubTaskDescription());
            ps.setInt(2, subTask.getSubTaskId());
            ps.executeUpdate();

            SQL = "UPDATE subtaskestimatetworkhours SET EstimatetWorkHours = ? WHERE SubTaskEWH_Id = ?";
            ps = con.prepareStatement(SQL);
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
