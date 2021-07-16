package commons;

public class Node {
    private final int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

   public void add(Node node) {
        if (node.data < data) {
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }
        }
    }

    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        if (left != null) {
            leftHeight = 1 + left.getHeight();
        }

        if (right != null) {
            rightHeight = 1 + right.getHeight();
        }

        return Math.max(leftHeight, rightHeight);
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
