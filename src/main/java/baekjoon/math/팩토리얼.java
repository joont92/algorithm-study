package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/10872
 *
 * 0 팩토리얼이 1인 이유는 1 팩토리얼을 만족할 수 없기 때문이다
 * 1! = 1 * 0! 인데, 여기서 0! 이 0이면 1! 도 0이 되기 때문
 */
public class 팩토리얼 {
    int[] array = new int[13];

    public 팩토리얼() {
        array[0] = array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] * i;
        }
    }

    public int bottomUp(int n) {
        return array[n];
    }
}
