package datastructure.이진트리_bak;

import java.util.Optional;

public class 이진트리 {
    private 노드 head;
    private 노드 current;

    public void insert(Integer value) {
        if(head == null) {
            head = new 노드(value);
            return;
        }

        current = head;
        while (!current.insert(value)) {
            current.getLatestInsertedNode()
                .ifPresent(l -> current = l);
        }
    }

    public Optional<노드> search(Integer value) {
        current = head;

        Optional<노드> result;
        while ((result = current.nextNode(value)).isPresent()) {
            노드 노드 = result.get();
            if(노드.getValue().equals(value)) {
                return Optional.of(노드);
            }
            current = 노드;
        }

        return Optional.empty();
    }

    public void remove(Integer value) {

    }

    public 노드 getHead() {
        if(head == null) {
            throw new IllegalStateException("there's no data");
        }

        return head;
    }
}
