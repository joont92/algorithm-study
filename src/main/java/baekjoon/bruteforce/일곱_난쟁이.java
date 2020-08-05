package baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/2309
 *
 * 9명 중 2명을 뽑아 키를 더한 뒤, 전체 난쟁이의 키에서 뺐을 떄 100이면 출력한다
 * 재귀를 사용하지 않고 2가지 경우의 수를 출력하므로, 2중 루프가 필요하다
 */
public class 일곱_난쟁이 {
    public List<Integer> bottomUp(int... heights) {
        List<Integer> result = new ArrayList<>();

        int sum = Arrays.stream(heights).sum();

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length && i != j; j++) {
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

        throw new IllegalArgumentException("there is no chance to find correct");
    }
}
