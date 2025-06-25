import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class EasyVectorSumTwo {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        EasyVectorSumTwo vectorSum = new EasyVectorSumTwo();

        int[] nums = { 16, 2, 11, 15 };
        int target = 13;

        int[] result = vectorSum.twoSum(nums, target);
        System.out.println("index:" + result[0] + "," + "index:" + result[1]);
    }
}
