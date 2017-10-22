/**
 * Created by havinleung on 2017-07-07.
 * This is a merge sort implementation for integer arrays.
 */
public class myMergeSort {
    public static void mergeSort(int[] Array){
        int size = Array.length;
        //empty or single item array, return.
        if(size<2){
            return;
        }
        //split Array into 2 arrays
        int leftSize = size/2;
        int rightSize = size-leftSize;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        System.arraycopy(Array,0,leftArray,0,leftSize);
        System.arraycopy(Array,leftSize,rightArray,0,rightSize);
        //recursively call mergesort
        mergeSort(leftArray);
        mergeSort(rightArray);
        //merge the sorted arrays
        merge(leftArray,rightArray,Array);
    }
    /*Merge helper function*/
    private static void merge(int[] leftArray, int[] rightArray, int[] Array){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;
        //Compare smallest values of left/right arrays and insert to Array
        while(leftIndex < leftSize && rightIndex < rightSize){
            if(leftArray[leftIndex] < rightArray[rightIndex]){
                Array[arrayIndex++] = leftArray[leftIndex++];
            }
            else{
                Array[arrayIndex++] = rightArray[rightIndex++];
            }
        }
        //one of the arrays has been fully compared
        while(leftIndex < leftSize){
            Array[arrayIndex++] = leftArray[leftIndex++];
        }
        while(rightIndex < rightSize){
            Array[arrayIndex++] = rightArray[rightIndex++];
        }

    }
}
