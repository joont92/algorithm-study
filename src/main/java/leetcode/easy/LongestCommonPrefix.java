package leetcode.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"flower","flow","flight"}).equals("fl"));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"car","dog","racecar"}).equals(""));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"car", "car", "car"}).equals("car"));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"car", "car", "aaa"}).equals(""));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"car"}).equals("car"));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{}).equals(""));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"", "b"}).equals(""));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"", ""}).equals(""));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"cccccaaaaa", "ac"}).equals(""));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        var prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            var prefixChars = prefix.toCharArray();
            var strChars = strs[i].toCharArray();
            var length = Math.min(prefix.length(), strs[i].length());

            var sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if (prefixChars[j] == strChars[j]) {
                    sb.append(prefixChars[j]);
                } else {
                    break;
                }
            }

            if (sb.length() == 0) {
                return "";
            }

            prefix = sb.toString();
        }

        return prefix;
    }
}
