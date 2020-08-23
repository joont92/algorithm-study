package baekjoon.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/11279
 *
 * 최대 힙 == 우선순위 큐
 * - 완전 이진 트리에서만 가능
 * - 부모 노드의 키 값이 자식 노드의 키 값보다 항상 큼
 * - 데이터를 찾을 때는 최 상단의 데이터만 찾음
 * - 데이터를 넣을 때는 왼쪽부터 순서대로 넣는다
 *   - 이진 탐색 트리의 경우 작을 경우 왼쪽, 클 경우 오른쪽에 넣는데 힙의 경우 무조건 왼쪽부터 넣는다는 점이 다른점이다
 * - 넣은 데이터의 값이 부모 데이터의 값보다 크다면 swap 한다
 *   - 부모 데이터의 값이 클 때 까지 or 루트 노드가 될 때 까지
 * - 데이터를 삭제할 때는 중간 노드의 값을 빼올 일은 없고, 부모 노드의 값만 뺴온다
 *   - 그리고 루트 노드의 값을 채우기 위해 아래의 행동을 수행한다
 *     1. 가장 마지막으로 넣은 노드를 찾아서 루트 노드로 올린다
 *     2. 자식 노드의 값들 중 더 큰 값이 있다면 swap 한다(양쪽 다 비교해야함)
 *     3. 자식 노드의 값들 중 더 큰 값이 없을때 까지 반복한다(힙의 형태를 맞춤)
 *        - 더 큰 값이 없다면 탐색을 중단한다
 *        - 중단하지 않으면 시간 초과 문제가 발생한다
 * - 데이터 조회 + 삽입을 합쳐서 O(logN) 이 걸린다
 *
 * 일반적으로 힙 구현 시 배열을 이용하는데, 이는 아래의 공식을 통해 부모,자식 관계를 쉽게 찾을 수 있기 때문이다
 * - 부모 : 현재 index / 2
 * - 왼쪽 자식 : 현재 index * 2
 * - 오른쪽 자식 : 현재 index * 2 + 1
 */
public class 최대_힙 {
    List<Integer> heap;

    public 최대_힙() {
        this.heap = new ArrayList<>();
        this.heap.add(-1); // to start index 1
    }

    public void add(int number) {
        heap.add(number);

        if(heap.size() <= 2) {
            return;
        }

        int lastIdx = heap.size() - 1;
        while (lastIdx != 1 && heap.get(lastIdx) > heap.get(lastIdx / 2)) {
            swap(lastIdx, lastIdx / 2);

            lastIdx /= 2;
        }
    }

    public int remove() {
        if(heap.size() == 1) {
            return 0;
        }

        int result = heap.remove(1);
        if(heap.size() == 1) {
            return result;
        }

        heap.add(1, heap.remove(heap.size() - 1));

        for (int i = 1; i * 2 < heap.size();) {
            int k;
            int standard = heap.get(i);
            int left = heap.get(i * 2);

            // 오른쪽이 없다면
            if(i * 2 + 1 >= heap.size()) {
                if(standard > left) {
                    break;
                }

                k = i * 2;
            } else {
                int right = heap.get(i * 2 + 1);

                if(standard > left && standard > right) {
                    break;
                }

                if(left > right) {
                    k = i * 2;
                } else {
                    k = i * 2 + 1;
                }
            }

            swap(i, k);
            i = k;
        }

        return result;
    }

    private void swap(int srcIdx, int descIdx) {
        int temp = heap.get(srcIdx);
        heap.set(srcIdx, heap.get(descIdx));
        heap.set(descIdx, temp);
    }
}
