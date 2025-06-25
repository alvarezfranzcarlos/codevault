import java.util.HashMap;
import java.util.*;

public class EasyRemoveChar {
    public List<String> strStr(String input) {
        List<String> words = Arrays.stream(input.split("\\s"))
                .map(word -> word.replaceAll("[^a-zA-Z]", ""))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toList());

        return words;
    }

    public static void main(String[] args) {
        EasyRemoveChar easyRemoveChar = new EasyRemoveChar();

        int result = easyRemoveChar.strStr("wesadbutsad!! .");
        System.out.println("index 1:" + result);
    }
}
