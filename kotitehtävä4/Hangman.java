import java.util.*;
import java.math.*;

public class Hangman {

    public int guessesLeft;
    String wordToGuess;
    List<Character> guessedChars = new ArrayList<>();

    public Hangman (WordList wordsAsList, int countOfGuesses) {
        try {
            WordList words = new WordList("words.txt");
            List<String> wordList = words.giveWords();
            System.out.println();
            if (wordList.size() == 0) {
                throw new NullPointerException();
            }
            if (countOfGuesses > 0 && wordList != null) {
                guessesLeft = countOfGuesses;
                Random random = new Random();
                int choose = random.nextInt(wordList.size()-1);
                wordToGuess = wordList.get(choose);
                if (wordToGuess == null) {
                    throw new NullPointerException();
                }
            }
        }
        catch (IllegalArgumentException iAE) {

        }
        catch (NullPointerException npe) {

        }
    }

    public boolean guess(Character c) {
        try {
            int count = 0;
            c = Character.toLowerCase(c);
            // check if the char is already guessed
            for (int i = 0; i < guessedChars.size(); i++) {
                if (guessedChars.get(i) ==  c) {
                    count = count + 1;
                }   
            }
            // if not guessed yet add to the list
            if (count == 0) {
                guessedChars.add(c);
            }
            
            // if char in the word
            if (wordToGuess.toLowerCase().contains(Character.toString(c)) == true) { 
                return true;
            }

            // decrese the guesses
            guessesLeft = guessesLeft - 1;
            
            return false;
        }
        catch (NullPointerException npe) {

        }
        return false;
    }

    // return guessed chars
    public List<Character> guesses() {
        try {
            return guessedChars;
        }
        catch (NullPointerException npe) {

        }
        return List.of();

    }

    // return how many guesses are left
    public int guessesLeft() {
        return guessesLeft;

    }

    // return word to guess
    public String word() {
        try {
            if (wordToGuess == null) {
                throw new NullPointerException();
            }
            return wordToGuess;
        }
        catch (NullPointerException npe) {
          
        }
        return wordToGuess;
    }

    public boolean theEnd() {
        try {
            int count = 0;

            if (wordToGuess == null) {
                throw new NullPointerException();
            }

            for (int i = 0; i < guessedChars.size(); i++) {
                Character c = guessedChars.get(i);
                if (wordToGuess.contains(Character.toString(c))) {
                    count = count + (int) wordToGuess.chars().filter(ch -> ch == c).count();
                }
            }

            if (count == wordToGuess.length()) {
                System.out.println(guessedChars);
                return true;
            }

            return false;
        }
        catch (NullPointerException npe) {
            
        }
        return false;
    }
}