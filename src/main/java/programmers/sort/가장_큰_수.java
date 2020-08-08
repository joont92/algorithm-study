package programmers.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 *
 * - 문자열로 만들어서 내림차순 정렬
 * - 두 문자열을 합쳐서 정렬하는 규칙을 넣는것이 핵심
 *   - 3, 30 의 경우 303 보다 330이 큼(실제로 문자 비교시 30이 더 크다고 나와서 303이 됨)
 */
public class 가장_큰_수 {
    public static void main(String[] args) {
        int[] array = {3, 30, 34, 5, 9};

        가장_큰_수 fn = new 가장_큰_수();
        System.out.println(fn.solution(array));
    }

    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(IntegerCharacter::new)
                .sorted()
                .map(i -> i.number)
                .collect(Collectors.joining());
    }

    class IntegerCharacter implements Comparable<IntegerCharacter> {
        String number;

        public IntegerCharacter(int number) {
            this.number = String.valueOf(number);
        }

        @Override
        public int compareTo(IntegerCharacter o) {
            return (o.number + number).compareTo(number + o.number);
        }
    }
}
