public class LEET33 {
    public static void main(String[] args) {
        int ans = search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(ans);
    }
    public static int search(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int pivot = right;

        left = 0; right = nums.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) {
                left = mid + 1;
            } else if (nums[midPivot] > target) {
                right = mid - 1;
            } else {
                return midPivot;
            }
        }
        return -1;
    }

}
