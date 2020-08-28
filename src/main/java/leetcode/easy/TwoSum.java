package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/solution/
 *
 * 1. brute force
 *   - i, j + 1 을 전부 돌면서 합이 target 이 되면 반환한다
 *
 * 2. hash map 사용
 *   - `target - nums[i]` 가 map 에 있는지 체크해보면 된다
 *   - 전부 다 map 에 더하고 체크해도 되지만, 배열을 저장할 때 자신의 앞에서 저장한 map 만 가지고 체크해도 충분하다
 *   - 앞에서 체크하지 않아도 뒤에서 체크 될 것이기 때문이다
 *     - nums = {2, 11, 7} target = 9 라면, 2일때 9가 없어 체크하지 못했더라도 9에서 체크할 수 있기 때문이다
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum fn = new TwoSum();

//        int[] nums = {2, 7, 11, 15};
//        int[] nums = {3, 2, 4};
        int[] nums = {3, 3};
        Arrays.stream(fn.twoSum2(nums, 6)).forEach(System.out::println);
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if(map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }
}
