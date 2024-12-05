/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rav0073
 */
public class GoFishGame extends Game {
    private GoFishGroupOfCards deck;
    private ArrayList<GoFishPlayer> players;

    public GoFishGame(String name, int numPlayers) {
        super(name);
        deck = new GoFishGroupOfCards();
        deck.shuffle();
        players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            players.add(new GoFishPlayer("Player " + i));
        }

        for (GoFishPlayer player : players) {
            for (int j = 0; j < 5; j++) {
                player.addCardToHand(deck.drawCard());
            }
        }

        setPlayers(new ArrayList<>(players));
    }

    @Override
    public void play() {
        System.out.println("Starting Go Fish Card game...");
        for (GoFishPlayer player : players) {
            System.out.println(player);
        }

        Scanner scanner = new Scanner(System.in);
        boolean gameOngoing = true;

        while (gameOngoing) {
            for (GoFishPlayer currentPlayer : players) {
                System.out.println("\n" + currentPlayer.getName() + "'s turn:");
                System.out.println("Your hand: " + currentPlayer.getHand());
                System.out.print("Ask for a rank: ");
                String rank = scanner.nextLine();

                boolean cardFound = false;
                for (GoFishPlayer opponent : players) {
                    if (!opponent.equals(currentPlayer)) {
                        GoFishCard card = opponent.askForCard(rank);
                        if (card != null) {
                            currentPlayer.addCardToHand(card);
                            opponent.removeCard(card);
                            System.out.println(opponent.getName() + " gives " + card + " to " + currentPlayer.getName());
                            cardFound = true;
                            break;
                        }
                    }
                }

                if (!cardFound) {
                    System.out.println("Go Fish!");
                    if (!deck.getCards().isEmpty()) {
                        GoFishCard newCard = deck.drawCard();
                        currentPlayer.addCardToHand(newCard);
                        System.out.println(currentPlayer.getName() + " draws " + newCard);
                    } else {
                        System.out.println("Deck is empty!");
                    }
                }

                checkForPairs(currentPlayer);

                if (isGameOver()) {
                    declareWinner();
                    gameOngoing = false;
                    break;
                }
            }
        }

        scanner.close();
    }

    @Override
    public void declareWinner() {
        GoFishPlayer winner = null;
        int maxPairs = Integer.MIN_VALUE;

        for (GoFishPlayer player : players) {
            int pairs = 26 - player.getHand().size() / 2; // Assuming 26 pairs max in a deck
            if (pairs > maxPairs) {
                maxPairs = pairs;
                winner = player;
            }
        }

        System.out.println("Winner is " + winner.getName() + "!");
    }

    private void checkForPairs(GoFishPlayer player) {
        ArrayList<GoFishCard> hand = new ArrayList<>(player.getHand());
        ArrayList<GoFishCard> pairsToRemove = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getRank().equals(hand.get(j).getRank())) {
                    pairsToRemove.add(hand.get(i));
                    pairsToRemove.add(hand.get(j));
                    System.out.println(player.getName() + " found a pair: " + hand.get(i) + " and " + hand.get(j));
                }
            }
        }
        player.getHand().removeAll(pairsToRemove);
    }

    private boolean isGameOver() {
        for (GoFishPlayer player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return deck.getCards().isEmpty();
    }
}
