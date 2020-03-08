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

        assertThat(binaryTree.exist(5)).isEqualTo(1);
        assertThat(binaryTree.exist(15)).isEqualTo(1);

        binaryTree.insert(3);
        binaryTree.insert(2);
        assertThat(binaryTree.exist(2)).isEqualTo(3);

        binaryTree.insert(4);
        assertThat(binaryTree.exist(4)).isEqualTo(3);

        binaryTree.insert(16);
        assertThat(binaryTree.exist(16)).isEqualTo(2);
    }

    @Test
    public void 리프_노드를_삭제한다() {
        이진트리 binaryTree = factory();
        assertThat(binaryTree.delete(2)).isTrue();
        assertThat(binaryTree.delete(19)).isTrue();

        assertThat(binaryTree.exist(2)).isEqualTo(-1);
        assertThat(binaryTree.exist(19)).isEqualTo(-1);
    }

    private 이진트리 factory() {
        /*
                  10
             5         15
           3   7    12    17
          2                 19
         */
        이진트리 binaryTree = new 이진트리(10);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(2);
        binaryTree.insert(12);
        binaryTree.insert(17);
        binaryTree.insert(19);

        return binaryTree;
    }
}
