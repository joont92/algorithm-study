package codility.prefixsums;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 *
 * N까지 K로 나누어 떨어지는 개수 = N / K
 * 즉 B/K - A/K 해주면 된다
 *
 * 여기서 A가 K로 나누어 떨어질 경우, A를 포함시켜야 하기 떄문에 +1을 해준다
 * B의 경우 이미 B를 포함하였으므로, 나누어 떨어지는 경우를 생각할 필요 없다
 */
public class CountDiv {
    public static void main(String[] args) {
        CountDiv fn = new CountDiv();
        System.out.println(fn.solution(7, 12, 2));
    }

    public int solution(int A, int B, int K) {
        int count = B / K - A / K;
        return A % K == 0 ? count + 1 : count;
    }
}
