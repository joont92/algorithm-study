package baekjoon.math.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/1929
 *
 * - 에라토스테네스의 채
 *   1. 2 부터 n 까지의 숫자를 모두 나열한다
 *   2. 작은 숫자부터 배수를 지운다(n 이 100이라고 가정)
 *      1. 2는 제외하고 2의 배수 전부 삭제
 *      2. 3은 제외하고 3의 배수 전부 삭제
 *      3. 5는 제외하고 5의 배수 전부 삭제
 *      4. 7은 제외하고 7의 배수 전부 삭제
 *      > 그 다음 숫자인 11은, 11*11이 100을 넘으므로 계산할 필요가 없다
 *      > 11의 배수인 22 는 이미 2의 배수라 지워졌고, 33도 이미 3의 배수라 지워졌기 때문이다
 *      > 즉, i 보다 작은 수를 곱하는 경우의 수는 이미 앞에서 지워졌기 때문에, i*i 이상의 값만 검사해주면 된다
 */
public class 소수_구하기 {
    public List<Integer> getPrimeNumbers(int start, int end) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] check = new boolean[end + 1];
        for (int i = 2; i < check.length; i++) {
            if(!check[i]) {
                primeNumbers.add(i);

                for (int j = i * 2; j < check.length; j+=i) {
                    check[j] = true;
                }
            }
        }

        return primeNumbers.stream()
                .filter(e -> e >= start)
                .collect(Collectors.toList());
    }
}
