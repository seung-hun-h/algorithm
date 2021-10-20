import java.util.Arrays;

public class LEET455 {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        for (int i : s) {
            int index = upperBound(g, i);

            if (index > result) {
                result++;
            } 
        }
        return result;
    }
    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
