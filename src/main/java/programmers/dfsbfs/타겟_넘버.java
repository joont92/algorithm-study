package programmers.dfsbfs;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 1. 재귀함수에 다음 index 와 지금까지 계산한 숫자를 넘겨준다
 * 2. 해당 index 에 해당하는 숫자를 더한 값과 뺀 값을 각각 재귀함수에 넘겨준다
 * 3. 배열의 끝까지 왔을 떄, sum 값이 target 과 같으면 1, 아니면 0을 반환한다
 * 4. 반환된 값들이 더해져서 최종 count 가 된다
 */
public class 타겟_넘버 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};

        타겟_넘버 fn = new 타겟_넘버();
        System.out.println(fn.solution(numbers, 3));
    }

    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }

    private int dfs(int idx, int sum, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(idx + 1, sum + numbers[idx], numbers, target) +
                dfs(idx + 1, sum - numbers[idx], numbers, target);
    }
}
