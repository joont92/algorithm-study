package fastcampus.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 퀵정렬Test {
    @Test
    public void 정렬한다() {
        List<Integer> numbers = Arrays.asList(49, 97, 53, 5, 33, 65, 62, 51);
        assertThat(퀵정렬.sort(numbers)).isEqualTo(Arrays.asList(5, 33, 49, 51, 53, 62, 65, 97));
    }
}
