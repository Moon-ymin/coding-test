import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static class Node {
        char letter;
        Node left, right;

        Node(char letter) {
            this.letter = letter;
        }
    }
    static Map<Character, Node> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            String[] strs = br.readLine().split(" ");
            char root = strs[0].charAt(0);
            char left = strs[1].charAt(0);
            char right = strs[2].charAt(0);

            map.putIfAbsent(root, new Node(root));

            if (left != '.') map.putIfAbsent(left, new Node(left));
            if (right != '.') map.putIfAbsent(right, new Node(right));

            map.get(root).left = (left == '.') ? null : map.get(left);
            map.get(root).right = (right == '.') ? null : map.get(right);
        }

        Node root = map.get('A');

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }

    static void preorder(Node root){
        if (root == null) return;
        System.out.print(root.letter);
        preorder(root.left);
        preorder(root.right);
    }
    static void inorder(Node root){
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.letter);
        inorder(root.right);
    }
    static void postorder(Node root){
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.letter);
    }
}