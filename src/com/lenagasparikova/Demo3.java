package com.lenagasparikova;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo3 {
    private static LinkedList<String> fruits = new LinkedList<>();

    public static void main(String[] args) {

        addAlphabetically("apple", fruits);
        addAlphabetically("pear", fruits);
        addAlphabetically("raspberry", fruits);
        addAlphabetically("banana", fruits);
        addAlphabetically("kiwi", fruits);
        addAlphabetically("watermelon", fruits);
        addAlphabetically("papaya", fruits);
        addAlphabetically("banana", fruits);
        addAlphabetically("Apple", fruits);

        printList(fruits);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static boolean addAlphabetically(String newFruit, LinkedList<String> fruit) {
        ListIterator<String> stringListIterator = fruit.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newFruit);
            if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newFruit);
                return true;
            } else if (comparison < 0) {

            } else if (comparison == 0) {
                System.out.println(newFruit + " already on the list");
                return false;
            }
        }
        stringListIterator.add(newFruit);
        return true;
    }
}
