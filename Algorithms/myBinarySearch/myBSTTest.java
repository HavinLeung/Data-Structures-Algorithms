import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by havinleung on 2017-07-14.
 */
public class myBSTTest {
    @Test
    public void evenInput(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            list.add(i);
        }
        for(int i = 0; i < 100; i++){
            assertTrue(myBST.myBinarySearch(list,i));
        }
        assertFalse(myBST.myBinarySearch(list,-3));
    }
    @Test
    public void oddInput(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 99; i++){
            list.add(i);
        }
        for(int i = 0; i < 99; i++){
            assertTrue(myBST.myBinarySearch(list,i));
        }
        assertFalse(myBST.myBinarySearch(list,-2));
    }
    @Test
    public void removedInput(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 99; i++){
            list.add(i);
        }
        list.remove(50); //value 50 at index 50 is removed
        assertFalse(myBST.myBinarySearch(list,50));
        assertTrue(myBST.myBinarySearch(list,49));
    }
    @Test
    public void singleInput(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        assertTrue(myBST.myBinarySearch(list,0));
        assertFalse(myBST.myBinarySearch(list,-2));
    }
    @Test
    public void emptySearch(){
        List<Integer> list = new ArrayList<>();
        assertFalse(myBST.myBinarySearch(list,1));
    }

}
