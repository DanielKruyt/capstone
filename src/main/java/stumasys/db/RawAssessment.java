package stumasys.db;

import java.util.Map;

public class RawAssessment implements Assessment {
    private String id;
    private int markCap;
    private Database db; // reference to the creator of this object so we can read marks from the database upon request

    public RawAssessment(int mc, Database db) {
        markCap = mc;
        this.db = db;
    }

    public int getMarkCap() {
        return markCap;
    }

    public int getStudentMark(String id) {
        int rm = getUncappedStudentMark(id);
        return ((markCap <= rm) ? markCap : rm);
    }

    public int getUncappedStudentMark(String stuId) {
        return db.getRawAssessmentMark(this.id, stuId);
    }

    public void setStudentMark(String stuId, int mark) {
        db.setRawAssessmentMark(this.id, stuId, mark);
    }

    public void setMarkCap(int mc) {
        markCap = mc;
        db.setRawAssessmentMarkCap(id, mc);
    }
}
