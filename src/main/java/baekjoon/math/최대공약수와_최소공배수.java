package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/2609
 *
 * - 최대공약수 : 두 수의 약수 중 최대값
 *   - 유클리드 호제법 : a % b 의 값이 0 이면 a 가 최대공약수이다
 *
 * - 최소공배수 : 두 수의 배수 중 최소값
 *   - 최대공약수 * 서로소
 *   - gcm * (a / gcm) * (b / gcm)
 */
public class 최대공약수와_최소공배수 {
    public int gcd(int a, int b) {
        int n = Math.min(a, b);

        int result = 1;
        for (int i = 2; i <= n; i++) {
            if(a % i == 0 && b % i == 0) {
                result = i;
            }
        }

        return result;
    }

    public int gcdEuclidean1(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcdEuclidean1(b, a % b);
    }

    public int gcdEuclidean2(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public int lcm(int a, int b) {
        int gcd = gcdEuclidean2(a, b);
        return gcd * (a / gcd) * (b / gcd);
    }
}
