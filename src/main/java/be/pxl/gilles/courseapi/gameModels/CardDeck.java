package be.pxl.gilles.courseapi.gameModels;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    private ArrayList<Card> deck;

    public CardDeck ()
    {
        this.deck = new ArrayList();
        for (int i=7; i<13; i++)
        {
            CardValue value = CardValue.values()[i];

            for (int j=0; j<4; j++)
            {
                Card card = new Card(value, Suit.values()[j]);
                this.deck.add(card);
            }
        }

        Collections.shuffle(deck);
    }

    public Card getTopCard() {
        if (deck.size() > 1) {
            Card topCard = deck.get(0);
            deck.remove(0);

            return topCard;
        } else {
            return null;
        }
    }
}
