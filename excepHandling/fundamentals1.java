
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.lang.reflect.Field;

class classNF {
    public static int myvariable = 10;
    
}

public class fundamentals1 {
    /*
        All exception and error types are subclasses of the class Throwable,
        which is the base class of the hierarchy.
     * Error: Represents serious problems that a reasonable application should not try to catch.
         Examples include OutOfMemoryError and StackOverflowError.
      !Errors represent irrecoverable conditions such as Java virtual machine (JVM) running out of memory,memory leaks, stack overflow errors, infinite recursion, etc.
        !Errors are usually beyond the control of the programmer
     * Exception: Represents conditions that a reasonable application might want to  catch.
        This is further divided into checked and unchecked exceptions.
     */
    /*
     !Built in Exception Handling:
     * Checked Exceptions: These are compile-time exceptions that must be either caught or declared in the method signature using 'throws'.
       Examples : IOException, SQLException, etc.
           IOException
        Thrown when an I/O operation fails or is interrupted.
    SQLException
        Thrown when there is an error with database access.
    FileNotFoundException
        Thrown when an attempt to open the file denoted by a specified pathname has failed.
    ClassNotFoundException
        Thrown when an application tries to load a class through its string name but no definition for the class with the specified name could be found.
     * Unchecked Exceptions: These are exceptions that do not need to be declared or caught.
      They are subclasses of RuntimeException, such as NullPointerException, ArrayIndexOutOfBoundsException, etc.
     */

    // ! Checked Exceptions :
    // IO Exception and FileNotFoundException
    public static void main(String[] args) {
        try {
            readFile("1.txt");
        } catch (FileNotFoundException d) {
            System.err.println("Mention The file path correctly!! " + d.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        // classNotfound error
        try {
            Class<?> c = Class.forName("classNF"); // it tries to load the class if exists.
            Field f = c.getField("myvariable");
            System.err.println(f.get(null));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            System.err.println("The mentioned class not found :" + e.getMessage());
        }
    }

    static void readFile(String path) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            int c;
            while ((c = br.read()) != -1) {
                System.err.print((char) c);
            }
        } finally {
            br.close();
        }
    }

}
