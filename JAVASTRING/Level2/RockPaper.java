/*Rock-Paper-Scissors is a game played between a minimum of two players. Each player can choose either rock, paper, or scissors. Here the game is played between a user and a computer. Based on the rules, either a player or a computer will win. Show the stats of player and computer win in a tabular format across multiple games. Also, show the winning percentage between the player and the computer.
Hint => 
The rule is: rock-scissors: rock will win (rock crushes scissors); rock-paper: paper wins (paper covers rock); scissors-paper: scissors win (scissors cuts paper)
Create a Method to find the Computer Choice using the Math.random
Create a Method to find the winner between the user and the computer
Create a Method to find the average and percentage of wins for the user and the computer and return a String 2D array
Create a Method to display the results of every game and also display the average and percentage wins 
In the main take user input for the number of games and call methods to display results
*/

import java.util.Scanner;

public class RockPaper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of games from user
        System.out.print("Enter the number of games to play: ");
        int totalGames = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] moves = {"rock", "paper", "scissors"};
        int userWins = 0;
        int computerWins = 0;

        // Store results of each game: {userMove, computerMove, winner}
        String[][] gameResults = new String[totalGames][3];

        for (int i = 0; i < totalGames; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your move (rock, paper, scissors): ");
            String userMove = scanner.nextLine().toLowerCase();

            // Validate user input
            while (!isValidMove(userMove)) {
                System.out.print("Invalid move! Please enter rock, paper, or scissors: ");
                userMove = scanner.nextLine().toLowerCase();
            }

            String computerMove = getComputerChoice();
            String winner = findWinner(userMove, computerMove);

            // Update win counters
            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }

            // Store this game result
            gameResults[i][0] = userMove;
            gameResults[i][1] = computerMove;
            gameResults[i][2] = winner;
        }

        // Calculate stats as 2D String array to display
        String[][] stats = calculateStats(userWins, computerWins, totalGames);

        // Display all results and stats
        displayResults(gameResults, stats);
    }

    // Method to check valid move
    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    // Method to generate computer choice using Math.random()
    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.33) {
            return "rock";
        } else if (rand < 0.66) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    // Determine winner: returns "User", "Computer" or "Draw"
    public static String findWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "Draw";
        }

        switch (userMove) {
            case "rock":
                return (computerMove.equals("scissors")) ? "User" : "Computer";
            case "paper":
                return (computerMove.equals("rock")) ? "User" : "Computer";
            case "scissors":
                return (computerMove.equals("paper")) ? "User" : "Computer";
            default:
                return "Error"; // shouldn't happen due to validation
        }
    }

    // Calculate average and winning percentages and return as 2D string array
    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[4][3];

        stats[0][0] = "Category";
        stats[0][1] = "User";
        stats[0][2] = "Computer";

        stats[1][0] = "Total Wins";
        stats[1][1] = String.valueOf(userWins);
        stats[1][2] = String.valueOf(computerWins);

        stats[2][0] = "Winning Percentage";
        stats[2][1] = totalGames == 0 ? "0%" : String.format("%.2f%%", (userWins * 100.0) / totalGames);
        stats[2][2] = totalGames == 0 ? "0%" : String.format("%.2f%%", (computerWins * 100.0) / totalGames);

        stats[3][0] = "Draws";
        stats[3][1] = String.valueOf(totalGames - (userWins + computerWins));
        stats[3][2] = "-";

        return stats;
    }

    // Display game results and stats in tabular format
    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame\tUser Move\tComputer Move\tWinner");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%d\t%s\t\t%s\t\t%s\n",
                    i + 1, capitalize(gameResults[i][0]), capitalize(gameResults[i][1]), gameResults[i][2]);
        }

        System.out.println("\nStatistics:");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-18s %-10s %-10s\n", stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    // Capitalize first letter to improve display
    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
