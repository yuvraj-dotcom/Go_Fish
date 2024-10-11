/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package go_fish; 

/**
 *
 * @author rav0073
 */
public class Card {
    private String rank;
    private String suit;
    
    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    public String getRank(){
        return rank;
    }
    
    public String getSuit(){
        return suit;
    }
    
    @Override
    public String toString(){
        return rank + " of " + suit;
    }
}
