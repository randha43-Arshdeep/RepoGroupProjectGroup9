/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author bipan
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnoGame {
    private List<Player> players;
    private Deck deck;
    private List<Card> playedCards;
    private int currentPlayerIndex;

    public UnoGame(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.playedCards = new ArrayList<>();
        this.playedCards.add(deck.drawCard());
        this.currentPlayerIndex = 0;
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private void nextTurn() {
        currentPlayerIndex =(currentPlayerIndex + 1) % players.size();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Player currentPlayer = getCurrentPlayer();
            Card topCard = playedCards.get(playedCards.size() - 1);
            System.out.println("\nTop Card: " + topCard);
            System.out.println(currentPlayer);

            if (!currentPlayer.hasPlayableCard(topCard)) {
                System.out.println(currentPlayer.getName() + "Drawing Card from Pile");
                currentPlayer.drawCard(deck);
                nextTurn();
                continue;
            }

            System.out.println("Enter Index to play card");
            int choice = scanner.nextInt();

if (choice >= 0 && choice < currentPlayer.getHand().size()) {
                Card chosenCard = currentPlayer.getHand().get(choice);
                if (currentPlayer.playCard(chosenCard, playedCards)) {
                    System.out.println(currentPlayer.getName() + " played " + chosenCard);
                       if (chosenCard.getValue() == Card.Value.SKIP) {
                        nextTurn();
                    } else if (chosenCard.getValue() == Card.Value.DRAW_TWO) {
                        nextTurn();
                        getCurrentPlayer().drawCard(deck);
                        getCurrentPlayer().drawCard(deck);
                    } else if (chosenCard.getValue() == Card.Value.COLOR || chosenCard.getValue() == Card.Value.DRAW_FOUR) {
                        System.out.println("Choose a color (RED,GREEN,BLUE,YELLOW):");
                        String newColorInput = scanner.next().toUpperCase();
                        Card.Color newColor = Card.Color.valueOf(newColorInput);
                        playedCards.add(new Card(newColor, Card.Value.COLOR));
                        if (chosenCard.getValue() == Card.Value.DRAW_FOUR) {
                            nextTurn();
                            for (int i = 0; i < 4; i++) {
                                getCurrentPlayer().drawCard(deck);
                            }
                        }
                    }

                    if (currentPlayer.getHand().isEmpty()) {
                        System.out.println(currentPlayer.getName() + " wins!");
                        return;
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }
            }
            nextTurn();
        }
    }
}
