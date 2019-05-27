import java.util.NavigableMap;
class Solution {
    static class Edge {
        int height;
        char type;
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        NavigableMap<Integer, List<Edge>> edges = new TreeMap<Integer, List<Edge>>();
        
        for (int[] building : buildings) {
            int l = building[0];
            int r = building[1];
            int h = building[2];
            edges.putIfAbsent(l, new ArrayList<Edge>());
            edges.get(l).add(new Edge(){{height = h; type = 's';}});
            edges.putIfAbsent(r, new ArrayList<Edge>());
            edges.get(r).add(new Edge(){{height = h; type = 'e';}});            
        }
                        
        NavigableMap<Integer, Integer> occurByHeight = new TreeMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Iterator<Integer> edgeIt = edges.keySet().iterator();
        int prevResult = -1;
        while (edgeIt.hasNext()) {
            int x = edgeIt.next();            
            List<Edge> edgesForX = edges.get(x);
            for (Edge edge : edgesForX) {
                if (edge.type == 's') {
                    occurByHeight.put(edge.height, occurByHeight.getOrDefault(edge.height, 0) + 1);
                } else {
                    occurByHeight.put(edge.height, occurByHeight.get(edge.height) - 1);
                    if (occurByHeight.get(edge.height) == 0)
                        occurByHeight.remove(edge.height);
                }
            }
            int rh = 0;
            if (occurByHeight.size() > 0) {
                rh = occurByHeight.lastKey();
            }
            final int resultHeight = rh;
            if (prevResult == -1 || resultHeight != prevResult) {
                result.add(new ArrayList<Integer>(){{add(x); add(resultHeight); }});
                prevResult = resultHeight;
            }
        }
        return result;
    }
}