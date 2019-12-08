package datastructure.이진트리;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 이진트리Test {
    @Test
    public void 자신보다_큰_값을_넣으면_오른쪽으로만_트리가_확장된다() {
        이진트리 binaryTree = new 이진트리();
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(30);

        Node head = binaryTree.getHead();
        assertThat(head.getLeft()).isEmpty();
        assertThat(head.getRight()).isNotEmpty();

        head = head.getRight().get();
        assertThat(head.getLeft()).isEmpty();
        assertThat(head.getRight()).isNotEmpty();
    }

    @Test
    public void 자신보다_작은_값을_넣으면_왼쪽으로만_트리가_확장된다() {
        이진트리 binaryTree = new 이진트리();
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(1);

        Node head = binaryTree.getHead();
        assertThat(head.getLeft()).isNotEmpty();
        assertThat(head.getRight()).isEmpty();

        head = head.getLeft().get();
        assertThat(head.getLeft()).isNotEmpty();
        assertThat(head.getRight()).isEmpty();
    }

    @Test
    public void 값이_들어가_있는지_확인한다() {
        이진트리 binaryTree = new 이진트리();
        binaryTree.insert(10);
        binaryTree.insert(12);
        binaryTree.insert(5);
        binaryTree.insert(4);

        assertThat(binaryTree.search(10)).isNotEmpty();
        assertThat(binaryTree.search(4)).isNotEmpty();
        assertThat(binaryTree.search(8)).isEmpty();
    }

    @Test
    public void 리프노드를_삭제한다() {
        이진트리 binaryTree = new 이진트리();
        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(12);
        binaryTree.insert(13);

        binaryTree.remove(13);
        assertThat(binaryTree.search(13)).isEmpty();
    }
}
