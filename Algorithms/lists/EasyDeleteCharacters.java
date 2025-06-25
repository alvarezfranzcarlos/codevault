import java.util.List;

public class EasyDeleteCharacters {

    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String word = "leeetcode";

        EasyDeleteCharacters deleteCharacters = new EasyDeleteCharacters();
        String result = deleteCharacters.makeFancyString(word);

        System.out.println("Fancy epression is: " + result);
    }
}
