package Code.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListClass {
    public static void main(String[] args) {

        // * LinkedList
        // * FirstElement -> SecondElement -> ... -> nElement
        // *   Rerefence(Ponter) -> Rereference -> ... -> Reference
        // * Each element has a reference of the next element in the list

        // ! LinkedList => DoubleLinkedList
        // * Besides each element has a reference of the previous element :O

        LinkedList <String> namesLinkedList = new LinkedList <>();
        namesLinkedList.add("Mauro");
        namesLinkedList.add("Paul");
        namesLinkedList.add("George");
        namesLinkedList.add("Samuel");
        System.out.println(namesLinkedList.get(2));

        // * But, at adding elements to the List -> LinkedList is way better
        // * Due to, he's only re-organizing references
        namesLinkedList.add(1, "Jerry");
        
        ArrayList <String> namesArrayList = new ArrayList <>();
        namesArrayList.add("Mauro");
        namesArrayList.add("Paul");
        namesArrayList.add("George");
        namesArrayList.add("Samuel");
        System.out.println(namesArrayList.get(2));

        // * For an ArrayList, Java has to create a whole new Array
        // * That can hold all the elements (Starts empty and the copy them)
        namesArrayList.add(1, "Jerry");

        // ! In conclusion -> User ALWAYS ArrayList :)
        // * Note: The commands of both of them are the same
        // * Same implementation so it's that way
    }
}
