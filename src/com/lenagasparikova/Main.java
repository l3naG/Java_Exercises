package com.lenagasparikova;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Soldier of Fortune", 4.12);
        album.addSong("The gypsy", 4.55);
        album.addSong("High ball shooter", 3.23);
        album.addSong("Lady double dealer", 5.00);
        album.addSong("Hold on", 5.16);
        album.addSong("Holy man", 2.13);
        album.addSong("Love don't mean a thing", 5.12);
        album.addSong("Stormbringer", 7.12);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.66);
        album.addSong("I put the finger on you", 4.55);
        album.addSong("Let's go", 4.51);
        album.addSong("Inject the venom", 4.22);
        album.addSong("Snowballed", 4.51);
        album.addSong("Breaking the rules", 5.66);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("High ball shooter", playList);
        albums.get(0).addToPlayList("Holly man", playList); // does not exist
        albums.get(0).addToPlayList(5, playList);
        albums.get(0).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(5, playList);
        albums.get(1).addToPlayList(24, playList); // there is no track 24

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in the playlist");
        } else {
            System.out.println("Now playing " + listIterator.next());
            printMenu();
        }

        while (quit != true) {
            System.out.println("Enter your choice: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            printMenu();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else {
                        System.out.println("You've reached the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    } else {
                        System.out.println("You've reached the start of the list");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("You have reached the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("You have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                        break;
                    }
            }
        }
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("======================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("======================");
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song \n" +
                "2 - to play previous song\n" +
                "3 - to play current song\n" +
                "4 - to list songs in the playlist\n" +
                "5 - to print available actions\n" +
                "6 - to remove current song from playlist");
    }

}
