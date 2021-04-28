package baekjoon.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/10972
 *
 * [7,2,3,6,5,4,1] == 723 으로 시작하는 마지막 순열
 * - 6541이 내림차순이기 때문이다
 *
 * 723 으로 시작하는 마지막 순열 바로 다음 순열 == 724 로 시작하는 첫 순열
 *
 * 1. 723 다음 수를 구한다
 *   - 뒤의 6541 중에서, 723 의 마지막 수인 3 보다 큰 숫자 중 가장 작은 수 == 4
 * 2. 3과 4를 바꾼다
 *   - 7246531
 * 3. 724 뒤 숫자들이 내림차순이므로, 현재는 724 로 시작하는 마지막 순열이다
 *   - 724 뒤 숫자들을 오름차순으로 바꿔주면 724로 시작하는 첫 순열이 된다
 */
public class 다음_순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] permutation = Arrays.stream(br.readLine().split(" ", count))
                .mapToInt(Integer::parseInt)
                .toArray();

        다음_순열 fn = new 다음_순열();
        System.out.println(Arrays.stream(fn.solution(permutation))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public int[] solution(int[] permutation) {
        int boundaryIdx = -1;
        for (int i = permutation.length - 1; i >= 1; i--) {
            if(permutation[i] > permutation[i - 1]) {
                boundaryIdx = i;
                break;
            }
        }

        if(boundaryIdx == -1) {
            return new int[]{-1};
        }

        int min = permutation[boundaryIdx];
        int minIdx = boundaryIdx;
        for (int i = boundaryIdx; i < permutation.length; i++) {
            if(permutation[i] > permutation[boundaryIdx - 1] && permutation[i] < min) {
                min = permutation[i];
                minIdx = i;
            }
        }

        int temp = permutation[boundaryIdx - 1];
        permutation[boundaryIdx - 1] = permutation[minIdx];
        permutation[minIdx] = temp;

        int[] answer = new int[permutation.length];
        System.arraycopy(permutation, 0, answer, 0, boundaryIdx);
        System.arraycopy(permutation, boundaryIdx, answer, boundaryIdx, permutation.length - boundaryIdx);

        return answer;
    }
}
