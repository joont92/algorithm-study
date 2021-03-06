package fastcampus.datastructure;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    public void 자식_노드가_하나인_노드를_삭제한다() {
        이진트리 binaryTree = factory();
        assertThat(binaryTree.delete(17)).isTrue();

        assertThat(binaryTree.exist(17)).isEqualTo(-1);
        assertThat(binaryTree.exist(19)).isEqualTo(2);

        binaryTree = factory();
        binaryTree.delete(19); // 사전작업
        binaryTree.delete(17); // 사전작업
        assertThat(binaryTree.delete(15)).isTrue();
        assertThat(binaryTree.exist(15)).isEqualTo(-1);
        assertThat(binaryTree.exist(12)).isEqualTo(1);

        // 리프노드가 아니어도 삭제방식은 동일하다
        binaryTree = factory();
        binaryTree.delete(12); // 사전작업
        assertThat(binaryTree.delete(15)).isTrue();
        assertThat(binaryTree.exist(15)).isEqualTo(-1);
        assertThat(binaryTree.exist(17)).isEqualTo(1);
        assertThat(binaryTree.exist(19)).isEqualTo(2);
    }

    @Test
    public void 자식이_둘일_경우_가장_작은_자식을_위로_올린다() {
        이진트리 binaryTree = factory();
        assertThat(binaryTree.delete(5)).isTrue();
        assertThat(binaryTree.exist(5)).isEqualTo(-1);
        assertThat(binaryTree.exist(6)).isEqualTo(1);
        assertThat(binaryTree.exist(8)).isEqualTo(2);
        assertThat(binaryTree.exist(9)).isEqualTo(3);

        // 가장 작은 자식에 오른쪽 자식이 있을 경우, 부모의 왼쪽 자식으로 대체한다
        assertThat(binaryTree.exist(7)).isEqualTo(3);

        binaryTree = factory();
        assertThat(binaryTree.delete(15)).isTrue();
        assertThat(binaryTree.exist(15)).isEqualTo(-1);
        assertThat(binaryTree.exist(17)).isEqualTo(1);
        assertThat(binaryTree.exist(12)).isEqualTo(2);
        assertThat(binaryTree.exist(19)).isEqualTo(2);
    }

    @Test
    public void name() {
        이진트리 binaryTree = new 이진트리(2500);
        Set<Integer> set = new HashSet<>();
        while(set.size() < 1000) {
            set.add((int) (Math.random() * 5000) + 1);
        }

        // 이진트리는 항상 right 가 많이 들어가네..
        for (Integer integer : set) {
            binaryTree.insert(integer);
        }

        for (Integer integer : set) {
            assertThat(binaryTree.exist(integer)).isGreaterThan(-1);
        }

        for (Integer integer : set) {
            System.out.println(binaryTree.delete(integer));
        }
    }

    private 이진트리 factory() {
        /*
                      10
               5             15
            3      8      12    17
          2  4   6   9             19
                  7
         */
        이진트리 binaryTree = new 이진트리(10);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(4);
        binaryTree.insert(6);
        binaryTree.insert(9);
        binaryTree.insert(7);
        binaryTree.insert(12);
        binaryTree.insert(17);
        binaryTree.insert(19);

        return binaryTree;
    }
}
