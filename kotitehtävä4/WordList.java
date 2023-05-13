import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class WordList {

    List<String> wordsAsList = new ArrayList<>();
    String textFileName;

    public WordList () {

    }

    public WordList (String textFileName) {
        // try to read the given file and add words to the list
        try (BufferedReader sanat = new BufferedReader ( new FileReader(textFileName))) {
            String rivi;
            while ((rivi = sanat.readLine()) != null) {
                System.out.println(rivi);
                wordsAsList.add(rivi);
            } 
        }
        /* 
        try {
            File words = new File(textFileName);
            Scanner read = new Scanner(words, StandardCharsets.UTF_8.name());

            while (read.hasNextLine()) {
                String word = read.nextLine();
                System.out.println("word=" + word);
                if (word == null) {
                    throw new NullPointerException();
                }
                //wordsAsList.add(word.toLowerCase());
                wordsAsList.add(word);
            }
            read.close(); 
        }
        */
        // exception if the file not found
        catch (IOException | NullPointerException e) {
            //System.out.println("File not found.");
        } 
    }


    public List<String> giveWords() {
        try {
            if (wordsAsList.size() == 0) {
                throw new NullPointerException();
            }
            return wordsAsList;
        }
        catch(NullPointerException npe) {

        }
        return List.of();

    }

}