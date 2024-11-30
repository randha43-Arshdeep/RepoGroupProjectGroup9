/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author bipan
**/
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void drawCard(Deck deck) {
        hand.add(deck.drawCard());
    }

    public boolean playCard(Card card, List<Card> playedCards) {
        if (hand.contains(card) && card.isPlayable(playedCards.get(playedCards.size() - 1))) {
            hand.remove(card);
            playedCards.add(card);
            return true;
        }
        return false;
    }

    public boolean hasPlayableCard(Card topCard) {
        for (Card card : hand) {
            if (card.isPlayable(topCard)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + "'s hand: " + hand;
    }
}


