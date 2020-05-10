package fastcampus.datastructure;

import fastcampus.datastructure.힙;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 힙Test {
    @Test
    public void 순서_비교없이_왼쪽부터_값을_저장한다() {
        힙 heap = new 힙(15);
        heap.add(10);
        heap.add(8);
        heap.add(5);
        heap.add(4);

        List<Integer> list = heap.list();
        assertThat(list.get(1)).isEqualTo(15);
        assertThat(list.get(2)).isEqualTo(10);
        assertThat(list.get(3)).isEqualTo(8);
        assertThat(list.get(4)).isEqualTo(5);
        assertThat(list.get(5)).isEqualTo(4);
    }

    @Test
    public void 부모보다_큰_값이_들어오면_swap_한다() {
        힙 heap = new 힙(10);
        heap.add(8);
        heap.add(11);

        List<Integer> list = heap.list();
        assertThat(list.get(1)).isEqualTo(11);
        assertThat(list.get(2)).isEqualTo(8);
        assertThat(list.get(3)).isEqualTo(10);
    }

    @Test
    public void swap_은_루트_노드까지_반복한다() {
        힙 heap = new 힙(15);
        heap.add(10);
        heap.add(8);
        heap.add(5);
        heap.add(4);

        heap.add(20);

        List<Integer> list = heap.list();
        assertThat(list.get(1)).isEqualTo(20);
        assertThat(list.get(3)).isEqualTo(15);
        assertThat(list.get(6)).isEqualTo(8);
    }
}
