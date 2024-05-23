import java.lang.Thread;
import java.lang.Runnable;
class myrun implements Runnable{
    @Override
    public void run(){
        System.err.println("thread is running...");
    }
}

public class ThreadCreation2 {
    public static void main(String[] args) {

        /*
         * creating thread with thread class:(already done in fundamental1.java)
         */
        randomThread r = new randomThread();
        r.start();

        /*
         * creating Thread with Runnable interface:
         */
        Thread t = new Thread(new myrun());
        t.start();

        /*
         * some methods in Thread classes:
         * Method 	Description 	Return Value
            run( ) 	Defines actual task of the thread. 	- void
            start( ) 	It moves thre thread from Ready state to Running state by calling run( ) method. 	-void
            setName(String) 	Assigns a name to the thread. 	-void
            getName( ) 	Returns the name of the thread. 	-String
            setPriority(int) 	Assigns priority to the thread. 	-void
            getPriority( ) 	Returns the priority of the thread. 	-int
         */


        
   }
    


    
}
