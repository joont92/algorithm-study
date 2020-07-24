package baekjoon.dp;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/14002
 *
 * 역추적 과정이 필요함
 * lis 에 값에 저장될 때 마다 어떤 lis 를 참조했는지 배열에 기록하고, 마지막에 이를 역추적해서 출력하면 된다
 */
public class 가장_긴_증가하는_부분_수열4 {
    public void getLIS(int... progression) {
        int[] lis = new int[progression.length];
        int[] prevLisIdx = new int[progression.length];

        for (int i = 0; i < progression.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if(progression[j] < progression[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    prevLisIdx[i] = j;
                }
            }
        }

        int maxLength = 0;
        int idx = 0;
        for (int i = 0; i < lis.length; i++) {
            if(maxLength < lis[i]) {
                maxLength = lis[i];
                idx = i;
            }
        }

        List<Integer> list = new LinkedList<>();
        while (idx > 0) {
            list.add(0, progression[idx]);
            idx = prevLisIdx[idx];
        }
        list.add(0, progression[idx]);

        System.out.println(maxLength);
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
