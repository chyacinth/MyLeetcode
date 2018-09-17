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
  public int minMeetingRooms(Interval[] intervals) {
    PriorityQueue<Integer> endMinHeap = new PriorityQueue<>();
    Arrays.sort(intervals, (a, b) -> { return Integer.compare(a.start, b.start); });
    for (Interval interval : intervals) {
      //initial stage
      if (endMinHeap.isEmpty()) {
        endMinHeap.offer(interval.end);
      } else {
        //get earliest end time of current meeting room
        int earlyEndTime = endMinHeap.poll();
        
        //the meeting room can hold this interval
        if (earlyEndTime <= interval.start) {
          endMinHeap.offer(interval.end);
        } else {
        //the meeting room cannot hold this interval  
          endMinHeap.offer(interval.end);
          endMinHeap.offer(earlyEndTime);
        }
      }
    }
    return endMinHeap.size();
  }
}