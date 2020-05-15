package fastcampus.sort;

import java.util.Arrays;
import java.util.List;

public class 삽입정렬 {
    public static List<Integer> sort(Integer... numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                // 자신보다 크면 바꾸고 작으면 바로 다음으로 넘어가기 때문에,
                // 1 step 에서 바꿈 + 안바꿈 + 바꿈 같은 플로우는 발생하지 않는다
                if(numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return Arrays.asList(numbers);
    }
}
