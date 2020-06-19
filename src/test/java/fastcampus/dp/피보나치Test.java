package fastcampus.dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 피보나치Test {
    @Test
    public void 재귀함수로_구하기() {
        assertThat(피보나치.result(0)).isEqualTo(0);
        assertThat(피보나치.result(1)).isEqualTo(1);
        assertThat(피보나치.result(6)).isEqualTo(8);
        assertThat(피보나치.result(8)).isEqualTo(21);
        assertThat(피보나치.result(10)).isEqualTo(55);
    }

    @Test
    public void 반복문으로_구하기() {
        assertThat(피보나치.resultWithoutRecursive(0)).isEqualTo(0);
        assertThat(피보나치.resultWithoutRecursive(1)).isEqualTo(1);
        assertThat(피보나치.resultWithoutRecursive(6)).isEqualTo(8);
        assertThat(피보나치.resultWithoutRecursive(8)).isEqualTo(21);
        assertThat(피보나치.resultWithoutRecursive(10)).isEqualTo(55);
        assertThat(피보나치.resultWithoutRecursive(100)).isEqualTo(3736710778780434371L);
    }
}
