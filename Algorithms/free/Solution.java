import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution {
    public int[] removeDup(int[] array) {

        int n = array.length;
        Boolean isDuplicate;
        int uniqCount = 0;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            isDuplicate = false;
            for (int j = 0; j < uniqCount; j++) {
                if (array[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temp[uniqCount] = array[i];
                uniqCount++;
            }

        }
        return temp;

    }

    public int[] removeDupL(int[] array) {

        int[] uniqueArray = Arrays.stream(array) // Convierte el array en un Stream
                .distinct() // Elimina los duplicados
                .toArray(); // Convierte el resultado de nuevo a array

        return uniqueArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] intArr = { 6, 1, 5, 3, 1, 4, 2, 8, 5, 6 };
        int[] result = solution.removeDup(intArr);
        System.out.println("Arrays: " + Arrays.toString(result));

        int[] resultL = solution.removeDupL(intArr);
        System.out.println("Labda: " + Arrays.toString(resultL));
    }
}
