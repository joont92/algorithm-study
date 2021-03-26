package baekjoon.math.practice;

/**
 * https://www.acmicpc.net/problem/1373
 *
 * 전달하는 2진수의 범위가 너무 크기 때문에, 자료형에 데이터를 저장할 수 없다
 * 2진수 3글자 == 8진수 1글자 공식을 이용해야 한다
 *
 * 3글자씩 잘리지 않을때에 대한 처리가 필요하다
 * e.g. 01 111 101 111
 */
public class _2진수_8진수 {
    public String toOctal(String binary) {
        char[] arr = binary.toCharArray();

        StringBuilder result = new StringBuilder();

        int mod = arr.length % 3;
        // if(mod == 1), if(mod == 2) 로 처리해도 되긴 함
        if(mod != 0) {
            int n = 0;
            for (int i = 0; i < mod; i++) {
                n += (arr[i] - '0') * Math.pow(2, mod - i - 1);
            }
            result.append(n);
        }

        for (int i = mod; i < arr.length; i += 3) {
            result.append((arr[i] - '0') * 4 + (arr[i + 1] - '0') * 2 + (arr[i + 2] - '0'));
        }

        return result.toString();
    }
}
