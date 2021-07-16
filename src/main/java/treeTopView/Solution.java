package treeTopView;

import java.util.*;

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

class InputTree {
    public Node loadTreeFromStdin() {
        Scanner scan = new Scanner(System.in);

        int numberOfNodes = scan.nextInt();

        Node root = null;
        for (int i = 0; i < numberOfNodes; i++) {
            int data = scan.nextInt();

            if (root == null) {
                root = new Node(data);
            } else {
                root.add(new Node(data));
            }
        }
        scan.close();

        return root;
    }


    public Node loadTreeFromArray(List<Integer> inputs) {

        Node root = null;
        for (Integer data : inputs) {
            if (root == null) {
                root = new Node(data);
            } else {
                root.add(new Node(data));
            }
        }

        return root;
    }
}

class NodeLevel {
    Node node;
    int level;

    NodeLevel(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class Solution {
    private static final InputTree INPUT_TREE = new InputTree();

    public static void main(String[] args) {
        Node root = INPUT_TREE.loadTreeFromStdin();
//        Node root = INPUT_TREE.loadTreeFromArray(Arrays.asList(1, 2, 5, 3, 6, 4));
//        Node root = INPUT_TREE.loadTreeFromArray(Arrays.asList(37,23,108,59,86,64,94,14,105,17,111,65,55,31,79,97,78,25,50,22,66,46,104,98,81,90,68,40,103,77,74,18,69,82,41,4,48,83,67,6,2,95,54,100,99,84,34,88,27,72,32,62,9,56,109,115,33,15,91,29,85,114,112,20,26,30,93,96,87,42,38,60,7,73,35,12,10,57,80,13,52,44,16,70,8,39,107,106,63,24,92,45,75,116,5,61,49,101,71,11,53,43,102,110,1,58,36,28,76,47,113,21,89,51,19,3));
//        Node root = INPUT_TREE.loadTreeFromArray(Arrays.asList(1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9));
//       System.out.println(root == null ? -1 : root.getHeight());
        topView(root);
    }


    public static void topView(Node root) {
        if (root == null) return;

        Queue<NodeLevel> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new NodeLevel(root, 0));

        while (queue.size() > 0) {
            var nodeLevel = queue.poll();
            if (!map.containsKey(nodeLevel.level)) {
                map.put(nodeLevel.level, nodeLevel.node.data);
            }

            if (nodeLevel.node.left != null) {
                queue.add(new NodeLevel(nodeLevel.node.left, nodeLevel.level - 1));
            }

            if (nodeLevel.node.right != null) {
                queue.add(new NodeLevel(nodeLevel.node.right, nodeLevel.level + 1));
            }

        }

        var output = map.values().stream().map(Object::toString).reduce((v1, v2) -> v1 + " " + v2).orElse("");
        System.out.println(output);
    }

}
