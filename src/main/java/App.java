import models.Game;

import java.io.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        Console console = null;

        boolean appRunning = true;
        Game newGame = new Game();
        while (appRunning) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to Hangman! Choose from the following options:");
            System.out.println("Players: 1 or 2");
            try {
                console = System.console();
                String gameMode = bufferedReader.readLine();
                if (gameMode.equals("1")) {
                    newGame.setAnswer(newGame.generateWord());
                } else if(gameMode.equals("2")) {
                    System.out.println("Player one enter a word:");
                    String userAnswer = bufferedReader.readLine();
//                    if (console != null) {
//                        char[] inputAnswer = console.readPassword("Enter word: ");
//                        String userAnswer = String.valueOf(inputAnswer);
//                    }
                    newGame.setAnswer(userAnswer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            boolean gameRunning = true;

            while (gameRunning) {
            System.out.println(newGame.revealAnswer());
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");
            System.out.println("----------------------");

            System.out.println("1.Restart 2.Guess 3.Reveal 4.Exit");
            try {
                String userAction = bufferedReader.readLine();
                if (userAction.equals("Restart") || userAction.equals("1")) {
                    newGame = new Game();
                    newGame.setAnswer(newGame.generateWord());
                } else if (userAction.equals("Guess") || userAction.equals("2")) {
                    System.out.println("What's your guess?");
                    String userGuess = bufferedReader.readLine();
                    if (userGuess.matches("[a-z]")) {
                        newGame.setGuesses(userGuess);
                    } else {
                        System.out.println("Sorry, that isn't a valid guess.");
                    }
                    if (newGame.getWin()) {
                        System.out.println("You got it! Great job!");
                    } else {
                        System.out.println("Not There yet! here are your previous guesses:");
                        System.out.println(newGame.getGuesses());
                    }
                } else if (userAction.equals("Reveal") || userAction.equals("3")) {
                    System.out.println("You were almost there! The answer was:");
                    System.out.println(newGame.getAnswer());
                } else if (userAction.equals("Exit") || userAction.equals("4")) {
                    System.out.println("Alright. See ya next time!");
                    gameRunning = false;
                } else {
                    System.out.println("Sorry, not a valid option.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    }

}
