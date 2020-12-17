package alphaSolutions.data.mapper;

import alphaSolutions.domainObjects.SubProject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubProjectMapperTest {

    @Test
    void getSubProjectDependencies() {

        SubProjectMapper subProjectMapper = new SubProjectMapper();
        SubProject subProject = new SubProject();
        subProject.setSubProjectId(32);

        ArrayList<SubProject> subProjectDependenciesList = subProjectMapper.getSubProjectDependencies(32);

        assertEquals(subProjectDependenciesList.size(), 1);
    }


    @Test
    void createSubProjectDependency() {
        SubProjectMapper subProjectMapper = new SubProjectMapper();

        subProjectMapper.createSubProjectDependency(35, 34);
        ArrayList<SubProject> subProjectDependenciesList = subProjectMapper.getSubProjectDependencies(35);

        assertEquals(subProjectDependenciesList.size(), 1);
    }
}