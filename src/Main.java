//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        /*
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i]);
            System.out.println(words[i].length());
        }
        System.out.println(s.length());
        */

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;


        for (int i = 0; i <= s.length() - totalLength; i++){
            String substring = s.substring(i, i + totalLength);
            List<String> wordList = new ArrayList<>(List.of(words));
            boolean isValid = true;

            for (int j = 0; j < substring.length(); j += wordLength){
                String word = substring.substring(j, j + wordLength);
                if (wordList.contains(word)){
                    wordList.remove(word);
                } else {
                    isValid = false;
                    break;
                }
            }

            if (isValid){
                System.out.println("Valid substring found at index: " + i);
            }


        }
    }
}