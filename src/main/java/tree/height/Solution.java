package tree.height;

import commons.InputTree;
import commons.Node;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        Node root = new InputTree().loadTreeFromStdin();
        Node root = new InputTree().loadTreeFromArray(Arrays.asList(1, 2, 5, 3, 6, 4));

        System.out.println(root == null ? -1 : root.getHeight());
    }
}
