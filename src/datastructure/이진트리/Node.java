package datastructure.이진트리;

import java.util.Optional;

public class Node {
    private Integer value;
    private Node left;
    private Node right;

    private Node latest;

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
        if(value < this.value && left == null) {
            left = new Node(value);
            latest = left;
            return true;
        } else if (value > this.value && right == null) {
            right = new Node(value);
            latest = right;
            return true;
        }

        return false;
    }

    public Optional<Node> getLatestInsertedNode() {
        return Optional.ofNullable(latest);
    }

    public Optional<Node> select(Integer value) {
        return nextNode(value)
            .filter(n -> n.getValue().equals(value));
    }

    public Optional<Node> nextNode(Integer value) {
        if(value.equals(this.value)) {
            return Optional.of(this);
        } if(value < this.value) {
            return getLeft();
        } else {
            return getRight();
        }
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
