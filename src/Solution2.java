import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static List<String> fullJustify (String [] words, int maxWidth){
        List<String> result = new ArrayList<>();
        int start = 0;
        while (start < words.length){
            int end = chooseWords(words, start, maxWidth);
            int totalLetters = countCharacters(words, start, end);
            String line;
            if (end == words.length -1 || start == end){
                line = buildLeftJustified(words, start,end, maxWidth);
            } else {
                line = buildFullyJustified(words, start, end, totalLetters, maxWidth);
            }
            result.add(line);
            start = end + 1;
        }
        return result;
    }

    public static int countCharacters(String [] words, int start, int end){
        int total = 0;
        for (int i= start;i <= end;i++){
            total = total + words[i].length();
        }
        return total;
    }




    public static int chooseWords(String[] words, int start, int maxWidth){
        int length = 0;
        int i = start;
        while (i < words.length){
            int wordLength = words[i].length();
            if (length + wordLength + (i - start) > maxWidth){
                break;
            }
            length += wordLength;
            i++;
        }
        return i -1;
    }

    public static String buildLeftJustified(String [] words,int start, int end, int maxWidth){
        StringBuilder line = new StringBuilder();
        for (int i = start;i <= end;i++){
            line.append(words[i]);
            if (i < end){
                line.append(" ");
            }
        }
        while(line.length() < maxWidth){
            line.append(" ");
        }
        return line.toString();
    }

    public static String buildFullyJustified(String [] words, int start, int end, int totalLetters, int maxWidth){

        int gaps = end - start;
        int totalSpaces = maxWidth - totalLetters;
        int baseSpaces = totalSpaces / gaps;
        // This to  calculate and return the remainder of extraSpaces.
        int extraSpaces = totalSpaces % gaps;

        StringBuilder line = new StringBuilder();
        for (int i = start;i <= end;i++){
            line.append(words[i]);
            if (i < end){
                for(int s =0; s < baseSpaces; s++){
                    line.append(" ");
                }
                if (i - start < extraSpaces){
                    line.append(" ");
                }
            }
        }
        return line.toString();
    }
}
