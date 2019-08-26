/**
 * 其实不简单，欧拉回路+每次选最小的边，这会导致结果的lexical order最小。很神秘，需要多想想
 */
class Solution {
  
  private LinkedList<String> result = new LinkedList<>();
  private Map<String, Queue<String>> target = new HashMap<>();
  
  private void visit(String airport) {
    while (target.containsKey(airport) && !target.get(airport).isEmpty()) {
      String next = target.get(airport).poll();
      visit(next);
    }
    result.addFirst(airport);
  }
  
  public List<String> findItinerary(List<List<String>> tickets) {
    for (List<String> ticket : tickets) {
      target.computeIfAbsent(ticket.get(0), key -> { 
        return new PriorityQueue<>();
      }).offer(ticket.get(1));
    }
    visit("JFK");
    return result;
  }
}