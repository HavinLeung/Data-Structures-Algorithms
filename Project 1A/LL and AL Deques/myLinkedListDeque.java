
/**
 * Created by havinleung on 2017-06-27.
 */
public class myLinkedListDeque <Item> {
    private class Node{
        private Item item;
        private Node next;
        private Node prev;
        private Node(Item i, Node x, Node y){
            item = i;
            next = x;
            prev = y;
        }
    }

    /** Invariants
     * 1. The first item is always at sentinal.next
     * 2. The last item is always at sentinal.prev
     *
     * */
    private Node sentinal;
    private int size;
    /*
    * Constructor methods
    * */
    public myLinkedListDeque(){
        sentinal = new Node(null, null,null);
        sentinal.next=sentinal;
        sentinal.prev=sentinal;
        size=0;
    }

    /*
    * Methods
    * */
    /**Adds an item to the front of the Deque.**/
    public void addFirst(Item x){
        //creates a new node that points at previous "first" node, and points back to sentinal.
        Node firstNode = new Node(x,sentinal.next,sentinal);
        //the previous "first" node will now point back to the new first node
        sentinal.next.prev = firstNode;
        //sentinal points to the new node
        sentinal.next = firstNode;
        //increment size by 1
        size++;
    }
    /**Adds an item to the back of the Deque.**/
    public void addLast(Item x){
        //new node w/ pointers at sentinal and the previous "last" node
        Node lastNode = new Node(x,sentinal, sentinal.prev);
        //previous last node points at new "lastNode"
        sentinal.prev.next = lastNode;
        //sentinal points back to lastnode
        sentinal.prev = lastNode;
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
        if(size==0) return;
        Node p = sentinal;
        while(p.next!=sentinal){
            p=p.next;
            System.out.print(p.item);
            System.out.print(" ");
        }
    }
    /**Removes and returns the item at the front of the Deque. If no such item exists, returns null.**/
    public Item removeFirst(){
        if(size == 0) return null;
        size--;
        //create pointer to first item
        Node p = sentinal.next;
        //make sentinal point to second item
        sentinal.next=p.next;
        //make second item point back to sentinel
        sentinal.next.prev=sentinal;
        return p.item;
    }
    /**Removes and returns the item at the back of the Deque. If no such item exists, returns null.**/
    public Item removeLast(){
        if(size == 0) return null;
        size--;
        Node p = sentinal.prev;
        //remove all references of last node, set to second last node.
        sentinal.prev=p.prev;
        sentinal.prev.next=sentinal;
        return p.item;
    }
    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     **/
    public Item get(int index){
        if(index<0 || index>=size) return null;
        if(index>((size-1)/2)){
            Node p = scrollBack(size-1-index); //start at last, count backwards
            return p.item;
        }
        else{
            Node p = scrollForward(index);
            return p.item;
        }
    }
    private Node scrollBack(int index){
        Node p = sentinal.prev;
        while(index>0){
            p=p.prev;
            index--;
        }
        return p;
    }
    private Node scrollForward(int index){
        Node p = sentinal.next;
        while(index>0){
            p=p.next;
            index--;
        }
        return p;
    }
}
