/**
 * Use a vectorList to record all the iterator of the input lists.
 * Use a cursor to record which iterator to use in the next call
 * If an iterator reaches end after next call, remove it from vectorList
 */
public class ZigzagIterator {

    List<Iterator<Integer>> vectorLists;
    int cursor = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vectorLists = new ArrayList<>();
        if (v1.iterator().hasNext()) {
            vectorLists.add(v1.iterator());
        }
        if (v2.iterator().hasNext()) {
            vectorLists.add(v2.iterator());
        }
    }

    public int next() {
        if (hasNext()) {
            Iterator<Integer> resultIter = vectorLists.get(cursor);
            int result = resultIter.next();
            if (!resultIter.hasNext()) {
                vectorLists.remove(cursor);
                if (vectorLists.size() != 0)
                    cursor = cursor % vectorLists.size();
            } else {
                cursor = (++cursor) % vectorLists.size();
            }
            return result;
        } else {
            return 0;
        }
    }

    public boolean hasNext() {
        return (vectorLists.size() > 0);
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */