package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.Facade;
import alphaSolutions.data.mapper.TaskMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {



    @Test
    void getEstimatetWorkHoursIntoIf() {
        Task task = new Task();

        task.setTaskId(31);
        task.setEstimatetWorkHours(20);

        assertEquals(task.getEstimatetWorkHours(), 111);
    }

    @Test
    void getEstimatetWorkHoursIntoElse() {
        Task task = new Task();

        task.setTaskId(33);
        task.setEstimatetWorkHours(200);

        assertEquals(task.getEstimatetWorkHours(), 200);
    }




}