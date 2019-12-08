package datastructure.이진트리;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {
    @Test
    public void 현재_값보다_작으면_왼쪽_노드에_들어간다() {
        Node node = new Node(10);
        assertThat(node.insert(8)).isTrue();

        assertThat(node.getLeft()).isNotEmpty();
    }

    @Test
    public void 현재_값보다_작으면_오른쪽_노드에_들어간다() {
        Node node = new Node(10);
        assertThat(node.insert(12)).isTrue();

        assertThat(node.getRight()).isNotEmpty();
    }

    @Test
    public void 현재_값과_같으면_어느쪽에도_들어가지_않는다() {
        Node node = new Node(10);
        assertThat(node.insert(10)).isFalse();

        assertThat(node.getLeft()).isEmpty();
        assertThat(node.getRight()).isEmpty();
    }

    @Test
    public void 노드에_값이_있는지_체크한다() {
        Node node = new Node(10);
        node.insert(9);
        node.insert(11);

        assertThat(node.select(10)).isNotEmpty();
        assertThat(node.select(9)).isNotEmpty();
        assertThat(node.select(11)).isNotEmpty();
        assertThat(node.select(12)).isEmpty();
    }

    @Test
    public void 리프_노드인지_확인한다() {
        Node node = new Node(20);
        assertThat(node.isLeaf()).isTrue();

        node.insert(10);
        assertThat(node.isLeaf()).isFalse();
    }
}
