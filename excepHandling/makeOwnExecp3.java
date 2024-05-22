/*
 * In Java, custom exceptions are typically created by extending the Exception class or one of its subclasses.
 */


class illegalZeroOperation extends Exception{
    illegalZeroOperation(){
        super("You can't divide a number by zero");
        //constructor accepts a message(string) to be displayed when the exception is thrown.
    }
}

public class makeOwnExecp3 {
    private static int divide(int a, int b) throws illegalZeroOperation{
        if(b==0){
            throw new illegalZeroOperation();
        }
        return a/b;
    }
    public static void main(String[] args) {
        try
        {
            int a = divide(10,0);
        }
        catch(illegalZeroOperation e){
            System.err.println(e.getMessage());
        }

        // * The uncaught Exceptions: The uncaught exceptions are the exceptions that are not caught by the compiler but automatically caught and handled by the Java built-in exception handler.
        String s = null;
        System.err.println(s.length());
        /*
         the above code is an example of uncaught Exceptions.
         !When an uncaught exception occurs, the JVM calls a special private method known dispatchUncaughtException( ), on the Thread class in which the exception occurs and terminates the thread.
         */



    }
}
