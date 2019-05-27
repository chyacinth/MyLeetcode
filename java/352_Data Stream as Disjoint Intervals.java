/**
 * 用TreeMap存Interval
 */
import java.util.NavigableSet;

class SummaryRanges {

    NavigableSet<Interval> intervals = new TreeSet<>((i1, i2) -> {
        return Comparator.<Integer>naturalOrder().compare(i1.l, i2.l);
    });
    
    static class Interval {
        int l;
        int r;
        Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void checkL(Interval i1, int val) {
        if (val == i1.r + 1) {
            ++i1.r;
        } else if (val > i1.r + 1) {
            intervals.add(new Interval(val, val));
        }
    }
    
    public void checkR(Interval i2, int val) {
        if (val == i2.l - 1) {
            --i2.l;
        } else if (val < i2.l - 1) {
            intervals.add(new Interval(val, val));
        }
    }
    
    public void addNum(int val) {
        Interval i1 = intervals.floor(new Interval(val, val));
        Interval i2 = intervals.ceiling(new Interval(val, val));
        if (i1 == null && i2 == null) {
            intervals.add(new Interval(val, val));
        } else if (i2 == null) {            
            checkL(i1, val);
        } else if (i1 == null) {
            checkR(i2, val);
        } else {
            if (val > i1.r + 1 && val < i2.l - 1) {
                intervals.add(new Interval(val, val));
            }
            
            if (val == i1.r + 1) {
                ++i1.r;
            }
            if (val == i2.l - 1) {
                --i2.l;
            }
                        
            if (i1.r == i2.l) {
                intervals.remove(i1);
                intervals.remove(i2);
                intervals.add(new Interval(i1.l, i2.r));
            }
        }
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int i = 0;
        for (Interval interval : intervals) {
            result[i][0] = interval.l;
            result[i][1] = interval.r;
            ++i;
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */