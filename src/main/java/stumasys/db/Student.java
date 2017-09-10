package stumasys.db;

import java.util.List;
import java.util.Collections;

public class Student extends User {
    private List<Course> involvedIn; // list of all courses this student
                                     // is enrolled in, tutoring for, etc.
    public Student(
            String id, List<Courses> courses,
            byte[] pwDHash, byte[] pwHashSalt
    ){
        super(id, pwDHash, pwHashSalt);
        involvedIn = courses;
    }

    public List<Course> getInvolvedCourses() {
        return Collections.unmodifiableList(involvedIn);
    }

    public boolean addCourse(Course c) { // returns a success status
        involvedIn.add(c);
        return true;
    }

    public boolean removeCourse(Course c) { // returns success status
        return involvedIn.remove(c);
    }

    // TODO: stage 4: track additions/removals from courses to update the DB correctly
}
