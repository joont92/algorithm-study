package leetcode.easy;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * 기본 원리 : 문자에 해당하는 값을 찾아 result에 계속 더하면 된다
 * 뒤의 로마숫자가 앞의 로마숫자보다 값이 클 경우, 뒤 숫자에서 앞 숫자를 뺀 뒤 전체 숫자에 더해줘야 하므로,
 * 매번 자신의 뒤 숫자와 크기를 비교하고, 뒤 숫자가 크다면 뺄셈하고 더해주는 로직을 넣어주면 된다
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("III") == 3);
        System.out.println(new RomanToInteger().romanToInt("VI") == 6);
        System.out.println(new RomanToInteger().romanToInt("XVII") == 17);
        System.out.println(new RomanToInteger().romanToInt("IV") == 4);
        System.out.println(new RomanToInteger().romanToInt("IX") == 9);
        System.out.println(new RomanToInteger().romanToInt("IXIX") == 18);
        System.out.println(new RomanToInteger().romanToInt("IXIXI") == 19);
        System.out.println(new RomanToInteger().romanToInt("LVIII") == 58);
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV") == 1994);
    }

    public int romanToInt(String s) {
        var romanNumber = "IVXLCDM";
        var romanNumberValue = new int[]{1, 5, 10, 50, 100, 500, 1000};

        var chars = s.toCharArray();
        if (chars.length == 1) {
            return romanNumberValue[romanNumber.indexOf(chars[0])];
        }

        var result = 0;
        for (int i = 0; i < chars.length; i++) {
            var currentNumberSize = romanNumber.indexOf(chars[i]);

            if (i < chars.length - 1 && currentNumberSize < romanNumber.indexOf(chars[i + 1])) {
                result += romanNumberValue[romanNumber.indexOf(chars[i + 1])] - romanNumberValue[currentNumberSize];
                i++;
            } else {
                result += romanNumberValue[currentNumberSize];
            }
        }

        return result;
    }
}
