package models;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Game {

    private String answer;
    private ArrayList<String> guesses;

    public Game() {
        this.guesses = new ArrayList<String>();
    }

    public void setAnswer(String word){
        this.answer = word;
    }

    public String generateWord(){
        ArrayList<String> randomWords = new ArrayList<String>(){{
          add("pablo");
          add("nardo");
          add("kristen");
          add("garnett");
          add("mike");
        }};
        Random randomWordGenerator = new Random();
        String randomWord = randomWords.get(randomWordGenerator.nextInt(5));
        return randomWord;
    }

    public void setGuesses(String guess) {
        if (!guesses.contains(guess)){
            this.guesses.add(guess);
        }
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }

    public List<String> revealAnswer(){
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < this.answer.length(); i++) {
            String letter = String.valueOf(this.answer.charAt(i));
            if (this.guesses.contains(letter)){
                result.add(letter);
            } else {
                result.add("_");
            }
        }
        return result;
    }

    public boolean getWin() {
        if (this.revealAnswer().contains("_")){
            return false;
        } else {
            return true;
        }
    }

}
