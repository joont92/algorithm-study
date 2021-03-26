package baekjoon.math.basic;

/**
 * https://www.acmicpc.net/problem/10430
 *
 * (a + b) % c == ((a % c) + (b % c)) % c
 * (a * b) % c == ((a % c) * (b % c)) % c
 *
 * 뺼셈은 결과가 음수가 나올 수 있으므로, 나머지를 한번 더 더해준다
 * (a - b) % c == ((a % c) - (b % c) + c) % c
 */
public class 나머지 {
    public int plus1(int a, int b, int c) {
        return (a + b) % c;
    }

    public int plus2(int a, int b, int c) {
        return ((a % c) + (b % c)) % c;
    }

    public int multiple1(int a, int b, int c) {
        return (a * b) % c;
    }

    public int multiple2(int a, int b, int c) {
        return ((a % c) * (b % c)) % c;
    }
}
