package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.Project;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class ProjectMapperTest {


    @Test
    void getProjectRunGreen() {
        ProjectMapper projectMapper = new ProjectMapper();

        Project project = projectMapper.getProject(12);

        assertEquals(project.getProjectName(), "Nordea");

    }

    @Test
    void getProjectRunRed() {
        ProjectMapper projectMapper = new ProjectMapper();

        Project project = projectMapper.getProject(13);

        assertEquals(project.getProjectName(), "asd");

    }

    @Test
    void getProjectWrongId() {
        ProjectMapper projectMapper = new ProjectMapper();

        Project project = projectMapper.getProject(2);

        assertEquals(project.getProjectName(), null);

    }
}