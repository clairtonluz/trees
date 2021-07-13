class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    void add(Node node) {
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

    int getHeight() {
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
}