package com.leetcode.java.util.practice;

/**
 * Created by bod on 9/18/14.
 */
import java.util.*;

public class IteratorDemo {

    public static void main(String args[]) {
        // Create an array list
        ArrayList al = new ArrayList();
        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        // Use iterator to display contents of al
        System.out.print("Original contents of al: ");
        Iterator itr = al.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Modify objects being iterated
        ListIterator litr = al.listIterator();
        while(litr.hasNext()) {
            Object element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
        itr = al.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Now, display the list backwards
        System.out.print("Modified list backwards: ");
        while(litr.hasPrevious()) {
            Object element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();

        Iterator iterator = al.iterator();
        System.out.print("Use new Iterator: ");
        while (iterator.hasNext()) {
            //iterator.remove(); lead to error
            Object element = iterator.next();
            System.out.print(element + " ");
            iterator.remove();
        }
        System.out.println();

        iterator = al.iterator();
        System.out.print("Use new Iterator again : ");
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.print(element + " ");
            iterator.remove();
        }
        System.out.println();
    }
}
