import java.util.*;

public class MediumLongestHappyS {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        int[][] arr = { { a, 'a' }, { b, 'b' }, { c, 'c' } };

        while (true) {
            Arrays.sort(arr, (x, y) -> Integer.compare(y[0], x[0]));

            boolean added = false;
            for (int i = 0; i < 3; i++) {
                System.out.println("i: " + i);
                if (arr[i][0] == 0)
                    continue;

                int length = result.length();
                Boolean IsMoreThanTwo = length >= 2;

                if (IsMoreThanTwo) {
                    int lastChar = result.charAt(length - 1);
                    int befLastChar = result.charAt(length - 2);
                    int currentChar = arr[i][1];
                    System.out.println("i: " + i);
                    System.out.println("last: " + lastChar);
                    System.out.println("current: " + currentChar);

                    if (currentChar == lastChar && currentChar == befLastChar) {
                        System.out.println("continue");
                        continue;
                    }
                }
                result.append((char) arr[i][1]);
                arr[i][0]--;
                added = true;
                break;

            }
            if (!added)
                break;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MediumLongestHappyS mediumLongestHappyS = new MediumLongestHappyS();
        String response = mediumLongestHappyS.longestDiverseString(1, 1, 7);
        System.out.println(response);
    }
}
