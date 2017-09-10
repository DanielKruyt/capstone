package stumasys.db;

import java.util.Map;
import java.util.ArrayList;

public class Database {

    // TODO: stage 4: create a proper database backend that interacts with
    // an SQL server instead of these tables

    private Map<String, Course> courses;
    private Map<String, User> users;
    private Map<String, Map<String, Integer>> rawAssessments;

    public Database() {
        /*
        ArrayList<Courses> course = new ArrayList<Courses>();

        int[] a = new int[3];   a[0] = 50; a[1] = 70; a[2] = 60;
        int[] b = new int[3];   b[0] = 70; b[1] = 75; b[2] = 54;
        int[] c = new int[3];   c[0] = 65; c[1] = 87; c[2] = 65;
        int[] d = new int[3];   d[0] = 76; d[1] = 56; d[2] = 87;

        course.add(new Courses("csc1001f", 2015, a));
        course.add(new Courses("csc1002s", 2015, b));
        course.add(new Courses("csc2001f", 2016, c));
        course.add(new Courses("csc2001s", 2016, d));

        User admin = new Admin("admin", "123qwe");
        User stu = new Student("stu", "qwe123" , course);

        course.get(0).addUser(stu);
        course.get(1).addUser(stu);
        course.get(2).addUser(stu);
        course.get(3).addUser(stu);

        users.add(admin);
        users.add(stu);

        initialize();
        */
    }

    public Course getCourse(String code, int year) {
    }

    public User getUser(String id) {
    }

    /* The following are an interface used by the objects returned by this class
     * to fetch additional data from, and synchronise changes with, the database
     * underlying the system. For now, we're hardcoding things without having an
     * actual DB present.
     */

    protected void setPassword(String userId, byte[] pwHash) { // TODO: 
    }

    protected int getRawAssessmentMark(String aId, String uId) {
        return rawAssessments.get(aId).get(uId);
    }

    protected void setRawAssessmentMark(String aId, String uId, int mark) { // TODO: 
    }

    protected void setRawAssessmentMarkCap(String aId, int mc) {
    }

}
