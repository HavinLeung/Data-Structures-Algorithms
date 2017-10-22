import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

/**
 * Created by havinleung on 2017-06-27.
 */
public class myMergeSortTest {
    @Test
    public void regularInput(){
        int[] Array={0,26,19,1,2,5,-12,999,2};
        myMergeSort.mergeSort(Array);
        assertEquals("[-12, 0, 1, 2, 2, 5, 19, 26, 999]", Arrays.toString(Array));
    }
    @Test
    public void reverseInput(){
        int[] Array={22,21,19,18,15,14,9,7,5};
        myMergeSort.mergeSort(Array);
        assertEquals("[5, 7, 9, 14, 15, 18, 19, 21, 22]", Arrays.toString(Array));

    }
    @Test
    public void emptyArray(){
        int[] Array={};
        myMergeSort.mergeSort(Array);
        assertEquals("[]", Arrays.toString(Array));
    }

    @Test
    public void alreadySorted(){
        int[] Array={1,2,3,4,5,6,7,8,9,10};
        myMergeSort.mergeSort(Array);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(Array));
    }
}
