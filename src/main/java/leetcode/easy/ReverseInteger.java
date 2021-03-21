package leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * 10 나머지 연산을 하면 가장 뒷 글자가 나오고,
 * 이 값을 result 에 더하는데, 더할때 마다 기존 값에 * 10을 한다
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(123) == 321);
        System.out.println(new ReverseInteger().reverse(-123) == -321);
        System.out.println(new ReverseInteger().reverse(120) == 21);
        System.out.println(new ReverseInteger().reverse(0) == 0);
        System.out.println(new ReverseInteger().reverse(1123456789) == 0);
        System.out.println(new ReverseInteger().reverse(-1123456789) == 0);
    }

    public int reverse(int x) {
        var result = 0;

        while (x != 0) {
            var pop = x % 10;
            x /= 10;

            var temp = result * 10L + pop;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            result = (int) temp;
        }

        return result;
    }

    public int reverse2(int x) {
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
