package fastcampus.sort;

import java.util.Arrays;
import java.util.List;

public class 버블정렬 {
    public static List<Integer> sort(Integer... numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        return Arrays.asList(numbers);
    }
}
