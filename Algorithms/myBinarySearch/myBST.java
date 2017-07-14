import java.util.List;

/**
 * Created by havinleung on 2017-07-14.
 */
public class myBST {
    /**
     * myBinarySearch checks if some value is in a SORTED list.
     * If the value is not in the list, returns false
     * If the value is in the list, returns the true
     * */
    public static boolean myBinarySearch(List<Integer> list, int value){
        if(list.isEmpty()) return false;
        return mySearch(list, value, 0, list.size()-1);
    }
    /**
     * Helper recursive function
     * */
    private static boolean mySearch(List<Integer> list, int value, int start, int end){
        if(start > end) return false;
        int mid = (start+end)/2; //truncates decimal place
        int midValue = list.get(mid);
        //Base cases:
        if(midValue == value) return true;

        //recursive call:
        if(midValue > value) return mySearch(list, value, start, mid-1);
        else return mySearch(list, value, mid+1, end);
    }
}
