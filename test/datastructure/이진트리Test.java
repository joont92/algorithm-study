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

    @Test
    public void 값을_검색한다() {
        이진트리 binaryTree = new 이진트리(10);
        binaryTree.insert(5);
        binaryTree.insert(15);

        assertThat(binaryTree.select(5)).isEqualTo(1);
        assertThat(binaryTree.select(15)).isEqualTo(1);

        binaryTree.insert(3);
        binaryTree.insert(2);
        assertThat(binaryTree.select(2)).isEqualTo(3);

        binaryTree.insert(4);
        assertThat(binaryTree.select(4)).isEqualTo(3);

        binaryTree.insert(16);
        assertThat(binaryTree.select(16)).isEqualTo(2);
    }
}
