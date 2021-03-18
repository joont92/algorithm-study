package leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * 보완필요
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(123) == 321);
        System.out.println(new ReverseInteger().reverse(-123) == -321);
        System.out.println(new ReverseInteger().reverse(120) == 21);
        System.out.println(new ReverseInteger().reverse(0) == 0);
        System.out.println(new ReverseInteger().reverse(1123456789) == 0);
    }

    public int reverse(int x) {
        var numArr = String.valueOf(x).toCharArray();
        var sb = new StringBuilder();

        var sign = 1;
        for (int i = numArr.length - 1; i >= 0; i--) {
            if (numArr[i] == '-') {
                sign *= -1;
                continue;
            }

            sb.append(numArr[i]);
        }

        try {
            return Integer.parseInt(sb.toString()) * sign;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
