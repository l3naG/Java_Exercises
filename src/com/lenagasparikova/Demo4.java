package com.lenagasparikova;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo4 {

    private static LinkedList<String> objects = new LinkedList<>();

    public static void main(String[] args) {
        addAlphabetically("Pan", objects);
        addAlphabetically("Bicycle", objects);
        addAlphabetically("projector", objects);
        addAlphabetically("lamp", objects);
        addAlphabetically("table", objects);
        addAlphabetically("dress", objects);
        printList(objects);
        addAlphabetically("pan", objects);
        printList(objects);
        
    }

    private static boolean addAlphabetically(String newObject, LinkedList<String> linkedList) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newObject);
            if (comparison == 0) {
                System.out.println(newObject + " already on the list");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newObject);
                return true;
            } else if (comparison < 0) {
            }
        }
        stringListIterator.add(newObject);
        return true;
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=====================");
    }
}
