package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TestComparators {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
        scanner.nextLine();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            System.out.println(text);
            String[] arr = text.split(" ");
            Player p = new Player(arr[0], Integer.parseInt(arr[1]));
            players.add(p);
            //scanner.nextLine();
        }
        players.sort(new Checker());
        players.stream().forEach(System.out::println);
    }
}

class Player {
    public String name;
    public int score;

    public Player() {
    }

    public Player(String s, int n) {
        this.name = s;
        this.score = n;
    }

    public String toString() {
        return this.name + " " + this.score;
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (b.score > a.score) {
            return 1;
        } else if (b.score == a.score) {
            return a.name.compareTo(b.name);
        } else {
            return -1;
        }
    }
}
