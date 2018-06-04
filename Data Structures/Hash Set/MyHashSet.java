import java.util.LinkedList;

/**
 * This design question was from leetcode
 * https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
 *
 * I used the (almost trivial) hashing algorithm of just taking the modulo
 * **/

class MyHashSet {
    private LinkedList<Integer>[] buckets = new LinkedList[4];
    private int num_buckets = 4;
    private int num_elements = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        initBuckets(buckets);
    }

    private void initBuckets(LinkedList<Integer>[] buck) {
        for (int i = 0; i < buck.length; i++) {
            if (buck[i] == null) {
                buck[i] = new LinkedList<>();
            }
        }
    }

    public void add(int key) {
        checkSize();
        int index = key % num_buckets;
        if (buckets[index].contains(key)) return;
        buckets[index].add(key);
        num_elements++;
    }

    public void remove(int key) {
        checkSize();
        int index = key % num_buckets;
        if (!buckets[index].contains(key)) return;
        buckets[index].removeFirstOccurrence(key);
        num_elements--;
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        int index = key % num_buckets;
        return buckets[index].contains(key);
    }

    private void checkSize() {
        if (num_elements == num_buckets) { //upsize
            num_buckets *= 2;
            // new array of buckets
            LinkedList<Integer>[] temp = new LinkedList[num_buckets];
            initBuckets(temp);
            // move all elements into new array of buckets
            for (int i = 0; i < buckets.length; i++) {
                for (Integer j : buckets[i]) {
                    int bucket_index = j % num_buckets;
                    temp[bucket_index].add(j);
                }
            }
            buckets = temp;
        } else if (num_buckets > 4 && num_elements < num_buckets / 4) { //downsize when less than 1/4 used
            num_buckets /= 2;
            LinkedList<Integer>[] temp = new LinkedList[num_buckets];
            initBuckets(temp);
            // move all elements into new array of buckets
            for (int i = 0; i < buckets.length; i++) {
                for (Integer j : buckets[i]) {
                    int bucket_index = j % num_buckets;
                    temp[bucket_index].add(j);
                }
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */