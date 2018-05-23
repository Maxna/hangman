package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void newGame_createsCorrectly_true() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("pablo");
        assertEquals(true, testGame instanceof Game);
    }

    @Test
    public void setAnswer_setsAnswerCorrectly_pablo() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("pablo");
        assertEquals("pablo", testGame.getAnswer());
    }

    @Test
    public void setGuess_addsInputLetter_a()throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("pablo");
        testGame.setGuesses("a");
        assertEquals("a", testGame.getGuesses().get(0));
    }

    @Test
    public void setGuess_addsSecondInputLetter_b() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("pablo");
        testGame.setGuesses("a");
        testGame.setGuesses("b");
        assertEquals("b", testGame.getGuesses().get(1));
    }

    @Test
    public void setGuess_doesNotAddExistingLetter_c() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("pablo");
        testGame.setGuesses("a");
        testGame.setGuesses("b");
        testGame.setGuesses("b");
        testGame.setGuesses("c");
        assertEquals("c", testGame.getGuesses().get(2));
    }

    @Test
    public void revealAnswer_replaceUnderscoresWithLetters_revealedWord() throws Exception{
        Game testGame = new Game();
        testGame.setAnswer("pablo");
        testGame.setGuesses("a");
        testGame.setGuesses("b");

        List<String> testArray = new ArrayList<String>();
        testArray.add("_");
        testArray.add("a");
        testArray.add("b");
        testArray.add("_");
        testArray.add("_");

        assertEquals(testArray, testGame.revealAnswer());
    }

    @Test
    public void getWin_detectWin_true() {
        Game testGame = new Game();
        testGame.setAnswer("pablo");
        testGame.setGuesses("a");
        testGame.setGuesses("b");
        testGame.setGuesses("l");
        testGame.setGuesses("o");
        testGame.setGuesses("p");
        assertEquals(true, testGame.getWin());
    }

    @Test
    public void setAnswer_setsAnswerRandomly_true() throws Exception {
        Game testGame = new Game();
        assertEquals(true, testGame.generateWord() instanceof String);
    }
}