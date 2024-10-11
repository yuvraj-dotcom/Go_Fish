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
public class Game {
    private Deck deck;
    private List<Player> players;
    
    public Game(int numPlayers){
        deck = new Deck();
        deck.shuffle();
        players = new ArrayList<>();
        
        for (int i = 1; i <= numPlayers; i++){
            players.add(new Player("Player " + i));
        }  
    }
}
