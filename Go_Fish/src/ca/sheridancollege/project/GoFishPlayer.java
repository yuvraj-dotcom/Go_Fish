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
public class GoFishPlayer extends Player {
    private List<GoFishCard> hand;

    public GoFishPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(GoFishCard card) {
        hand.add(card);
    }

    public GoFishCard askForCard(String rank) {
        for (GoFishCard card : hand) {
            if (card.getRank().equals(rank)) {
                return card;
            }
        }
        return null;
    }

    public void removeCard(GoFishCard card) {
        hand.remove(card);
    }

    public List<GoFishCard> getHand() {
        return hand;
    }

    @Override
    public void play() {}

    @Override
    public String toString() {
        return getName() + "'s hand: " + hand;
    }
}
