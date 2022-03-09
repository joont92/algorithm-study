package leetcode

// https://leetcode.com/problems/two-sum/
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()

        for ((i, v) in nums.withIndex()) {
            val j = map[target - v]
            if (j != null) {
                return intArrayOf(j, i)
            }

            map[v] = i
        }

        throw IllegalArgumentException()
    }

    // brute force
    fun twoSum_bak(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        throw IllegalArgumentException()
    }
}

fun main() {
    val fn = TwoSum()
    println(fn.twoSum(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(0, 1)))
    println(fn.twoSum(intArrayOf(3, 2, 4), 6).contentEquals(intArrayOf(1, 2)))
    println(fn.twoSum(intArrayOf(3, 3), 6).contentEquals(intArrayOf(0, 1)))
    println(fn.twoSum(intArrayOf(3, -20, 0, 20, 1, -20), -40).contentEquals(intArrayOf(1, 5)))
    println(fn.twoSum(intArrayOf(3, 3, 3, 3, 3), 6).contentEquals(intArrayOf(0, 1)))
}
