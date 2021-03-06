package alphaSolutions.data.mapper;

import alphaSolutions.data.database.DBManager;
import alphaSolutions.domainObjects.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*------------------------------------------------------------------*/
/*---------------------author; Simon K------------------------------*/
/*------------------------------------------------------------------*/

public class EmployeeMapper {

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public ArrayList<Employee> getAllStaff() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM Employees";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int employeeId = rs.getInt("Employee_Id");
                String firstName = rs.getString("First_Name");
                String lastName = rs.getString("Last_Name");
                String profilePicture = rs.getString("Profile_Picture");
                int employeeNumber = rs.getInt("Employee_Number");
                Employee employee = new Employee(firstName, lastName, employeeNumber, profilePicture);
                employee.setEmployeeId(employeeId);
                employee.setSkills(employeeId);
                employeeList.add(employee);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employeeList;
    }

    public Employee getEmployee(int id) {
        Employee employee = new Employee();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM Employees WHERE Employee_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int employeeId = rs.getInt("Employee_Id");
                int employeeNumber = rs.getInt("Employee_Number");
                String firstName = rs.getString("First_Name");
                String lastName = rs.getString("Last_Name");
                String profilePicture = rs.getString("Profile_Picture");

                employee.setEmployeeId(employeeId);
                employee.setEmployeeNumber(employeeNumber);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setProfilePicture(profilePicture);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    public ArrayList<String> getSkillsForCertainEmployee(int id) {
        ArrayList<String> skills = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();

            String SQL = "Select Skill_Description\n" +
                    "FROM employeeskills\n" +
                    "LEFT JOIN Skills ON employeeskills.Skill_Id = Skills.Skill_Id\n" +
                    "WHERE Employee_Id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                skills.add(rs.getString("Skill_Description"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return skills;
    }
}
