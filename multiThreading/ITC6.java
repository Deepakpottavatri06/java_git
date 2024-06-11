/*
 * ITC(Inter-thread communication) involves exchange of info between the multiple threads in same process.
 * mechanisms provided by java:  
 1) wait(), notify(), and notifyAll() Methods
 * wait(): Causes the current thread to wait until another thread invokes notify() or notifyAll() on the same object.
 * notify(): Wakes up a single thread that is waiting on this object's monitor.
 * notifyAll(): Wakes up all threads that are waiting on this object's monitor.
 2)volatile Keyword
 *The volatile keyword in Java is used to indicate that a variable's value will be modified by different threads.
 3)java.util.concurrent Package
 *package provides higher-level concurrency utilities such as Locks, Condition, Semaphore, CyclicBarrier, and CountDownLatch.
 */

 //Producer-consumer problem;
class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) { // Wait until the data has been consumed
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        notify(); // Notify consumer thread
    }

    public synchronized int consume() {
        while (!available) { // Wait until data is produced
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        notify(); // Notify producer threads
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
            System.out.println("Produced: " + i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = resource.consume();
            System.out.println("Consumed: " + value);
        }
    }
}

public class ITC6 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();

        try{
            producerThread.join();
            consumerThread.join();
        }
        catch(InterruptedException e){
            System.err.println(e.getMessage());
        }
    }
}
