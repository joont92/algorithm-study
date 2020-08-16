package programmers.dp;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 *
 * 최단경로 구하는 방법을 사용하면 된다(https://bhsmath.tistory.com/154)
 * 가다가 중간에 우물을 만나면 0으로 세팅해주면 된다
 * 우물이 중간에만 있는것이 아니니, 테두리 부분에서도 우물 검사를 해줘야한다(1로 다 채우면 안됨)
 * 1 1 0 1
 * 1 2 2 3
 * 0 2 4 7
 */
public class 등굣길 {
    public static void main(String[] args) {
        int[][] puddles = {{1, 3}, {3, 1}};
        등굣길 fn = new 등굣길();
        System.out.println(fn.solution(4, 3, puddles));
    }

    int mod = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] check = new boolean[n][m];
        for (int[] puddle : puddles) {
            check[puddle[1] - 1][puddle[0] - 1] = true;
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(check[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                if(j > 0) {
                    dp[i][j] += dp[i][j - 1] % mod;
                }
                if(i > 0) {
                    dp[i][j] += dp[i - 1][j] % mod;
                }
            }
        }

        return dp[n - 1][m - 1] % mod;
    }
}
