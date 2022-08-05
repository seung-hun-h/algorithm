public class Search_In_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int pivot = right;
        left = -1;
        right = nums.length;

        while (left + 1 < right) {
            int mid = (right + left) / 2;
            int midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) {
                left = mid;
            } else if (nums[midPivot] > target) {
                right = mid;
            } else {
                return midPivot;
            }
        }
        return -1;
    }
}
