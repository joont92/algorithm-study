package fastcampus.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class 버블정렬Test {
    @Test
    public void 숫자를_정렬한다() {
        List<Integer> result = 버블정렬.sort(4,3,6,11,2);
        assertThat(result).isEqualTo(Arrays.asList(2,3,4,6,11));
    }
}
