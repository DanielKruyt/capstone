package stumasys.db;

import java.util.List;

public class Lecturer extends User {
    private String department;
    private List<Course> involvedIn; // list of courses lecturing-in/convening

    public Lecturer(
            String id, String department, List<Course> courses,
            byte[] pwDHash, byte[] pwHashSalt
    ){
        super(id, pwDHash, pwHashSalt);
        involvedIn = courses;
    }

    public String getDepartment() {
        return department;
    }

    public boolean addCourse(Course c) { // returns a success status
        involvedIn.add(c);
        return true;
    }

    public boolean removeCourse(Course c) { // returns success status
        return involvedIn.remove(c);
    }
}
