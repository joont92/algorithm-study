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

    /**
     * @param value
     * @return 몇 번 만에 찾았는지
     */
    public int exist(Integer value) {
        Node current = head;
        int count = 0;

        int result;
        while((result = current.compare(value)) != 0) {
            if(result == -1) {
                Optional<Node> left = current.left();
                if(!left.isPresent()) {
                    return -1;
                }
                current = left.get();
            } else if(result == 1) {
                Optional<Node> right = current.right();
                if(!right.isPresent()) {
                    return -1;
                }
                current = right.get();
            }
            count++;
        }

        return count;
    }

    public boolean delete(Integer value) {
        Node current = head;

        while(true) {
            int result = current.compare(value);
            if(result == -1) {
                Optional<Node> left = current.left();
                if(!left.isPresent()) {
                    return false;
                }

                if(left.get().compare(value) == 0) {
                    current.removeLeft();
                    return true;
                }
                current = left.get();
            } else if(result == 1) {
                Optional<Node> right = current.right();
                if(!right.isPresent()) {
                    return false;
                }

                if(right.get().compare(value) == 0) {
                    current.removeRight();
                    return true;
                }
                current = right.get();
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

        public void removeLeft() {
            this.left = null;
        }

        public Optional<Node> right() {
            return Optional.ofNullable(right);
        }

        public void initRight(Integer value) {
            this.right = new Node(value);
        }

        public void removeRight() {
            this.right = null;
        }
    }
}
