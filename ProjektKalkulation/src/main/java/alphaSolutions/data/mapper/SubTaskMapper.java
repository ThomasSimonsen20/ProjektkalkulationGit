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
                SubTask subTask = new SubTask(projectId, taskId, subTaskDescription);
                subTask.setSubTaskId(subTaskId);
                subTask.setEstimatetWorkHours(getSubTaskEstimatetWorkHours(subTaskId));
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

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setSubTaskEstimatetWorkHours(SubTask subTask) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO subtaskestimatetworkhours (Subtask_Id, EstimatetWorkHours) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, subTask.getSubTaskId());
            ps.setDouble(2, subTask.getEstimatetWorkHours());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            subTask.setSubtasksEWHId(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public double getSubTaskEstimatetWorkHours(int id) {
        Double estimatetWorkHours = 0.0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT subtaskestimatetworkhours.EstimatetWorkHours\n" +
                    "FROM subtaskestimatetworkhours\n" +
                    "WHERE subtaskestimatetworkhours.Subtask_Id = ?;";
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

}
