package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 *
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
