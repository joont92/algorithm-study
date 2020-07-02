package fastcampus.dp;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class 병합정렬Test {
    @Test
    public void _8개의_숫자를_정렬한다() {
        List<Integer> numbers = Arrays.asList(49, 97, 53, 5, 33, 65, 62, 51);
        assertThat(병합정렬.sort(numbers)).isEqualTo(Arrays.asList(5, 33, 49, 51, 53, 62, 65, 97));
    }

    @Test
    public void 랜덤_100개의_숫자를_정렬한다() {
        List<Integer> numbers = new Random().ints(1, 5000)
                .limit(1000)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> copy = new ArrayList<>(numbers);
        Collections.sort(copy);
        assertThat(병합정렬.sort(numbers)).isEqualTo(copy);
    }
}
