package alphaSolutions.domainObjects;

import alphaSolutions.data.mapper.Facade;

import java.util.ArrayList;

/*------------------------------------------------------------------*/
/*---------------------author; Mikkel F-----------------------------*/
/*------------------------------------------------------------------*/

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private int employeeNumber;
    private ArrayList<String> skills = new ArrayList<>();

    private SystemController systemController = new SystemController(new Facade());

    /*------------------------------------------------------------------*/
    /*----------------------Constructors--------------------------------*/
    /*------------------------------------------------------------------*/

    public Employee(String firstName, String lastName, int employeeNumber, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.profilePicture = profilePicture;

    }

    public Employee() {
    }

    /*------------------------------------------------------------------*/
    /*----------------------Getters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public ArrayList<String> getSkills(){
        return skills;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    /*------------------------------------------------------------------*/
    /*----------------------Setters-------------------------------------*/
    /*------------------------------------------------------------------*/

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setSkills (int employeeId){
        this.skills = systemController.getSkillsForCertainEmployee(employeeId);
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
