/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rav0073
 */
public class GoFishGroupOfCards extends GroupOfCards {

    public GoFishGroupOfCards() {
        super(52);
        initializeDeck();
    }

    private void initializeDeck() {
        if (getCards() == null) {
            ArrayList<Card> cards = new ArrayList<>();
            try {
                java.lang.reflect.Field cardsField = GroupOfCards.class.getDeclaredField("cards");
                cardsField.setAccessible(true);
                cardsField.set(this, cards);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Failed to initialize cards list", e);
            }
        }

        List<Card> cards = getCards(); 
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String rank : ranks) {
            for (String suit : suits) {
                cards.add(new GoFishCard(rank, suit));
            }
        }
    }

    public GoFishCard drawCard() {
        List<Card> cards = getCards();
        if (!cards.isEmpty()) {
            return (GoFishCard) cards.remove(0);
        }
        return null;
    }
}