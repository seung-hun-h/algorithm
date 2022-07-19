fun removeDuplicates(nums: IntArray): Int {
    var left = 0
    var max = -101
    nums.forEachIndexed { index, num ->
        if (num > max) {
            max = num
            val temp = nums[left]
            nums[left] = num
            nums[index] = temp
            left++
        }
    }

    return left
}