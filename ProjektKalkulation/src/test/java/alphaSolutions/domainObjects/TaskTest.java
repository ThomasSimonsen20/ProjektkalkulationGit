package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.TaskMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getEstimatetWorkHours() {
        Task task = new Task();
        task.setTaskId(8);
        System.out.println(task.getEstimatetWorkHours());
    }
}