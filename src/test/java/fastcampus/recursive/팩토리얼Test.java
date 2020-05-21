package fastcampus.recursive;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 팩토리얼Test {
    @Test
    public void 팩토리얼_결과를_구한다() {
        assertThat(팩토리얼.calculate(4)).isEqualTo(4 * 3 * 2 * 1);
        assertThat(팩토리얼.calculate(10)).isEqualTo(10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1);
    }
}
