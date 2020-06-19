package fastcampus.recursive;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _1_2_3_더하기Test {
    @Test
    public void 자연수를_1_2_3_의_합으로_나타낼_수_있는_경우의_수를_구한다() {
        assertThat(_1_2_3_더하기.count(1)).isEqualTo(1);
        assertThat(_1_2_3_더하기.count(2)).isEqualTo(2);
        assertThat(_1_2_3_더하기.count(3)).isEqualTo(4);
        assertThat(_1_2_3_더하기.count(4)).isEqualTo(7);
        assertThat(_1_2_3_더하기.count(5)).isEqualTo(13);
    }
}
