package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 *
 * 1. 현재 job이 끝나는 시간전에 시작된 job을 모두 저장한다
 * 2. job을 하나 수행하면서 시간을 계산한다
 * 3. 1-2를 다시 반복한다
 *
 * 현재 수행중인 job이 끝나는 시간 전에 들어온 job들 끼리만 우선순위를 적용하면 된다
 * > 복잡하게 모든 job을 저장하고 앞의 job이 바뀔 때 마다 뒤의 job 시간들을 재계산 해줄 필요없다
 */
public class 디스크_컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {500, 6}};
        디스크_컨트롤러 fn = new 디스크_컨트롤러();

        System.out.println(fn.solution(jobs));
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int jobsIdx = 0;
        int end = 0;
        int answer = 0;

        int count = 0;
        while (count < jobs.length) {
            // **현재 job이 끝나는 시간 전에 들어온 job들만** queue에 저장
            // 실행시간이 가장 짧은 순서대로 저장
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                queue.add(jobs[jobsIdx++]);
            }

            if(queue.isEmpty()) {
                // 다음 요청의 시작 시간으로
                // 여기서 바꾸고 다음 반복문에서 jobQueue에 들어간다
                end = jobs[jobsIdx][0];
            } else {
                int[] job = queue.poll();
                // 지금까지 지나온 시간 + job의 수행시간 - job의 시작시간 == job의 대기시간 + 수행시간
                answer += (end + job[1] - job[0]);
                // 현재 job이 끝나는 시간
                end += job[1];

                // 하나 수행할 떄 마다 ++
                count++;
            }
        }

        return answer / jobs.length;
    }
}
