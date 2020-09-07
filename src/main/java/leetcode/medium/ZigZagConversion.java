package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion fn = new ZigZagConversion();
        System.out.println(fn.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(fn.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
        System.out.println(fn.convert("PA", 2).equals("PA"));
        System.out.println(fn.convert("PA", 1).equals("PA"));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<List<Character>> result = new ArrayList<>();
        IntStream.range(0, numRows).forEach(i -> result.add(new ArrayList<>()));

        char[] chars = s.toCharArray();

        int index = 0;
        int increase = 1;
        for (char ch : chars) {
            result.get(index).add(ch);
            index += increase;
            if(index == numRows - 1 || index == 0) {
                increase *= -1;
            }
        }

        return result.stream()
                .flatMap(e -> e.stream().map(String::valueOf))
                .collect(Collectors.joining());
    }
}
