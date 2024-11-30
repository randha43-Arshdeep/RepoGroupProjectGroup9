/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author bipan
 */import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name Player 1: ");
        String P1 = scanner.nextLine();
        System.out.print("Enter name Player 2: ");
        String P2 = scanner.nextLine();
        System.out.print("Enter name Player 3: ");
        String P3 = scanner.nextLine();
        players.add(new Player(P1));
        players.add(new Player(P2));
        players.add(new Player(P3));
        Deck deck = new Deck();
        for (Player player : players) {
            for (int i = 0; i <4; i++) {
                player.drawCard(deck);
            }
        }
        UnoGame game = new UnoGame(players);
        game.playGame();
    }
}



