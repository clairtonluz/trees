package commons;

import java.util.List;
import java.util.Scanner;

public class InputTree {
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

