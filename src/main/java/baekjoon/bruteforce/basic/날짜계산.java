package baekjoon.bruteforce.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 날짜계산 {
    public static void main(String[] args) {
        System.out.println(new 날짜계산().solution(new int[] {15, 15, 15}) == 15);
        System.out.println(new 날짜계산().solution(new int[] {1, 16, 16}) == 16);
        System.out.println(new 날짜계산().solution(new int[] {1, 1, 1}) == 1);
        System.out.println(new 날짜계산().solution(new int[] {1, 2, 3}) == 5266);
        System.out.println(new 날짜계산().solution(new int[] {15, 28, 19}) == 7980);

        try {
            var fn = new 날짜계산();
            var br = new BufferedReader(new InputStreamReader(System.in));
            var result = fn.solution(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray());
            System.out.println(result);
        } catch (IOException e) {/* */}
    }

    public int solution(int[] esm) {
        var year = 1;
        var e = 1;
        var s = 1;
        var m = 1;

        while (!(e == esm[0] && s == esm[1] && m == esm[2])) {
            year++;
            e = e == 15 ? 1 : e + 1;
            s = s == 28 ? 1 : s + 1;
            m = m == 19 ? 1 : m + 1;
        }

        return year;
    }

}
