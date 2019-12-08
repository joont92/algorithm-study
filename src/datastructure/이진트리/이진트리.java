package datastructure.이진트리;

import java.util.Optional;

public class 이진트리 {
    private Node head;
    private Node current;

    public void insert(Integer value) {
        if(head == null) {
            head = new Node(value);
            return;
        }

        current = head;
        while (!current.insert(value)) {
            current.getLatestInsertedNode()
                .ifPresent(l -> current = l);
        }
    }

    public Optional<Node> search(Integer value) {
        current = head;

        Optional<Node> result;
        while ((result = current.nextNode(value)).isPresent()) {
            Node node = result.get();
            if(node.getValue().equals(value)) {
                return Optional.of(node);
            }
            current = node;
        }

        return Optional.empty();
    }

    public void remove(Integer value) {

    }

    public Node getHead() {
        if(head == null) {
            throw new IllegalStateException("there's no data");
        }

        return head;
    }
}
