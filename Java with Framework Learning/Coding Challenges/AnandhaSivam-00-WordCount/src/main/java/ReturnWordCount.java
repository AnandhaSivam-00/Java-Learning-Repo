import java.util.Arrays;
import java.util.List;

public class ReturnWordCount {
    /**
     * @param in A String representing a sentence, with words delineated by spaces.
     * @return return the amount of words in a string.
     */
    public int count(String in){
        List<String> strArray = Arrays.asList(in.split(" "));
        return strArray.size();
    }
}
