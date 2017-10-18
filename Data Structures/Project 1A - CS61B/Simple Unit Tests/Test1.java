import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by havinleung on 2017-06-27.
 */
public class Test1 {
    private LinkedListDeque<Integer> deque;

    @Before
    public void before(){
        deque = new LinkedListDeque<>();
        deque.addFirst(50);
        deque.addLast(51);
        deque.addFirst(49);
    }

    @Test
    public void indexTest() {
        assertEquals("Index 0: ", 49, (int) deque.get(0));
        assertEquals("Index 1: ", 50, (int) deque.get(1));
        assertEquals("Index 2: ", 51, (int) deque.get(2));
        assertEquals("Size: ", 3, deque.size());
    }

    @Test
    public void removeTest(){
        assertEquals("Remove Last: ", 51, (int) deque.removeLast());
        assertEquals("Remove First: ", 49, (int) deque.removeFirst());
        assertEquals("Size: ", 1, deque.size());
        assertEquals("Check if items are really removed: ",null,deque.get(1));
    }

    @Test
    public void emptyTest(){
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        assertEquals("Empty test: ",0,deque.size());
        assertEquals("Empty test: ",true,deque.isEmpty());
    }


}
