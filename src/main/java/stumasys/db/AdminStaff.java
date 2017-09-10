package stumasys.db;

public class AdminStaff extends User {
    private String department;

    public AdminStaff(
            String id,
            byte[] pwDHash, byte[] pwHashSalt,
            String department
    ){
        super(id, pwDHash, pwHashSalt);
    }

    public String getDepartment() {
        return department;
    }
}
