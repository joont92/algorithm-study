package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 1. 한 글자씩 배열에 넣는다
 * 2. 배열에 이미 있는 값이라면, 해당 값의 인덱스부터 0번까지 전부 배열에서 삭제한다
 *   - 중복되는 숫자 다음 숫자부터 다시 시작하게 된다
 * 3. 배열에 저장할 때 마다 배열의 사이즈를 저장하고, 그 중에 최대값을 반환한다
 *
 * 반복문을 사용해 모든 subarray를 다 돌아볼수도 있다
 * for(int i = 0; i < arr.length; i++) {
 *     for(int j = i + 1; j < arr.length; j++) {
 *         // arr[i] ~ arr[j] 까지에 대해 로직 수행
 *     }
 * }
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters fn = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(fn.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(fn.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(fn.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(fn.lengthOfLongestSubstring("bbbcccddd") == 2);
        System.out.println(fn.lengthOfLongestSubstring("b") == 1);
        System.out.println(fn.lengthOfLongestSubstring("abcad") == 4);
        System.out.println(fn.lengthOfLongestSubstring("") == 0);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        if(chars.length == 0) {
            return 0;
        }

        int max = 1;
        List<Character> buffer = new LinkedList<>();
        buffer.add(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if(buffer.contains(chars[i])) {
                int idx = buffer.indexOf(chars[i]);
                for (int j = idx; j >= 0; j--) {
                    buffer.remove(j);
                }
            }
            buffer.add(chars[i]);
            max = Math.max(max, buffer.size());
        }

        return max;
    }
}
