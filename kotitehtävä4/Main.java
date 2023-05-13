import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;

public class Main {
   
    public static void main (String [] args){
        try {
            WordList words = new WordList("words.txt");
            Hangman game = new Hangman(words, 5);

            List<Character> alreadyGuessed = game.guesses();

            char guess;
            char check1 = '\u00E5';
            char check2 = '\u00E4';
            char check3 = '\u00F6';
            
            Boolean win = false;

        

            while (game.guessesLeft() > 0 ) {
                
                System.out.println("The hidden word...");
                printHidden(game);
                System.out.println("\n");
                
                System.out.print("Guesses left: ");
                System.out.println(game.guessesLeft());
                System.out.print("Guessed letters: ");
                System.out.println(alreadyGuessed);

                System.out.println("Guess the letter: ");
                
                while (true) {
                    Scanner input = new Scanner(System.in, "Cp850");
                    guess = input.next().charAt(0);
                    input = null;
                    if (Character.isLetter(guess) == true || Character.compare(Character.toLowerCase(guess), check1) == 0 || Character.compare(Character.toLowerCase(guess), check2) == 0 || Character.compare(Character.toLowerCase(guess), check3) == 0) {
                        
                        break;
                    }
                    
                    System.out.println("That was not a letter.");
                    System.out.println("Enter a letter: ");

                }
                
                
                if (game.guess(guess) == true) {
                    if (game.theEnd() == true) {
                        System.out.println("Congratulations! You won!!!");
                        System.out.print("The hidden word was: ");
                        System.out.println(game.word());
                        win = true;  
                        break;
                        
                    }
                }
                
            }

            if (win != true) {
                System.out.println("Sorry, you lost!");
                System.out.print("The hidden word was: ");
                System.out.println(game.word());
            }
        }
        catch (IllegalArgumentException i) {
            System.out.println("File not found.");
        }
        catch (NoSuchElementException nsee) {

        }
        catch (NullPointerException npe) {
            
        }
    }    
        
    

    public static void printHidden (Hangman play) {
        try {
            String hiddenWord = play.word();
            List<Character> guessed = play.guesses();
            
            for (int i=0; i<hiddenWord.length(); i++) {

                if (guessed.contains(hiddenWord.charAt(i))) {
                    System.out.print(hiddenWord.charAt(i));
                }
                
                else {
                    System.out.print('*');
                }
                
            }
        }
        catch (NullPointerException npe) {

        }
    }

}