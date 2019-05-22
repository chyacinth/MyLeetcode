// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer buf = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.	    
        this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {        
        if (buf == null) {
            buf = iterator.next();            
        }
        return buf;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer result;
	    if (buf == null) {
            return iterator.next();
        } else {
            result = buf;
            buf = null;
            return result;
        }
	}

	@Override
	public boolean hasNext() {
	    if (buf == null) {
            return iterator.hasNext();
        } else {
            return true;
        }
	}
}