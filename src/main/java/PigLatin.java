import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner; 

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
   
        for (int i = 0; i < sWord.length(); i++) {
            char c = sWord.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                return i; 
            }
        }
        return -1; // No vowels found
    }

    public String pigLatin(String sWord) {
  

        int firstVowelPos = findFirstVowel(sWord);


        if (firstVowelPos == -1) {
            return sWord + "ay";
        }


        if (firstVowelPos == 0) {
            return sWord + "way";
        }

 
        if (sWord.startsWith("qu")) {
            return sWord.substring(2) + "quay";
        }

  
        return sWord.substring(firstVowelPos) + sWord.substring(0, firstVowelPos) + "ay";
    }

    public static void main(String[] args) {
        PigLatin pl = new PigLatin();
        pl.tester();
    }
}
