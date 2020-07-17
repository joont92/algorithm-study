package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/1676
 *
 * - 10을 곱할 때 마다 뒤에 0이 하나씩 붙는다
 * - 즉 전체 연산에서 10을 몇번 곱했느냐를 체크해보면 된다
 * - 10은 2 * 5 이니, 2의 배수와 5의 배수를 모두 구한 뒤 개수가 작은 쪽의 개수만큼 0이 붙는다고 생각하면 된다
 * - 2의 배수는 결국 짝수를 뜻해서 무조건 5보다 많으므로 결국 5의 개수만 구하면 된다
 */
public class 팩토리얼_0의_개수 {
    public int count(int n) {
        int count = 0;
        // 25 팩토리얼 이상이 아닌 경우 25 를 곱하지 않는다
        for (int i = 5; i <= n; i *= 5) {
            // 5의 제곱 수로 나눠진 값만 더해주면 된다
            count += n / i;
        }

        return count;
    }
}
