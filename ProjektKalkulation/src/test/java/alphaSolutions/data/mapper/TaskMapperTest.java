package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    @Test
    void getTasksBasedOnSubProjectIdOmitCurrentTask() {
        TaskMapper taskMapper = new TaskMapper();
        ArrayList<Task> tasksList = taskMapper.getTasksBasedOnSubProjectIdOmitCurrentTask(22,8);
        System.out.println(tasksList.size());

    }

}