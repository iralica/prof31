package Lesson4.Card;

import java.sql.SQLOutput;

public class CardTester {
    public static void main(String[] args) {
        Card.CardStatus status = Card.CardStatus.ORDERED;
        // Card.CardStatus status = Card.CardStatus.ORDERED; ?????
        System.out.println(status.isOrdered());
        System.out.println(status.isReady());

        Card card = new Card();
        card.setStatus(Card.CardStatus.READY);
        System.out.println(card.isDeliverable());

    }
}
