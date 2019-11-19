package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 이진트리Test {
    @Test
    public void 자신보다_큰_값을_넣으면_오른쪽으로만_트리가_확장된다() {
        이진트리 binaryTree = new 이진트리();
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(30);

        이진트리.Node head = binaryTree.getHead();
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

        이진트리.Node head = binaryTree.getHead();
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

        assertThat(binaryTree.search(10)).isTrue();
        assertThat(binaryTree.search(12)).isTrue();
        assertThat(binaryTree.search(8)).isFalse();
    }

    @Test
    public void 현재_값보다_작으면_왼쪽_노드에_들어간다() {
        이진트리.Node node = new 이진트리.Node(10);
        assertThat(node.insert(8)).isTrue();

        assertThat(node.getLeft()).isNotEmpty();
    }

    @Test
    public void 현재_값보다_작으면_오른쪽_노드에_들어간다() {
        이진트리.Node node = new 이진트리.Node(10);
        assertThat(node.insert(12)).isTrue();

        assertThat(node.getRight()).isNotEmpty();
    }

    @Test
    public void 현재_값과_같으면_어느쪽에도_들어가지_않는다() {
        이진트리.Node node = new 이진트리.Node(10);
        assertThat(node.insert(10)).isFalse();

        assertThat(node.getLeft()).isEmpty();
        assertThat(node.getRight()).isEmpty();
    }

    @Test
    public void 노드의_값이_있는지_체크한다() {
        이진트리.Node node = new 이진트리.Node(10);
        node.insert(9);
        node.insert(11);

        assertThat(node.select(10)).isTrue();
        assertThat(node.select(9)).isTrue();
        assertThat(node.select(11)).isTrue();
        assertThat(node.select(12)).isFalse();
    }
}
