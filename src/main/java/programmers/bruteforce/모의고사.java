package programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class 모의고사 {
    public static void main(String[] args) {
        int[] array = {1,3,2,4,2};

        모의고사 fn = new 모의고사();
        int[] answers = fn.solution(array);
        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    public int[] solution(int[] answers) {
        Pattern pattern1 = new Pattern(1, 2, 3, 4, 5);
        Pattern pattern2 = new Pattern(2, 1, 2, 3, 2, 4, 2, 5);
        Pattern pattern3 = new Pattern(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        int[] sheets = new int[3];

        for (int answer : answers) {
            /*
            아래가 더 간결함
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
             */
            sheets[0] += pattern1.next() == answer ? 1 : 0;
            sheets[1] += pattern2.next() == answer ? 1 : 0;
            sheets[2] += pattern3.next() == answer ? 1 : 0;
        }

        List<Integer> result = new ArrayList<>();

        int max = Math.max(sheets[0], Math.max(sheets[1], sheets[2]));
        for (int i = 0; i < sheets.length; i++) {
            if(max == sheets[i]) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    class Pattern {
        int[] pattern;
        int currentIdx;

        public Pattern(int... pattern) {
            this.pattern = pattern;
            this.currentIdx = 0;
        }

        public int next() {
            if(currentIdx == pattern.length) {
                currentIdx = 0;
            }

            return pattern[currentIdx++];
        }
    }
}
