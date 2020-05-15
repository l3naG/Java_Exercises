package com.lenagasparikova;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {

        LinkedList<String> placesToVisit = new LinkedList<>();
        addInAlphabeticalOrder("Sydney", placesToVisit);
        addInAlphabeticalOrder("Melbourne", placesToVisit);
        addInAlphabeticalOrder("Darwin", placesToVisit);
        addInAlphabeticalOrder("Perth", placesToVisit);
        addInAlphabeticalOrder("Adelaide", placesToVisit);
        addInAlphabeticalOrder("Canberra", placesToVisit);
        addInAlphabeticalOrder("Canberra", placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Now visiting " + iterator.next());
        }
        System.out.println("=========================");
    }


    private static boolean addInAlphabeticalOrder(String newCity, LinkedList<String> places) {
        ListIterator<String> stringListIterator = places.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + " has been already added to the list");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {

            }
        }
        stringListIterator.add(newCity);
        return true;
    }


    private static void visit(LinkedList<String> places) {
        ListIterator<String> stringListIterator = places.listIterator();
        boolean quit = false;
        boolean goForward = true;
        if (places.isEmpty()) {
            System.out.println("No places to visit on your list");
        } else {
            System.out.println("Now visiting " + stringListIterator.next());
            printMenu();
        }
        while (!quit) {
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Your vacation is over, no more places to visit");
                    quit = true;
                    break;
                case 1:
                    if (!goForward) {
                        if (stringListIterator.hasPrevious()) {
                            stringListIterator.next();
                        }
                        goForward = true;
                    }
                    if (stringListIterator.hasNext()) {
                        System.out.println("Now visiting " + stringListIterator.next());
                    } else {
                        System.out.println("You've reached the end of the list");
                        quit = true;
                    }
                    break;
                case 2:
                    if (goForward) {
                        if (stringListIterator.hasPrevious()) {
                            stringListIterator.previous();
                        }
                        goForward = false;
                    }
                    if (stringListIterator.hasPrevious()) {
                        System.out.println("Now visiting " + stringListIterator.previous());
                    } else {
                        System.out.println("You've reached the start of the list");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit \n" +
                "1 - go to next place\n" +
                "2 - go to previous place\n" +
                "3 - print Menu Options");
    }
}
