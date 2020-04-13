package datastructure;

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
            if(value > this.list.get(parent_idx)) {
                Integer temp = this.list.get(parent_idx);
                this.list.set(parent_idx, this.list.get(inserted_idx));
                this.list.set(inserted_idx, temp);
            }

            inserted_idx = parent_idx;
            parent_idx = inserted_idx / 2;
        }
    }

    public List<Integer> list() {
        return this.list;
    }
}
