package leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger fn = new ReverseInteger();
        System.out.println(fn.reverse2(123) == 321);
        System.out.println(fn.reverse2(-123) == -321);
        System.out.println(fn.reverse2(120) == 21);
        System.out.println(fn.reverse2(146_384_741_3) == 0);
        System.out.println(fn.reverse2(-146_384_741_3) == 0);
    }

    public int reverse2(int x) {
        int pop;
        int ans = 0;

        while(x != 0) {
            pop = x % 10;
            x /= 10;

            if((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if((ans < Integer.MIN_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && pop < -8)) {
                return 0;
            }

            ans = ans * 10 + pop;
        }

        return ans;
    }

    public int reverse1(int x) {
        char[] chars = String.valueOf(x).toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean isNegative = chars[0] == '-';
        for (int i = chars.length - 1; i >= (isNegative ? 1 : 0); i--) {
            sb.append(chars[i]);
        }

        try {
            return Integer.parseInt(sb.toString()) * (isNegative ? -1 : 1);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
