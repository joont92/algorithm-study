package baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/2309
 *
 * 9명중 7명을 구하기보단, 9명중 2명을 빼는 방법을 사용한다
 * 2명을 구해야하므로 2중 루프가 필요하다
 */
public class 일곱_난쟁이 {
    public List<Integer> bottomUp(int... heights) {
        List<Integer> result = new ArrayList<>();

        int sum = Arrays.stream(heights).sum();

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if(sum - heights[i] - heights[j] == 100) {
                    for (int k = 0; k < heights.length; k++) {
                        if(k != i && k != j) {
                            result.add(heights[k]);
                        }
                    }
                    return result.stream().sorted().collect(Collectors.toList());
                }
            }
        }

        throw new IllegalArgumentException("there is no change to find correct");
    }
}
