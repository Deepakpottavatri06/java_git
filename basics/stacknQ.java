import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class stacknQ {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(); // cannot use primitive data types as it only accepts objects.
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.err.println("the size : "+s.size());
        System.err.println("the element at top of the stack :"+s.peek());

        // for (Integer integer : s) {
        //     System.out.println(integer);
        // }

        // we can also use iterator to iterate over the stack
        // Iterator <Integer> it = s.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
            // 2,3,4,5
        // }

        while(!s.empty()){
            System.err.println(s.pop());
        }
        // 5,4,3,2

        // queue
        Queue<Integer> q = new LinkedList<>();
        /*
         * java.util.LinkedList can be used to create a queue because it implements the Queue interface.
         * Java provides a dedicated Queue interface and several implementing classes specifically designed for queue operations. 
         !1) ArrayDeque
         !2)LinkedList
         !3)priority Queue
         */
        q.offer(10); // enqueue 
        q.offer(12);// q.add(12) works as well
        q.offer(114);
        q.offer(15);
        System.err.println("the Queue: ");
        for (Integer integer : q) {
            System.err.print(integer +" ");
        }

        System.err.println("\nThe popped item : "+q.poll()); // popping! - q.remove() works as well
        System.err.println("The head of the queue : " +q.peek());
        System.err.println(q.isEmpty());

        // Double ended queue (deque)
        /*
         *  if you need explicit control over both ends of the queue, you can use the Deque interface. 
         * Deque stands for "double-ended queue" and allows insertion and removal of elements at both ends (front and rear).
         * The Deque interface extends the Queue interface and
         *  provides additional methods for operations at both the front and rear of the queue.
         */

         Deque<Integer> de = new ArrayDeque<>();

         de.offerFirst(12);
         de.offerFirst(13);
         de.offer(14);
         //13,12,14
         System.err.println("The head of the queue " +de.peek());
         de.offerLast(15);
         System.err.println("The rear of the queue " +de.peekLast());






    }
}
