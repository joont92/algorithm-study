package fastcampus.recursive;

import java.util.Arrays;

public class 숫자들의합 {

    public static int sum(int... numbers) {
        if(numbers.length == 1) {
            return numbers[0];
        }
        return numbers[0] + sum(Arrays.stream(numbers, 1, numbers.length).toArray());
    }
}
