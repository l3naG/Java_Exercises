package com.lenagasparikova;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo2 {

    private static LinkedList<String> names = new LinkedList<>();


    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();
        addAlphabetically("Pajgertova", names);
        addAlphabetically("Mlynarcik", names);
        addAlphabetically("Andrasiova", names);
        printList(names);

    }


    private static boolean addAlphabetically(String newName, LinkedList<String> names) {
        ListIterator<String> stringListIterator = names.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newName);
            if (comparison == 0) {
                System.out.println("Name already added to the list");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newName);
                return true;
            } else if (comparison < 0) {

            }
        }
        stringListIterator.add(newName);
        return true;
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

