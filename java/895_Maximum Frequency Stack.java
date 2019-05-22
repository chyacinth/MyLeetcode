/**
 * 难题。可以用TreeMap，但是有更快的O(1)算法，见https://leetcode.com/problems/maximum-frequency-stack/discuss/163410/C%2B%2BJavaPython-O(1)
 */
import java.util.NavigableSet;

class FreqStack {
    
    NavigableSet<Integer> elemSet;
    Map<Integer, ArrayList<Integer>> locationsByElem = new HashMap<Integer, ArrayList<Integer>>();
    int size = 0;
    
    public FreqStack() {
        elemSet = new TreeSet<Integer>(
            (e1, e2) -> {
                ArrayList<Integer> e1Locations = locationsByElem.get(e1);
                ArrayList<Integer> e2Locations = locationsByElem.get(e2);
                if (e1Locations.size() < e2Locations.size()) { return -1; }
                if (e1Locations.size() > e2Locations.size()) { return 1; }
                
                int laste1 = e1Locations.get(e1Locations.size() - 1);
                int laste2 = e2Locations.get(e2Locations.size() - 1);
                if (laste1 < laste2) { return -1; }                
                if (laste1 > laste2) { return 1; }
                return 0;
            }
        );
    }
    
    public void push(int x) {
        //System.out.println("push " + x + ", size: " + elemSet.size());
        locationsByElem.putIfAbsent(x, new ArrayList<Integer>());
        
        if (locationsByElem.get(x).size() > 0) {
            elemSet.remove(x);
        }
        
        ArrayList<Integer> locations = locationsByElem.get(x);
        locations.add(size);        
        ++size;

        elemSet.add(x);
    }
    
    public int pop() {
        //System.out.println("pop " + elemSet.size());
        int x = elemSet.pollLast();
        //--size;
        ArrayList<Integer> locations = locationsByElem.get(x);
        locations.remove(locations.size() - 1);
        
        if (locations.size() > 0) {
            elemSet.add(x);
        }
        
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */