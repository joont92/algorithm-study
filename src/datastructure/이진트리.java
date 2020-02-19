package datastructure;

import java.util.Optional;

public class 이진트리 {
    private Node head;

    public 이진트리(Integer value) {
        this.head = new Node(value);
    }

    public boolean insert(Integer value) {
        Node current = head;

        while (true) {
            if(current.compare(value) == -1) {
                Optional<Node> opt = current.left();
                if(opt.isPresent()) {
                    current = opt.get();
                } else {
                    current.initLeft(value);
                    return true;
                }
            } else if (current.compare(value) == 1) {
                Optional<Node> opt = current.right();
                if(opt.isPresent()) {
                    current = opt.get();
                } else {
                    current.initRight(value);
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    private class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value) {
            this.value = value;
        }

        public int compare(Integer value) {
            return Integer.compare(value, this.value);
        }

        public Optional<Node> left() {
            return Optional.ofNullable(left);
        }

        public void initLeft(Integer value) {
            this.left = new Node(value);
        }

        public Optional<Node> right() {
            return Optional.ofNullable(right);
        }

        public void initRight(Integer value) {
            this.right = new Node(value);
        }
    }
}
