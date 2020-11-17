package programmers.dp;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 *
 * 자신의 아래 왼쪽, 오른쪽 숫자 구하는법 = depth + 1, 왼쪽 = idx, 오른쪽 = idx + 1
 * > Math.max(tri[depth][idx] + tri[depth + 1][idx], tri[depth][idx] + tri[depth + 1][idx + 1])
 */
public class 정수_삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        정수_삼각형 fn = new 정수_삼각형();
        System.out.println(fn.solution(triangle));
    }

    int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length - 1][triangle.length - 1];

        return maxTriangle(0, 0, triangle);
    }
    public int maxTriangle(int depth, int idx, int[][] triangle) {
        if(dp[depth][idx] != 0) {
            return dp[depth][idx];
        }

        if(depth + 1 == triangle.length - 1) {
            dp[depth][idx] = triangle[depth][idx] + Math.max(triangle[depth + 1][idx], triangle[depth + 1][idx + 1]);

            return dp[depth][idx];
        }

        dp[depth][idx] = Math.max(
                triangle[depth][idx] + maxTriangle(depth + 1, idx, triangle),
                triangle[depth][idx] + maxTriangle(depth + 1, idx + 1, triangle));

        return dp[depth][idx];
    }
}
