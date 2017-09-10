package stumasys;
import java.util.List;

public class Course {       // check public, private and protected status for each method and class

    private String name;
    private int year;
    private List<User> participants;

    public Course(String name, int year, List<User> participants) {
        this.name = name;
        this.year = year;
    }

    public Course(String name, String year){
        this.name = name;
        this.year = Integer.parseInt(year);
    }

    

    // TODO: stage 4: keep track of modifications to the course so we can commit
    // them to the DB later.
}
