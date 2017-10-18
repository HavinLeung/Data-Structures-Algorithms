
/**
 * Created by havinleung on 2017-06-27.
 */
public class ArrayDeque<Item> {
    private Item[] list;
    private int size;
    private int first;
    private int last;

    public ArrayDeque(){
        list = (Item[]) new Object[2];
        size = 0;
        first = 0;
        last = 0;
    }

    /*
    * Methods
    * */

    /**Adds an item to the front of the Deque.**/
    public void addFirst(Item y){
        checksize();
        if(isEmpty()){
            //initialise
            list[0] = y;

        }else {
            first = moveIndexLeft(first);
            list[first] = y;
        }
        size++;
    }
    /**Adds an item to the back of the Deque.**/
    public void addLast(Item y){
        checksize();
        if(isEmpty()){
            //initialise
            list[0] = y;

        }else {
            last = moveIndexRight(last);
            list[last] = y;
        }
        size++;
    }
    /**Returns true if deque is empty, false otherwise.**/
    public boolean isEmpty(){
        return (size == 0);
    }
    /**Returns the number of items in the Deque.**/
    public int size(){
        return size;
    }
    /**Prints the items in the Deque from first to last, separated by a space.**/
    public void printDeque(){
        int index = first;
        while(index != last){ //runs loop until index = last
            System.out.print(list[index]);
            System.out.print(" ");
            index = moveIndexRight(index);
        }
        System.out.print(list[index]);
        System.out.print(" ");
    }
    /**Removes and returns the item at the front of the Deque. If no such item exists, returns null.**/
    public Item removeFirst(){
        if(isEmpty()) return null;
        Item x = list[first];
        list[first] = null;
        first = moveIndexRight(first);
        size--;
        checksize();
        return x;
    }
    /**Removes and returns the item at the back of the Deque. If no such item exists, returns null.**/
    public Item removeLast(){
        if(isEmpty()) return null;
        Item x = list[last];
        list[last] = null;
        last = moveIndexLeft(last);
        size--;
        checksize();
        return x;
    }
    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     **/
    public Item get(int index){
        if(index < 0 || index >= size) return null;
        index = first+index;
        index = index % list.length;
        return list[index];
    }

    /*
    * Helper Methods
    * */

    //Doubles the size of the array.
    private void upsize(){
        Item[] x = (Item[]) new Object[list.length*2];
        int index = first;
        int i = 0;
        while(index != last){ //copies every item except last
            x[i++] = list[index];
            index = moveIndexRight(index);
        }
        x[i] = list[index]; //copies last item
        first = 0;
        last = size - 1;
        list = x;
    }
    //Halves the size of the array.
    private void downsize(){
        Item[] x = (Item[]) new Object[list.length/2];
        int index = first;
        int i = 0;
        while(index != last){ //copies every item except last
            x[i++] = list[index];
            index = moveIndexRight(index);
        }
        x[i] = list[index]; //copies last item
        first = 0;
        last = size - 1;
        list = x;
    }
    private void checksize(){
        if(size != 0 && size < (list.length/4)){
            //only using 25% or less of the array
            downsize();
        }else if(size == list.length){
            //array is maxed out
            upsize();
        }
    }
    private int moveIndexRight(int x){
        x++;
        x = x % list.length;
        return x;
    }
    private int moveIndexLeft(int x){
        x--;
        x = x % list.length;
        if(x<0) x += list.length; //since it's not the modulus but the remainder...
        return x;
    }
}
