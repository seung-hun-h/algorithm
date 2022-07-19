public class Remove_Duplicate_From_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int max = -101;
        for (int i=0;i<nums.length;i++) {
            if (max < nums[i]) {
                max = nums[i];
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }

        return left;
    }
}
