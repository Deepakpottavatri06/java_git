
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class arrays1{
    public static void main(String[] args) {
        ArrayList<String> car = new ArrayList<>();
        //An ArrayList in Java is a part of the Java Collections 
        //Framework and provides a dynamic array for storing elements. 
        car.add("random1");
        car.add("random2");
        car.add(1,"random3");//at specific index
        for (String iterable_element : car) {
            System.out.println(iterable_element);
     
        }
        System.out.println();
        car.set(2,"random3"); //set element at index
        for (String iterable_element : car) {
            System.out.println(iterable_element);
     
        }
        System.out.println(car.get(1));//get element at index
        System.out.println(car.size());//get size of array
        System.out.println(car.indexOf("random2"));//get index of element
        car.remove("random3");//remove element
        
        
        //Sorting and Searching
        System.out.println(car.contains("random1"));//check if element is present
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5,6,1,2,3,4,7,8,9,10));
        // System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);

        Integer Arr [] = numbers.toArray(new Integer[0]);// arraylist to array!
        System.out.println();
        


    }
}