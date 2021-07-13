import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
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

        System.out.println(root == null ? -1 : root.getHeight());
    }
}
