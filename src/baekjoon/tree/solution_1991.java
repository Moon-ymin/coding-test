import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int root;
    Node left;
    Node right;
    public Node(int root){
        this.root = root;
    }
}

public class solution_1991 {
    static Node[] tree;

    public static void preOrder(Node node){
        if(node == null) return;
        System.out.print((char)node.root);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node){
        if (node == null) return;
        inOrder(node.left);
        System.out.print((char)node.root);
        inOrder(node.right);
    }
    public static void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print((char)node.root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 트리 노드 개수 N
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        // 2. 이진 트리 생성
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[root - 'A'] == null) {
                tree[root - 'A'] = new Node(root);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[root - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[root - 'A'].right = tree[right - 'A'];
            }
        }
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
        System.out.println();
    }
}
