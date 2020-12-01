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
            subTask.setTaskId(id);
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
                subTasksList.add(subTask);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subTasksList;
    }

}
