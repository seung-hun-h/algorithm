fun main() {
    fun maxArea(height: IntArray): Int {
        var answer = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            answer = maxOf(answer, minOf(height[left], height[right]) * (right - left))
            if (height[right] < height[left]) {
                right--
            } else {
                left++
            }
        }

        return answer;
    }

}