import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.*;
import java.lang.StringBuilder;

public class Solution2 {

    public int[] getIndex(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int rest = 0;
        for (int i = 0; i < nums.length; i++) {
            rest = target - nums[i];
            if (map.containsKey(rest)) {
                int indexFounded = i;
                int SecindexFounded = map.get(rest);
                return new int[] { SecindexFounded, indexFounded };
            }
            System.out.println(nums[i]);
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 7, 19 };
        int target = 12;
        Solution2 sol = new Solution2();
        int[] result = sol.getIndex(nums, target);

        System.out.println(Arrays.toString(result));
    }
}
