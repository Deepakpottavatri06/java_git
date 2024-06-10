/*
 * Synchronized blocks allow you to synchronize a specific section of code rather than an entire method.
 */
/*
 * Why Use Synchronized Blocks?
    Granular Control: Synchronize only the necessary part of the method, reducing contention and potentially improving performance.
    Flexibility: Allows you to synchronize on different objects, not just the current instance (this), providing more control over the locking mechanism.
 */
// Instance based synchronization
    /* 
    When you use a synchronized block, such as synchronized (this), 
    you are telling the JVM to acquire the lock on the specified object (in this case, the current instance this) before executing the block of code.
    Only the code inside the synchronized block is protected by this lock.
    Other methods and code outside this synchronized block can still be accessed by other threads concurrently.
     */

class synchronizedCounter5{
   private int counter = 0;
   // private final Object lock = new Object(); // Monitor object

   public void incrementSync5(){
      synchronized(this){
         // we can use lock object as well
         counter++;
      }
   }

   public int getCounter() {
       return counter;
   }

}

public class syncBlocks5 {
    
      public static void main(String[] args) {
         synchronizedCounter5 c = new synchronizedCounter5();
         Thread t1 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
               c.incrementSync5();
            }
         });
         Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
               c.incrementSync5();
            }
         });
         t1.start();
         t2.start();

         try {
            //The join method in Java is used to wait for a thread to finish its execution (just wait() in OS)
            //When you call t1.join(), the calling thread (in this case, the main thread) will pause and wait until thread t1 has completed its execution.
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

         System.err.println(c.getCounter());
      }

    
}
