package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.SubProject;
import alphaSolutions.domainObjects.Task;

import java.sql.*;
import java.util.ArrayList;

public class TaskMapper {

    public void createTask(Task task) {
        Connection con = DBManager.getConnection();
        try {
            con.setAutoCommit(false);

            PreparedStatement psCreateTaskTable = createTaskTable(task);
            task.setTaskId(getGeneratedKeys(psCreateTaskTable));

            PreparedStatement psCreateTasksEstimatetWorkHoursTable = createTasksEstimatetWorkHoursTable(task);
            task.setTasksEWHId(getGeneratedKeys(psCreateTasksEstimatetWorkHoursTable));

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

    public PreparedStatement createTaskTable (Task task) {
        PreparedStatement ps = null;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO tasks (Project_Id, SubProject_Id, Task_Name, Task_Description) VALUES (?,?,?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, task.getProjectId());
            ps.setInt(2, task.getSubProjectId());
            ps.setString(3, task.getTaskName());
            ps.setString(4, task.getTaskDescription());
            ps.executeUpdate();

        } catch (SQLException ex) {
        ex.printStackTrace();
    }
        return ps;
    }

    public PreparedStatement createTasksEstimatetWorkHoursTable (Task task) {
        PreparedStatement ps = null;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO tasksestimatetworkhours (Task_Id, EstimatetWorkHours) VALUES (?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, task.getTaskId());
            ps.setDouble(2, task.getEstimatetWorkHours());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ps;
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


    public void createTaskDependency(int taskId, String dependency) {

        try {
            int dependencyId = getDependencyIdFromDependencyName(dependency);
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO taskdependencies (Task_Id, TaskDependency_Id) VALUES (?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, taskId);
            ps.setInt(2, dependencyId);
            ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    private int getDependencyIdFromDependencyName(String dependencyName){
        int dependency_id = 0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT Tasks.Task_Id FROM Tasks WHERE Tasks.Task_Name = ?;";
            //String SQLDepName = "'" + dependencyName + "'";
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



    public ArrayList<Task> getTasksBasedOnSubProjectID(int id) {
        ArrayList<Task> tasksList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM tasks WHERE SubProject_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int taskId = rs.getInt("Task_Id");
                int projectId = rs.getInt("Project_Id");
                int subProjectId = rs.getInt("SubProject_Id");
                String taskName = rs.getString("Task_Name");
                String taskDescription = rs.getString("Task_Description");
                Task task = new Task(taskId, projectId, subProjectId, taskName, taskDescription);
                getTasksEstimatetWorkHoursTable(task);
                tasksList.add(task);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasksList;
    }

    public ArrayList<Task> getTasksBasedOnSubProjectIdOmitCurrentTask(int idSubProject, int idTask) {
        ArrayList<Task> tasksList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM tasks WHERE SubProject_Id = ? AND Task_Id NOT IN (?);";
            //String SQL = "SELECT * FROM tasks WHERE SubProject_Id = ? AND Task_Id != ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,idSubProject);
            String s = "" + idTask;
            ps.setInt(2, idTask);
            //ps.setString(2,"'" + idTask + "'");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int taskId = rs.getInt("Task_Id");
                int projectId = rs.getInt("Project_Id");
                int subProjectId = rs.getInt("SubProject_Id");
                String taskName = rs.getString("Task_Name");
                String taskDescription = rs.getString("Task_Description");
                Task task = new Task(taskId, projectId, subProjectId, taskName, taskDescription);
                getTasksEstimatetWorkHoursTable(task);
                tasksList.add(task);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasksList;
    }

    public ArrayList<String> getTaskNamesBySubProjectIdOmitCurrentAndDependentTasks(int idSubProject, int idTask) {
        ArrayList<String> tasksList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();

            String SQL = "SELECT *\n" +
                    "FROM Tasks  \n" +
                    "LEFT JOIN TaskDependencies ON TaskDependencies.Task_Id = Tasks.Task_Id\n" +
                    "WHERE SubProject_Id = ?\n" +
                    "AND Tasks.Task_Id NOT IN (SELECT TaskDependency_Id FROM TaskDependencies WHERE Task_Id = ?)\n" +
                    "AND  Tasks.Task_Id != ?;";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,idSubProject);
            ps.setInt(2, idTask);
            ps.setInt(3, idTask);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String taskName = rs.getString("Task_Name");
                tasksList.add(taskName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasksList;
    }

    public Task getTask(int id) {
        Task task = new Task();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM tasks WHERE Task_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int taskId = rs.getInt("Task_Id");
                int projectId = rs.getInt("Project_Id");
                int subProjectID = rs.getInt("SubProject_Id");
                String taskName = rs.getString("Task_Name");
                String taskDescription = rs.getString("Task_Description");

                task.setTaskId(taskId);
                task.setProjectId(projectId);
                task.setSubProjectId(subProjectID);
                task.setTaskName(taskName);
                task.setTaskDescription(taskDescription);
                getTasksEstimatetWorkHoursTable(task);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return task;
    }

    public void updateTask(Task task) {
     Connection con = DBManager.getConnection();
     try {
         con.setAutoCommit(false);

         updateTaskTable(task);
         updateTasksEstimatetWorkhours(task);

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

    public void updateTaskTable(Task task) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE tasks SET Task_Name = ?, Task_Description = ? WHERE Task_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, task.getTaskName());
            ps.setString(2, task.getTaskDescription());
            ps.setInt(3, task.getTaskId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateTasksEstimatetWorkhours (Task task) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "UPDATE tasksestimatetworkhours SET EstimatetWorkHours = ? WHERE TasksEWH_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, task.getEstimatetWorkHours());
            ps.setInt(2, task.getTasksEWHId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getTasksEstimatetWorkHoursTable(Task task) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT EstimatetWorkHours, TasksEWH_Id\n" +
                    "FROM tasksestimatetworkhours\n" +
                    "WHERE Task_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, task.getTaskId());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                task.setEstimatetWorkHours(rs.getDouble("EstimatetWorkHours"));
                task.setTasksEWHId(rs.getInt("TasksEWH_Id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getTaskDependencies(int id) {
        ArrayList<String> tasksList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT TaskDependencies.TaskDependency_Id, Tasks.Task_Name\n" +
                    "FROM TaskDependencies\n" +
                    "LEFT JOIN Tasks ON TaskDependencies.TaskDependency_Id = Tasks.Task_Id\n" +
                    "WHERE TaskDependencies.Task_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //int taskId = rs.getInt("Task_Id");
                String taskName = rs.getString("Task_Name");
                tasksList.add(taskName);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasksList;
    }

    public ArrayList<Integer> getTaskDependencyIds(int id) {
        ArrayList<Integer> idTasksList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT TaskDependency_Id FROM TaskDependencies WHERE Task_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int taskId = rs.getInt("TaskDependency_Id");
                idTasksList.add(taskId);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idTasksList;
    }

    public int getSubProjectIdBasedOnTaskId(int taskId) {
        int subProject_Id = 0;
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT SubProject_Id FROM tasks WHERE Task_Id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, taskId);
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                subProject_Id = rs.getInt("SubProject_Id");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subProject_Id;

    }



}
