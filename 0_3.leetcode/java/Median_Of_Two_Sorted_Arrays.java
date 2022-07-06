public class Median_Of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int left = 0;
        int right = 0;
        int i=0;

        if (merged.length == 0) {
            return 0.0;
        }

        for (;i<merged.length;i++) {
            int next = Integer.MAX_VALUE;
            if (left < nums1.length) {
                next = nums1[left++];
            }

            if (right < nums2.length) {
                if (nums2[right] < next) {
                    next = nums2[right];
                    if (left > 0 && nums2[right] < nums1[left - 1]) {
                        left--;
                    }
                    right++;
                }
            }
            merged[i] = next;
        }


        if (merged.length % 2 == 1) {
            return (double) merged[merged.length / 2];
        }

        return (merged[(merged.length / 2) - 1] + merged[merged.length / 2]) / 2.0;
    }
}
