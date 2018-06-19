/*
难题。主要是实现要bug-free比较难
用Node的链表来存储age关系，越靠近队尾越new，越靠近队头越old
用map<Integer, Node>存储key和Node关系，使得找Node速度很快
卧槽发现其实这就是一个LinkedHashMap
过程中漏的几个点：
1. 凡是涉及到链表的删除元素操作，一定要看这个元素是不是tail！分情况讨论，或者tail作为dummy node！
2. 在put方法中如果key是已经之前put过的key，则直接改对应的node的val域
3. 在put调用时如果key是已经之前put过的key，则需要调用get，来改变LRU中的age关系（因为这个节点相当于被访问了一次，要变new）
*/
class LRUCache {
    
    static class Node {
        public int key, val;
        public Node next, prev;
        Node(int thekey, int value) {
            key = thekey;
            val = value;
            next = null;
            prev = null;
        }
    }
    
    private HashMap<Integer, Node> key2node = new HashMap<>();
    
    int cap = 0;
    int cnt = 0;
    Node head = null, tail = null;
    
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        Node value = key2node.get(key);        
        if (value != null) {
            if (value != tail) {
                value.prev.next = value.next;
                if (value.next != null) value.next.prev = value.prev;
                tail.next = value;
                value.prev = tail;
                value.next = null;
                tail = value;
            }
            return value.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (cnt == 0) {
            head = new Node(key, 0);
            Node val = new Node(key, value);
            
            //update head
            head.next = val;
            val.prev = head;
            
            //update tail
            tail = val;            
            
            //update map
            key2node.put(key, val);
            
            //update cnt
            cnt += 1;
        }
        else {
            Node tempn = key2node.get(key);
            if (tempn != null) {
                get(key);
                //update list
                key2node.get(key).val = value;
                                
            }
            else if (cnt >= cap) {
                
                //update head
                Node removed = head.next;
                head.next = removed.next;
                if (removed.next != null) removed.next.prev = head;
                    
                //update tail
                tail.next = new Node(key, value);
                tail.next.prev = tail;
                tail = tail.next;
                
                //update map
                key2node.remove(removed.key);
                key2node.put(key,tail);
            }
            else {
                
                //update tail
                tail.next = new Node(key, value);
                tail.next.prev = tail;
                tail = tail.next;
                
                //update map                
                key2node.put(key,tail);
                
                cnt += 1;

            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */