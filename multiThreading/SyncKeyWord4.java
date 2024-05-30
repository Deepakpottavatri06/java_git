
/*
 * The synchronized keyword is used to ensure that a method or block of code is executed by only one thread at a time.
 */
/*
 * How Synchronization Works

    ^ Monitor and Locks:
    When a thread enters a synchronized method or block, 
    it acquires a monitor (lock) associated with the object or class. 
    If another thread tries to enter a synchronized method/block on the same object, 
    it is blocked until the first thread releases the monitor.
    ^ Thread Safety: 
    This mechanism ensures that only one thread at a time can execute synchronized code on the same object,
    which prevents race conditions.
 */

 /*
  * Why Synchronization is Necessary?



    ^ Race Condition:
    A race condition occurs when two or more threads can access shared data and try to change it simultaneously.
    Without synchronization, the increment method can be interrupted between reading and writing the value of count(refer example), 
    leading to incorrect results.
    
  */
class Counter {
    private int count = 0;
    private int countWithSync = 0;

    /*
     !The increment operation (count++) is not atomic. It involves three steps:
        ^Reading the current value of count
        ^Incrementing the value
        ^Writing the new value back to count
    If two threads perform this operation simultaneously without synchronization,
    they might both read the same value and write back the same incremented value, resulting in a lost update.
     */
    public void increment() {
        count++;
    }
    public synchronized void incrementWithSync(){
        countWithSync++;
    }

    public int getCount() {
        return count;
    }
    public int getCountWithSync() {
        return countWithSync;
    }
}
public class SyncKeyWord4 {
    // using synchronized keyword for methods
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                counter.incrementWithSync();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                counter.incrementWithSync();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Without synchronization, this might not print 2000
        System.out.println("The Count value with synchronized keyword :" +counter.getCount());
        System.out.println("The count value with synchronized keyword :"+counter.getCountWithSync());
    }



    
}