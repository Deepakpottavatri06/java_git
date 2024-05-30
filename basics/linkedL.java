

import java.util.LinkedList;
import java.util.Scanner;

class node{
    int data;
    node next;

    node(int data){
        this.data = data;
        this.next = null;
    }
}
public class linkedL {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        node head = new node(1);
        for(int i=0;i<4;i++){
            int c = cin.nextInt();
            node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new node(c);
        }

        node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        //using LinkedList library:
        System.err.println("\nThe linkedList using java Lib : ");
        LinkedList <Integer> a = new LinkedList<>();
        a.add(1);
        a.add(3);
        a.add(23); 
        

        for (Integer integer : a) {
            System.err.print(integer + "->");
        }
    }
    
}
