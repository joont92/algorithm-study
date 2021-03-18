package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum
 *
 * 1. brute force
 * 2. hash map 사용
 *  - `target - nums[i]` 가 map 에 있는지 체크해보면 된다
 *  - 자기 앞에서 저장된 map만 검사해도 되는 이유는? => 결국 뒤에서 체크되기 때문에, 앞에서 미리 뒤의 인자를 뒤져보지 않아도 된다
 *  - 동일한 숫자가 나올 경우 뒤의 앞의 값을 다덮어써도 되는데, 이미 검사가 끝난 값들이기 때문에 덮어써도 상관없다
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(new TwoSum().twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1}));
        System.out.println(Arrays.equals(new TwoSum().twoSum(new int[]{3,2,4}, 6), new int[]{1,2}));
        System.out.println(Arrays.equals(new TwoSum().twoSum(new int[]{3,3}, 6), new int[]{0,1}));
    }

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};
            }

            map.put(map.get(i), i);
        }

        throw new IllegalArgumentException();
    }
}
