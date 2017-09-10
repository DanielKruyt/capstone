package stumasys.db;

import java.util.List;
import java.util.Iterator;

public class CalculatedAssessment implements Assessment {
    // TODO: stage 4: extend this class to allow arbitrary calculations 
    // including min/max, branching, etc, since weighted averages are not the
    // only computations commonly done.

    // TODO: stage 4: write something along the lines of a "rational number"
    // class for weighting in these calculations, rather than using int's.
    // (Normal float/double aren't appropriate for various reasons.)

    private List<Assessment> src;
    private List<Boolean> useUncapped; // <--- if null, only uses capped marks
    private List<Integer> weight;
    private int markCap;

    public static int calculateAppropriateMarkCap(List<Assessment> src, List<Integer> weight) {
        Iterator<Integer> wIter = weight.iterator();
        int mc = 0;
        for (Assessment a : src) {
            mc += a.getMarkCap()*wIter.next();
        }
        return mc;
    }

    public CalculatedAssessment(List<Assessment> src, List<Integer> weight) {
        this(src, null, weight, calculateAppropriateMarkCap(src, weight));
        assert(src.size() == weight.size());
    }

    public CalculatedAssessment(
            List<Assessment> src, List<Boolean> useUncapped, List<Integer> weight,
            int markCap
    ){
        this.src = src;
        this.useUncapped = useUncapped;
        this.weight = weight;
        this.markCap = markCap;
    }

    public int getMarkCap() {
        return markCap;
    }

    public int getStudentMark(String id) {
        int mark = getUncappedStudentMark(id);
        return ((markCap < mark) ? markCap : mark);
    }

    public int getUncappedStudentMark(String id) {
        int mark = 0;
        Iterator<Integer> wIter = weight.iterator();
        if (useUncapped == null) {
            for (Assessment a : src) {
                mark += a.getStudentMark(id);
            }
        } else {
            Iterator<Boolean> uncapIter = useUncapped.iterator();
            for (Assessment a : src) {
                int m;
                if (uncapIter.next()) {
                    m = a.getUncappedStudentMark(id);
                } else {
                    m = a.getStudentMark(id);
                }
                mark += wIter.next() * m;
            }
        }
        return mark;
    }

}
