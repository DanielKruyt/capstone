package stumasys.db;

public interface Assessment {
    public int getMarkCap();
    public int getStudentMark(String id);
    public int getUncappedStudentMark(String id);
}
