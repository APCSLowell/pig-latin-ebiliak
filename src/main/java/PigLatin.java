import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {

    public void tester() {
        String[] lines = new String[8];
        try {
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("there are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(pigLatin(lines[i]));
        }
    }

    public int findFirstVowel(String sWord) {
        // Precondition: sWord is a valid String of length greater than 0.
        // Postcondition: Returns the position of the first vowel in sWord. If there are no vowels, returns -1
        for (int i = 0; i < sWord.length(); i++) {
            char c = sWord.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                return i; // Return the index of the first vowel
            }
        }
        return -1; // No vowels found
    }

    public String pigLatin(String sWord) {
        // Precondition: sWord is a valid String of length greater than 0
        // Postcondition: Returns the Pig Latin equivalent of sWord

        int firstVowelPos = findFirstVowel(sWord);

        // Rule 1: Words with no vowels
        if (firstVowelPos == -1) {
            return sWord + "ay";
        }

        // Rule 2: Words that start with a vowel
        if (firstVowelPos == 0) {
            return sWord + "way";
        }

        // Rule 3: Words that start with "qu"
        if (sWord.startsWith("qu")) {
            return sWord.substring(2) + "quay";
        }

        // Rule 4: Words that start with consonants
        return sWord.substring(firstVowelPos) + sWord.substring(0, firstVowelPos) + "ay";
    }

    public static void main(String[] args) {
        PigLatin pl = new PigLatin();
        pl.tester();
    }
}
