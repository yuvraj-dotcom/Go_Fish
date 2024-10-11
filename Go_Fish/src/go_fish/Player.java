/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package go_fish;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rav0073
 */
class Player {
    private String name; 
    private List<Card> hand;
    
    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }
    public void addCardToHand(Card card){
        hand.add(card);
    }
    public Card askforCard(String rank) {
        for(Card card : hand) {
            if (card.getRank().equals(rank)){
                return card;
            }
        }
        return null;
    }
    public List<Card> getHAnd() {
        return hand;
    }
    public String getName() {
        return name;
    }
    public void removeCard(Card card){
        hand.remove(card);
    }
    @Override
    public String toString() {
        return name + " 's hand: "+ hand;
    }
}
    
    

