
/**
 * Created by havinleung on 2017-06-27.
 */
public class myArrayListDeque<Item> {
    private Item[] list;
    private int size;

    public myArrayListDeque(){
        list = (Item[]) new Object[2];
        size = 0;
    }

    /*
    * Methods
    * */

    /**Adds an item to the front of the Deque.**/
    public void addFirst(Item y){
        checksize();
        Item[] x = (Item[]) new Object[list.length];
        System.arraycopy(list,0,x,1,size);
        list = x;
        list[0] = y;
        size++;
    }
    /**Adds an item to the back of the Deque.**/
    public void addLast(Item x){
        checksize();
        list[size] = x;
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
        for(int i = 0; i < (size-1); i++){
            System.out.print(list[i]);
            System.out.print(" ");
        }
    }
    /**Removes and returns the item at the front of the Deque. If no such item exists, returns null.**/
    public Item removeFirst(){
        if(size == 0) return null;
        Item x = list[0];
        //make a new list, copy all items from 1 -> size-1 to new list.
        Item[] newlist = (Item[]) new Object[list.length];
        System.arraycopy(list,1,newlist,0,size-1);
        //set the newly created list as our main list.
        list = newlist;
        size--;
        return x;
    }
    /**Removes and returns the item at the back of the Deque. If no such item exists, returns null.**/
    public Item removeLast(){
        if(size == 0) return null;
        Item x = list[lastItem()];
        list[lastItem()] = null;
        size--;
        return x;
    }
    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     **/
    public Item get(int index){
        if(index < 0 || index > lastItem()) return null;
        return list[index];
    }

    /*
    * Helper Methods
    * */

    //Doubles the size of the array.
    private void upsize(){
        Item[] x = (Item[]) new Object[list.length*2];
        System.arraycopy(list,0,x,0,size);
        list = x;
    }
    //Halves the size of the array.
    private void downsize(){
        Item[] x = (Item[]) new Object[list.length/2];
        System.arraycopy(list,0,x,0,size);
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
    private int lastItem(){
        return size-1;
    }

}
