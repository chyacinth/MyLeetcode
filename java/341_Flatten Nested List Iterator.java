/**
 * 做繁了，其实只要一个函数将整个Iterator变成一个数组或List就完事了，next和hasNext只要取数组元素即可
 * 我这个方法是每一次next就向后找一次，适合元素很多的情况。
 * 我的方法：
 * nextElement函数，是类里记录的currentIdx是next时，会找这个List中的第currentIdx项，如果是Integer直接输出，
 * 如果不是，用类成员currentNestedElement记录这个NestedInteger生成的NestedIterator对象，对其调用next
 * next完了后如果currentNestedElement hasNext则不变，不然currentIdx+1
 * hasNext函数：
 * 调用多次nextElement，直到返回值不是null，(考虑{ [[[]]],[[]], 1 }这样的例子)，找到存在nextVal中。
 * 如果nextVal不是null，说明已经找过，不再运行
 * 真正的next函数：调用hasNext函数，然后返回值为nextVal，之后将nextVal置Null
 * 其实没必要这样做……
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> list;
    int currentIdx;
    NestedIterator currentNestedElement;
    Integer nextVal = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        currentIdx = 0;
        if (nestedList.size() > 0 && !nestedList.get(currentIdx).isInteger()) {
            currentNestedElement = new NestedIterator(nestedList.get(currentIdx).getList());
        }
    }

    @Override
    public Integer next() {
        Integer result = null;
        if (hasNext()) {
            result = nextVal;
            nextVal = null;            
        }
        return result;
    }
    public Integer nextElement() {
        Integer result = 0;
        if (list == null || list.size() == 0) return null;
        if (list.get(currentIdx).isInteger()) {
            result = list.get(currentIdx).getInteger();
            ++currentIdx;
            if (currentIdx < list.size() && 
                !list.get(currentIdx).isInteger()) {
                currentNestedElement = new NestedIterator(list.get(currentIdx).getList());
            }
            return result;
        } else {
            result = currentNestedElement.next();
            if (!currentNestedElement.hasNext()) {
                ++currentIdx;
                if (currentIdx < list.size() && 
                !list.get(currentIdx).isInteger()) {
                    currentNestedElement = new NestedIterator(list.get(currentIdx).getList());
                }
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (nextVal != null) {
            return true;
        }
        if (list == null || list.size() == 0) {
            nextVal = null;
            return false;
        }
        while (currentIdx < list.size()) {
            nextVal = nextElement();
            if (nextVal != null) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */