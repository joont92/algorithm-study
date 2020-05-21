package fastcampus.recursive;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class 숫자들의합Test {
    @Test
    public void _숫자들의_합을_구한다() {
        int result = 숫자들의합.sum(1,2,3,4,5,6,7,8,9,10);
        assertThat(result).isEqualTo(55);
    }

    @Test
    public void 랜덤한_숫자들의_합을_구한다() {
        int[] arr = IntStream.generate(() -> (int)(Math.random() * 100) + 1)
                .distinct()
                .limit(10)
                .toArray();
        int result = 숫자들의합.sum(arr);
        assertThat(result).isEqualTo(Arrays.stream(arr).sum());
    }
}
