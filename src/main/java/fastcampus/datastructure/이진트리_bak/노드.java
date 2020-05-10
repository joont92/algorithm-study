package fastcampus.datastructure.이진트리_bak;

import java.util.Optional;

public class 노드 {
    private Integer value;
    private 노드 left;
    private 노드 right;

    private 노드 latest;

    public 노드(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Optional<노드> getLeft() {
        return Optional.ofNullable(left);
    }

    public Optional<노드> getRight() {
        return Optional.ofNullable(right);
    }

    public static void test() {

    }

    public boolean insert(Integer value) {
        if(value < this.value && left == null) {
            left = new 노드(value);
            latest = left;
            return true;
        } else if (value > this.value && right == null) {
            right = new 노드(value);
            latest = right;
            return true;
        }

        return false;
    }

    public Optional<노드> getLatestInsertedNode() {
        return Optional.ofNullable(latest);
    }

    public Optional<노드> select(Integer value) {
        return nextNode(value)
            .filter(n -> n.getValue().equals(value));
    }

    public Optional<노드> nextNode(Integer value) {
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
