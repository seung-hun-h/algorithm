fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = mutableListOf<List<Int>>()

    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        result.addAll(find(nums, i))
    }

    return result
}

fun find(nums: IntArray, idx: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val target = -nums[idx]
    var left = idx + 1
    var right = nums.size - 1

    while (left < right) {
        val current = nums[left] + nums[right]
        if (current == target) {
            result.add(listOf(-target, nums[left], nums[right]))
            left++
            right--
            while (left < right && nums[left] == nums[left - 1]) left++
            while (left < right && nums[right] == nums[right + 1]) right--
        } else if (current > target) {
            right--
        } else {
            left++
        }
    }

    return result
}