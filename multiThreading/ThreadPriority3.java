/*
 * Java assigns to each thread a priority that determines how that thread should be treated
 * with respect to the others. Thread priorities are integers that specify the relative priority of one thread to another.
  
  *A thread’s priority is used to decide when to switch from one running thread to the next. This is called a context switch.
 */

 class task1 implements Runnable{
    private String taskName;

    public task1(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(taskName + " is running, iteration: " + i);
            try {
                // Sleep for a short duration to simulate work and allow thread switching
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
 }

public class ThreadPriority3 {
    public static void main(String args[]) {
        Thread t1 = new Thread(new task1("Task1"));
        t1.setPriority(Thread.MIN_PRIORITY);
        Thread t2 = new Thread(new task1("Task2"));
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();

        /*
    !Why the Output Appears Random??

    ^ Task Interleaving: Although Task 2 has a higher priority, Task 1 will still run occasionally. This interleaving can appear random but is governed by the thread scheduler’s logic to ensure fairness and responsiveness.

    ^ Context Switches: Every Thread.sleep(100) call allows the thread to yield control, giving the scheduler a chance to switch to another thread. This can result in the observed interleaving.

    ^ Fair Scheduling: Modern operating systems implement fair scheduling to prevent starvation, ensuring that even low-priority threads get some CPU time.
    
    */

    /* Explanation: 

     ^ Priority Influence: 
        Higher-priority threads are more likely to run compared to lower-priority threads, 
        but they are not guaranteed to run exclusively or immediately. 
        This means that a lower-priority thread may still execute intermittently.

     ^ Multithreading and Context Switching: 
        The output can appear random because of context switching, 
        where the CPU switches from one thread to another. Even with a high priority, 
        a thread may be paused to allow other threads to execute, resulting in interleaved outputs.
     */
       


        
    }
}
