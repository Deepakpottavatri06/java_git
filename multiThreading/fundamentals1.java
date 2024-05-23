/*
 * multitasking refers to the ability of a computer to handle more than one process at a time.

  thread-based multitasking and process-based multitasking :
  *Thread-Based Multitasking:
    ^Definition:
        Thread-based multitasking involves multiple threads within the same process executing concurrently.
    ^Memory Sharing:
        Threads share the same memory space of the parent process, including code, data, and resources.
    ^Communication:
        Communication between threads is faster and easier since they share the same memory space.
    ^Resource Utilization:
        Threads are lightweight and consume fewer resources than processes. They have lower overhead for creation and context switching.
    *Process-Based Multitasking
    ^Definition:
        Process-based multitasking involves multiple processes running concurrently, each with its own memory space.
    ^Memory Sharing:
        Processes do not share memory space. Each process operates independently with its own memory.
    ^Communication:
        Communication between processes is slower and more complex, often requiring inter-process communication (IPC) mechanisms like pipes, message queues, or shared memory.
    ^Resource Utilization:
        Processes are heavier and consume more resources than threads. They have higher overhead for creation and context switching.
 */
/*
 * Multitasking can be acheived  through multithreading.
 * A thread is a subpart of a process that can run individually.
 * Multithreading is a feature of Java that allows the concurrent execution of two or more threads (smallest unit of a process). 
 */


/*
     * How to Create a Thread in Java
    There are two main ways to create a thread in Java:
        1)By extending the Thread class.(Extending java.lang.Thread class)
        2)By implementing the Runnable interface.
     */
class randomThread extends Thread{
    public void run(){
        System.err.println("Thread is running :"+ Thread.currentThread().getName());
    }
}
public class fundamentals1 {
    public static void main(String[] args) {
        randomThread t1 = new randomThread();
        randomThread t2 = new randomThread();

        t1.start();
        t2.start();
    // !threads can also by created by using Runnable interface!
    /*
     * Thread LifeCycle:(similar to OS)
    New: A thread that has been created but not yet started.
    Runnable: A thread that is ready to run and waiting for CPU time.
    Running : When a thread executes its code.
    Blocked: A thread that is blocked waiting for a monitor lock.
    Waiting: A thread that is waiting indefinitely for another thread to perform a particular action.
    Timed Waiting: A thread that is waiting for another thread to perform an action for up to a specified waiting time.
    Terminated: A thread that has exited.
     */

    }    
}
