package fastcampus.sort;

import java.util.Arrays;
import java.util.List;

public class 삽입정렬 {
    public static List<Integer> sort(Integer... numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                // index 1번부터 정렬해왔기 때문에
                // j - 1 이 j 보다 작으면 더 이상 정렬할 필요없이 다음으로 넘어가면 된다
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
