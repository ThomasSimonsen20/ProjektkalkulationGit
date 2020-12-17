package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.Project;
import alphaSolutions.domainObjects.Task;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    @Test
    void getTask() {
        TaskMapper taskMapper = new TaskMapper();

        Task task = taskMapper.getTask(26);

        assertEquals(task.getSubProjectId(), 32);

    }

    @Test
    void updateTask() {
        TaskMapper taskMapper = new TaskMapper();
        Task task = taskMapper.getTask(31);
        task.setTaskName("Jens");

        taskMapper.updateTask(task);

        assertEquals(task.getTaskName(), "Jens");

    }


}