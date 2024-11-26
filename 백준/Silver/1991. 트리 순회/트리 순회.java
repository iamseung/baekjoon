import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char L = st.nextToken().charAt(0);
            char R = st.nextToken().charAt(0);

            insertNode(head, root, L, R);
        }
    }

    public static void process() {
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }

    public static void insertNode(Node temp, char root, char left, char right) {
        if (temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (temp.left != null)
                insertNode(temp.left, root, left, right);
            if (temp.right != null)
                insertNode(temp.right, root, left, right);
        }
    }

    // 전위, 루트>왼쪽자식>오른쪽자식
    public static void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위, 왼쪽자식>루트>오른쪽자식
    public static void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    // 후위, 왼쪽자식>오른쪽자식>루트
    public static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}

class Node {
    char value;
    Node left;
    Node right;

    Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}