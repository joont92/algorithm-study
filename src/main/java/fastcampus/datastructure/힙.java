package fastcampus.datastructure;

import java.util.LinkedList;
import java.util.List;

public class 힙 {
    private List<Integer> list;

    public 힙(Integer value) {
        this.list = new LinkedList<>();
        this.list.add(null); // index 를 1부터 시작하기 위해
        this.list.add(value);
    }

    public void add(Integer value) {
        this.list.add(value);

        int inserted_idx = this.list.size() - 1;
        int parent_idx = inserted_idx / 2;

        while (parent_idx >= 1) {
            Integer parent = this.list.get(parent_idx);

            if(value > parent) {
                this.list.set(parent_idx, this.list.get(inserted_idx));
                this.list.set(inserted_idx, parent);
            }

            inserted_idx = parent_idx;
            parent_idx = inserted_idx / 2;
        }
    }

    public List<Integer> list() {
        return this.list;
    }
}
