/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a,b)->{return a.start - b.start;});
        int prevEnd = 0;
        for (int i = 0; i < intervals.length; ++i){            
            if (intervals[i].start < prevEnd) return false;
            else { prevEnd = intervals[i].end; }
        }
        return true;
    }
}