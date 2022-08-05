fun main() {
    val result = search(intArrayOf(1, 3, 5), 5)
    println("result = ${result}")
}
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = (left + right) / 2
        if (nums[mid] <= nums[right]) {
            right = mid
        } else {
            left = mid + 1;
        }
    }

    val pivot = right
    left = -1
    right = nums.size

    while (left + 1 < right) {
        val mid = (left + right) / 2
        val midPivot = (mid + pivot) % nums.size

        if (nums[midPivot] < target) {
            left = mid
        } else if (nums[midPivot] > target) {
            right = mid
        } else {
            return midPivot
        }
    }
    return -1
}