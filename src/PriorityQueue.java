import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author Ben Faier
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> myHeap; //array representation of the heap
    private int size = 0;

    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {
        myHeap.add(element);
        size++;
        shiftUp(size-1);
    }

    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {
        E e1 = myHeap.get(posOne);
        E e2 = myHeap.get(posTwo);
        myHeap.set(posOne, e2);
        myHeap.set(posTwo, e1);
    }

    /**
     * Returns whether or not the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {
        return myHeap.contains(element);
    }

    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {
        if (myHeap.isEmpty())
            return null;
        return myHeap.get(0);
    }

    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {
        if (myHeap.isEmpty())
            return null;
        E element = myHeap.get(0);
        if(remove(element))
            return element;
        else return null;
    }


    /**
     * Shifts up elements when an object is added
     * @param i starts at the end of the list and moves up the tree
     */
    private void shiftUp(int i){
        while (i > 0 && myHeap.get((i-1)/2).compareTo(myHeap.get(i)) > 0){
            swap((i-1)/2, i);
            i = (i-1)/2;
        }
    }

    /**
     * Shifts down elements when an object is removed
     * @param i is the last element in the list
     */
    private void shiftDown(int i){
        int min = i;
        int l = 2*i + 1;
        if (l < size && myHeap.get(l).compareTo(myHeap.get(min)) < 0){
            min = l;
        }
        int r = 2*i + 2;
        if (r < size && myHeap.get(r).compareTo(myHeap.get(min)) < 0){
            min = r;
        }
        if (i != min){
            swap(i, min);
            shiftDown(min);
        }
    }
    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {
        if (contains(element)){
            swap(myHeap.indexOf(element), size-1);
            myHeap.remove(size-1);
            size--;
            shiftDown(0);
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++){
            output += myHeap.get(i) + " ";
        }
        if (size != 0)
            return output.substring(0,output.length()-1);
        return "";
    }

    /**
     * Clears myHeap
     */
    public void clear(){
        while (!myHeap.isEmpty()){
            myHeap.remove(0);
        }
        size = 0;
    }

    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> theHeap = new PriorityQueue<Integer>();
        theHeap.add(5);
        theHeap.add(10);
        theHeap.add(61);
        theHeap.add(15);
        System.out.println(theHeap);
        theHeap.add(17);
        theHeap.add(2);
        System.out.println(theHeap);
        theHeap.add(4);
        System.out.println("After adding: " + theHeap);
        System.out.println("Should be: 2 10 4 15 17 61 5");
        System.out.println("Poll (2): " + theHeap.poll());
        System.out.println("Poll (4): " + theHeap.poll());
        System.out.println(theHeap);
        System.out.println("Peek (5): " + theHeap.peek());
        System.out.println("After Poll & Peek: " + theHeap);
        System.out.println("Should be: 5 10 61 15 17");
        System.out.println("Contains 5 (true): " + theHeap.contains(5));
        System.out.println("Contains 2 (false): " + theHeap.contains(2));
        System.out.println("Contains 61 (true): " + theHeap.contains(61));
        System.out.println("Remove 15 (true): " + theHeap.remove(15));
        System.out.println("Remove 5 (true): " + theHeap.remove(5));
        System.out.println("Remove 21 (false): " + theHeap.remove(21));
        System.out.println("After removing: " + theHeap);
        System.out.println("Should be: 10 17 61");
        theHeap.clear();
        System.out.println("After Clearing The Heap: " + theHeap);
        System.out.println("Poll (null): " + theHeap.poll());
        System.out.println("Peek (null): " + theHeap.peek());
    }

}