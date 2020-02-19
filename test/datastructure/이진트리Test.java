package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 이진트리Test {
    @Test
    public void 값을_추가한다() {
        이진트리 binaryTree = new 이진트리(10);
        assertThat(binaryTree.insert(8)).isTrue();
        assertThat(binaryTree.insert(11)).isTrue();
        assertThat(binaryTree.insert(6)).isTrue();
        assertThat(binaryTree.insert(6)).isFalse();
    }
}
