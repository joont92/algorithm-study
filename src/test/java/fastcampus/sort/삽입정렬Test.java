package fastcampus.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class 삽입정렬Test {
    @Test
    public void 숫자를_정렬한다() {
        List<Integer> result = 삽입정렬.sort(4,3,6,11,2);
        assertThat(result).isEqualTo(Arrays.asList(2,3,4,6,11));
    }

    @Test
    public void _100개의_랜덤한_숫자를_정렬한다() {
        List<Integer> randomNumbers = IntStream.generate(() -> new Random().nextInt())
                .distinct()
                .limit(100)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> result = 삽입정렬.sort(randomNumbers.toArray(new Integer[0]));
        assertThat(result).isEqualTo(randomNumbers.stream().sorted().collect(Collectors.toList()));
    }
}
