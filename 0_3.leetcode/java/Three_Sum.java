import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            result.addAll(find(nums, i));
        }
        return result;
    }

    private List<List<Integer>> find(int[] nums, int idx) {
        List<List<Integer>> result = new ArrayList<>();
        int target = -nums[idx];
        int left = idx + 1;
        int right = nums.length - 1;

        while (left < right) {
            int current = nums[left] + nums[right];
            if (current == target) {
                result.add(List.of(nums[idx], nums[left], nums[right]));
                left++;
                right--;

                while(left < right && nums[left] == nums[left - 1]) left++;
                while(left < right && nums[right] == nums[right + 1]) right--;
            } else if (current > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

}
