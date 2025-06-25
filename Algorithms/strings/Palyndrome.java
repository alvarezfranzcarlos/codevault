public class Palyndrome {
    public boolean Ispalyndrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        Palyndrome palyndrome = new Palyndrome();
        int[] intArr = { 6, 1, 5, 3, 1, 4, 2, 8, 5, 6 };

        boolean result = palyndrome.Ispalyndrome("abcdedcba");
        System.out.println("is palyndrome: " + result);
    }
}
