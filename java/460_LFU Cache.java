/**
 * 难题，太难了，主要是很多细节。
 * 
 */
class LFUCache {

    static class Node {
        private int key;
        private int val;
        private int freq;
        private Node prev;
        private Node next;
    }
    
    private Map<Integer, Node> nodeByKey = new HashMap<>();
    private Map<Integer, Node> nodeByFreq = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();

    final int capacity;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        head.freq = -1;
        tail.freq = -1;
        tail.prev = head;
        head.next = tail;
        
    }
    
    public int get(int key) {
        //System.out.println("get " + key);
        Node node = nodeByKey.get(key);        
        if (node == null) { return -1; }
        Node nextNode = node.next;        
        // remove from nodeByFreq
        if (nodeByFreq.get(node.freq) == node) {
            if (node.next.freq == node.freq) {
                nodeByFreq.put(node.freq, node.next);
            } else {
                nodeByFreq.remove(node.freq);
            }
        } else {
            nextNode = nodeByFreq.get(node.freq);
        }        
        if (nodeByFreq.containsKey(node.freq + 1)) {
            nextNode = nodeByFreq.get(node.freq + 1);
        }
        // remove node from list
        node.prev.next = node.next;
        node.next.prev = node.prev;
                
        ++node.freq;                
        
        // add new freq to nodeByFreq
        node.next = nextNode;        
        node.prev = nextNode.prev;        
        node.prev.next = node;
        node.next.prev = node;
        nodeByFreq.put(node.freq, node);        
        return node.val;
    }
    
    public void put(int key, int value) {
        //System.out.println("put " + key + " " + value);
        if (capacity == 0) { return; }
        nodeByKey.putIfAbsent(key, new Node());
        
        if (nodeByKey.size() > capacity) {
            Node toRemove = tail.prev;
            // remove from nodeByFreq
            if (nodeByFreq.get(toRemove.freq) == toRemove) {                
                nodeByFreq.remove(toRemove.freq);
            }
            // remove from list
            toRemove.prev.next = tail;
            tail.prev = toRemove.prev;
            // remove from nodeByKey
            nodeByKey.remove(toRemove.key);
        }

        Node node = nodeByKey.get(key);
        node.key = key;
        node.val = value;        
        // new node inserted
        if (node.freq == 0) {
            node.prev = tail.prev;
            node.next = tail;
            node.prev.next = node;
            node.next.prev = node;
            nodeByFreq.put(node.freq, node);
        }        
        get(key);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */