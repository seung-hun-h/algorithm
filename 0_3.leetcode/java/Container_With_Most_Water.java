public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;

        while (left < right) {
            answer = Math.max(answer, Math.min(height[right], height[left]) * (right - left));

            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }
}
