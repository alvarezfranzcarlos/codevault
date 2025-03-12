import java.util.Arrays;
import java.util.List;

public class SubStrings {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] freq = new int[3]; // Array to store counts of 'a', 'b', 'c'
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            System.out.println("right: " + right + ", s.charAt(right): " + s.charAt(right));

            if (s.charAt(right) - 'a' < 3) {
                freq[s.charAt(right) - 'a']++; // Increase count for this character
                System.out.println("freq[" + (s.charAt(right) - 'a') + "]: " + freq[s.charAt(right) - 'a']);

                while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    System.out.println("freq[0]: " + freq[0]);
                    System.out.println("freq[1]: " + freq[1]);
                    System.out.println("freq[2]: " + freq[2]);
                    count += s.length() - right; // All substrings from left to end are valid
                    freq[s.charAt(left) - 'a']--; // Shrink the window
                    left++;
                }
            }

        }

        System.out.println(freq[0]);
        System.out.println(freq[1]);
        System.out.println(freq[2]);
        return count;
    }

    public static void main(String args[]) {
        String word = "abcabcer";
        int freq = 0;

        SubStrings subStrings = new SubStrings();
        freq = subStrings.numberOfSubstrings(word);
        System.out.println(freq);
    }
}
