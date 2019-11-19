package datastructure;

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
            if(current.getLeft().isPresent()) {
                current = current.getLeft().get();
            } else if(current.getRight().isPresent()) {
                current = current.getRight().get();
            }
        }
    }

    public boolean search(Integer value) {
        if(head == null) {

        }

        return true;
    }

    public Node getHead() {
        if(head == null) {
            throw new IllegalStateException("there's no data");
        }

        return head;
    }

    static class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public Optional<Node> getLeft() {
            return Optional.ofNullable(left);
        }

        public Optional<Node> getRight() {
            return Optional.ofNullable(right);
        }

        public boolean insert(Integer value) {
            if(left == null && value < this.value) {
                left = new Node(value);
                return true;
            } else if (right == null && value > this.value) {
                right = new Node(value);
                return true;
            }

            return false;
        }

        public boolean select(Integer value) {
            return this.value.equals(value) ||
                this.getLeft().map(Node::getValue).isPresent() ||
                this.getRight().map(Node::getValue).isPresent();
        }
    }
}
