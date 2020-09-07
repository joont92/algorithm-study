package codility.binarysearch;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 *
 * 배열의 가장 작은 숫자부터 배열의 전체 합을 기준으로 잡고, 중간값부터 이진탐색으로 minLargeSum 찾는다
 * 배열의 첫번쨰부터 bucket 에 넣다가 중간값이 넘으면 다음 bucket 으로 넘어가도록 한다
 * bucket 의 개수와 K 를 비교해 low, high 값을 조정한다
 *
 * 공백 bucket 도 가능한데, 이 부분에 대해 완벽히 처리가 되지 않았는데 테스트가 통과되었다;;
 */
public class MinMaxDivision {
    public static void main(String[] args) {
//        int[] A = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
//        int[] A = {4, 1, 2, 7};
//        int[] A = {5, 3};
        int[] A = {3, 2, 1};
        MinMaxDivision fn = new MinMaxDivision();
        System.out.println(fn.solution(3, 3, A));
    }

    public int solution(int K, int M, int[] A) {
        int low = A[0];
        int high = 0;
        int mid;

        for (int value : A) {
            high += value;
            low = Math.min(low, value);
        }

        if(K == 1) {
            return high;
        }

        int answer = high;
        while(low <= high) {
            mid = (low + high) / 2;

            int count = 1;
            int temp = 0;
            int maxTemp = 0;
            for (int i = 0; i < A.length; i++) {
                if(temp + A[i] > mid) {
                    count++;
                    maxTemp = Math.max(maxTemp, temp);
                    temp = 0;
                }
                temp += A[i];
            }
            maxTemp = Math.max(maxTemp, temp);

            if(count <= K) {
                answer = Math.min(answer, maxTemp);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}
