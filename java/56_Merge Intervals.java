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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> a.start - b.start);        
        List<Interval> results = new ArrayList<Interval>();
        if (intervals.size() == 0) {return results;}
        Interval tempInterval = new Interval(-1, -1);
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start, end = intervals.get(i).end;
            if (tempInterval.start == -1) {
                tempInterval = new Interval(start, end);
            }
            else {
                if (start >= tempInterval.start && start <= tempInterval.end) {
                    tempInterval = new Interval(tempInterval.start, Math.max(end, tempInterval.end));
                }
                else {
                    results.add(tempInterval);
                    tempInterval = new Interval(start, end);
                }
            }
        }                
        if (tempInterval.start != -1) {
            results.add(tempInterval);
        }        
        return results;
    }
}