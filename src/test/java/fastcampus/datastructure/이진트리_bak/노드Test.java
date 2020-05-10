package fastcampus.datastructure.이진트리_bak;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 노드Test {
    @Test
    public void 현재_값보다_작으면_왼쪽_노드에_들어간다() {
        노드 node = new 노드(10);
        assertThat(node.insert(8)).isTrue();
        assertThat(node.getLeft()).isNotEmpty();
    }

    @Test
    public void 현재_값보다_작으면_오른쪽_노드에_들어간다() {
        노드 노드 = new 노드(10);
        assertThat(노드.insert(12)).isTrue();

        assertThat(노드.getRight()).isNotEmpty();
    }

    @Test
    public void 현재_값과_같으면_어느쪽에도_들어가지_않는다() {
        노드 노드 = new 노드(10);
        assertThat(노드.insert(10)).isFalse();

        assertThat(노드.getLeft()).isEmpty();
        assertThat(노드.getRight()).isEmpty();
    }

    @Test
    public void 노드에_값이_있는지_체크한다() {
        노드 노드 = new 노드(10);
        노드.insert(9);
        노드.insert(11);

        assertThat(노드.select(10)).isNotEmpty();
        assertThat(노드.select(9)).isNotEmpty();
        assertThat(노드.select(11)).isNotEmpty();
        assertThat(노드.select(12)).isEmpty();
    }

    @Test
    public void 리프_노드인지_확인한다() {
        노드 노드 = new 노드(20);
        assertThat(노드.isLeaf()).isTrue();

        노드.insert(10);
        assertThat(노드.isLeaf()).isFalse();
    }
}
