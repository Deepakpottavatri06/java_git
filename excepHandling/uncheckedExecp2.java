/*
 * Unchecked exceptions are exceptions that are not checked at compile-time. 
 * They are a subset of the RuntimeException class, which itself is a subclass of Exception.
    ^ NullPointerException
        Thrown when an application attempts to use null where an object is required.
    ^ ArrayIndexOutOfBoundsException
        Thrown to indicate that an array has been accessed with an illegal index.
    ^ ArithmeticException
        Thrown when an exceptional arithmetic condition has occurred, such as division by zero.
    ^ IllegalArgumentException
        Thrown to indicate that a method has been passed an illegal or inappropriate argument.
    ^ ClassCastException
        Thrown to indicate that the code has attempted to cast an object to a subclass of which it is not an instance.

    *Characteristics of Unchecked Exceptions:

    ^ Runtime Nature: They occur at runtime and are typically due to programming errors.
    ^ No Mandatory Handling: There is no requirement for the programmer to catch or declare these exceptions.
 */

class person{
    private int age;
    public void setage(int age){
        if(age<0){
            throw new IllegalArgumentException("Age can't be negative!");
        }
        else{
            this.age = age;
        }
    }
    public int getAge() {
        return age;
    }
}
public class uncheckedExecp2 {
    public static void main(String[] args) {
        // ^ Arithmetic Exception
        try{
            int i = 10/0;
        }
        catch(ArithmeticException e){
            System.err.println("dividing with zero isn't allowed!" + e.getMessage());
        }
        // ^ NullPointerException
        try {
            String s = null;
            System.err.println(s.length()); 
            //s is null and length() method is trying to perform operation on null rather than object
            
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        // ^ ArrayIndexOutOfBoundsException
        try{
            int[] arr = {1,2,3,4,4};
            System.err.println(arr[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }

        // ^ IllegalArgumentException
        try{
            person p = new person();
            p.setage(-2);
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        // ^ classCastException
        Object i = Integer.valueOf(10);
        try{
            String s = (String) i; 
        }
        catch(ClassCastException e){
            System.err.println(e.getMessage());
        }   

    }
}
