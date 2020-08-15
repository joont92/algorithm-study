package programmers.bruteforce;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 *
 * (가로 + 세로) * 2 + 4 == brown
 * 1부터 시작했으니 가로 > 세로의 조건을 만족하지 못하므로, 단순히 가로 세로만 바꿔서 출력해주면 된다
 */
public class 카펫 {
    public static void main(String[] args) {
        카펫 fn = new 카펫();
        Arrays.stream(fn.solution(14, 4))
                .forEach(System.out::println);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int width = 1; width <= yellow; width++) {
            if(yellow % width != 0) {
                continue;
            }

            int height = yellow / width;

            if((width + height) * 2 + 4 == brown) {
                answer[0] = height + 2;
                answer[1] = width + 2;
                break;
            }
        }

        return answer;
    }
}
