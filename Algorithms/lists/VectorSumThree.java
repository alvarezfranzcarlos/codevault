import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class VectorSumThree {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid repeated results
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for left pointer
                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    // Skip duplicate elements for right pointer
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Increase sum by moving left pointer
                } else {
                    right--; // Decrease sum by moving right pointer
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        VectorSumThree vectorSum = new VectorSumThree();

        int[] nums = { 2, 7, 4, 1, 3, 5, 6 };
        int target = 12;

        List<List<Integer>> result = vectorSum.threeSum(nums, target);

        System.out.println("Triplets that sum to " + target + ": " + result);
    }
}
