import java.util.HashMap;

public class SubStringVowel {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;
        int left = 0;
        int consonants = 0;
        HashMap<Character, Integer> vowelCount = new HashMap<>();

        // List of Vowels
        String vowels = "aeiou";

        for (int right = 0; right < n; right++) {
            char rightChar = word.charAt(right);

            System.out.println("rightChar:" + rightChar);

            if (vowels.indexOf(rightChar) != -1) {
                vowelCount.put(rightChar, 1);
                System.out.println("Es voval: " + rightChar);
                System.out.println("vowelCount.getOrDefault: " + vowelCount.getOrDefault(rightChar, 0));
            } else {
                consonants++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        String word = "ieaouqqieaouqq";
        int freq = 0;

        SubStringVowel subStrings = new SubStringVowel();
        freq = subStrings.countOfSubstrings(word, 1);
        System.out.println(freq);
    }
}