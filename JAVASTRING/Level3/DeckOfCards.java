/* Write a program to create a deck of cards, initialize the deck, shuffle the deck, and distribute the deck of n cards to x number of players. Finally, print the cards the players have.
Hint => 
Create a deck of cards with suits "Hearts", "Diamonds", "Clubs", "Spades" and ranks from "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", and "Ace"
Calculate the number of cards in the deck and initialize the deck
int numOfCards = suits.length * ranks.length;
Write a Method to Initialize the deck of cards with suits and ranks and return the deck. The deck is an array of strings where each string represents a card in the deck represented as "rank of suit" e.g., "2 of Hearts"
Write a Method to Shuffle the deck of cards and return the shuffled deck. To shuffle the card iterate over the deck and swap each card with a random card from the remaining deck to shuffle the deck. Please find the steps below
Step1: Use for Loop Iterate over the deck and swap each card with a random card from the remaining deck
Step 2: Inside the Loop Generate a random card number between i and n using the following code 
int randomCardNumber = i + (int) (Math.random() * (n - i));
Step 3: Swap the current card with the random card
Write a Method to distribute the deck of n cards to x number of players and return the players. For this Check the n cards can be distributed to x players. If possible then Create a 2D array to store the players and their cards
Write a Method to Print the players and their cards
*/

import java.util.Scanner;

public class DeckOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define suits and ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                          "Jack", "Queen", "King", "Ace"};

        int numOfCards = suits.length * ranks.length;

        // Initialize deck
        String[] deck = initializeDeck(suits, ranks);

        // Shuffle deck
        deck = shuffleDeck(deck);

        // Input: number of players and number of cards to deal
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();

        System.out.print("Enter number of cards to distribute to each player: ");
        int cardsPerPlayer = scanner.nextInt();

        // Check if distribution is possible
        if (numPlayers * cardsPerPlayer > numOfCards) {
            System.out.println("Cannot distribute " + cardsPerPlayer + " cards to " + numPlayers + " players. Not enough cards.");
            return;
        }

        // Distribute cards
        String[][] playersCards = distributeCards(deck, numPlayers, cardsPerPlayer);

        // Print players and their cards
        printPlayersCards(playersCards);
    }

    // Initialize deck: combine ranks and suits into "rank of suit"
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int totalCards = suits.length * ranks.length;
        String[] deck = new String[totalCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }

    // Shuffle deck using Fisher-Yates algorithm
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            // Swap deck[i] and deck[randomCardNumber]
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Distribute n cards among x players
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        String[][] players = new String[numPlayers][cardsPerPlayer];

        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[i * cardsPerPlayer + j];
            }
        }

        return players;
    }

    // Print the distributed cards of each player
    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s cards:");
            for (String card : players[i]) {
                System.out.println(card);
            }
        }
    }
}
