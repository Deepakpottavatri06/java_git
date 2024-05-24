/*
 * thread priority is a mechanism that helps the thread scheduler decide the order in which threads are executed. Each thread has a priority, which is represented by an integer value
 *     Java thread priorities are integers ranging from 1 to 10.
    The constants defined in the Thread class for these priorities are:
        Thread.MIN_PRIORITY (1)
        Thread.NORM_PRIORITY (5)
        Thread.MAX_PRIORITY (10)
 */

class Task implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority());
        }
    }
}
public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task(), "Thread-1");
        Thread t2 = new Thread(new Task(), "Thread-2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
    
}
