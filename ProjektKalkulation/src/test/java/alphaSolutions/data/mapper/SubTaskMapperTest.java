package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.SubTask;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.*;

class SubTaskMapperTest {

    @Test
    void setSubTasksEstimatetWorkHoursTable() {
        SubTaskMapper subTaskMapper = new SubTaskMapper();
        SubTask subTask = new SubTask();

        subTask.setSubTaskId(16);
        subTask.setEstimatetWorkHours(1000);

        subTaskMapper.setSubTasksEstimatetWorkHoursTable(subTask);

        assertEquals(subTask.getEstimatetWorkHours(), 8000);

    }


    @Test
    void createSubTask() {
        SubTaskMapper subTaskMapper = new SubTaskMapper();
        SubTask subTask = new SubTask();

        subTask.setTaskId(26);
        subTask.setProjectId(12);
        subTask.setSubTaskName("testName");
        subTask.setSubTaskDescription("testDescription");
        PreparedStatement psCreateSubTasksTable = subTaskMapper.createSubTasksTable(subTask);
        subTask.setSubTaskId(subTaskMapper.getGeneratedKeys(psCreateSubTasksTable));
        subTask.setEstimatetWorkHours(200);

        subTaskMapper.createSubTask(subTask);
        SubTask newSubTask = subTaskMapper.getSubTask(subTask.getSubTaskId());

        assertEquals(newSubTask.getEstimatetWorkHours(), 200);
        assertEquals(newSubTask.getSubTaskDescription(), "testDescription");

    }

}