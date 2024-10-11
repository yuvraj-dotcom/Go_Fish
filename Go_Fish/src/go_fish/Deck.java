/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package go_fish;

/**
 *
 * @author rav0073
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck{
    private List<Card> cards;
    
    public Deck() {
        cards = new ArrayList<>();
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack","Queen","King","Ace",};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades",};

        for(String suit : suits){
            for (String rank : ranks){
                cards.add(new Card(rank, suit));
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}

    

