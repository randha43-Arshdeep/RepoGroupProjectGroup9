
package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {
        for (Card.Color color : Card.Color.values()) {
                for (Card.Value value : Card.Value.values()) {
                if (color == Card.Color.WILD) {
                if (value == Card.Value.COLOR || value == Card.Value.DRAW_FOUR) {
                    cards.add(new Card(color, value));
                }
                }
                else{
                   cards.add(new Card(color, value));
                }
            }
        }
    }
  public void shuffleDeck() {
        Collections.shuffle(cards);
    }
    public Card drawCard() {
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getSize() {
        return cards.size();
    }
}
