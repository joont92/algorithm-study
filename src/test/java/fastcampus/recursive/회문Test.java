package fastcampus.recursive;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 회문Test {
    @Test
    public void 뒤집어_읽어도_똑같다() {
        String str1 = "level";
        assertThat(회문.validate(str1)).isTrue();

        String str2 = "levae";
        assertThat(회문.validate(str2)).isFalse();
    }

    @Test
    public void 글자수가_짝수든_홀수든_관계없다() {
        String str1 = "abba";
        assertThat(회문.validate(str1)).isTrue();

        String str2 = "aabbdbbaa";
        assertThat(회문.validate(str2)).isTrue();
    }

    @Test
    public void 두_글자_이하여도_체크_가능하다() {
        String str1 = "ll";
        assertThat(회문.validate(str1)).isTrue();

        String str2 = "la";
        assertThat(회문.validate(str2)).isFalse();

        String str3 = "a";
        assertThat(회문.validate(str3)).isTrue();
    }

    @Test
    public void 재귀용법Test() {
        assertThat(회문.validateWithRecursive("level")).isTrue();
        assertThat(회문.validateWithRecursive("levea")).isFalse();
        assertThat(회문.validateWithRecursive("aabbaa")).isTrue();
        assertThat(회문.validateWithRecursive("aa")).isTrue();
        assertThat(회문.validateWithRecursive("ab")).isFalse();
        assertThat(회문.validateWithRecursive("a")).isTrue();
    }
}
