import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int left, right;
        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static Node[] trees;
    static List<Integer> inorderStatus;
    static int N, lastNode,  visitedCnt, moveCnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        trees = new Node[N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            trees[cur] = new Node(left, right);
        }
        inorderStatus = new ArrayList<>();
        inorder(1);

        // 중위순회에서 마지막 노드
        lastNode = inorderStatus.get(N - 1);

        visited = new boolean[N+1];
        visited[0] = true;

        similarInOrder(1);
    }

    private static void inorder(int root) {
        Node cur = trees[root];
        int left = cur.left;
        int right = cur.right;

        if (left != -1) inorder(left);
        inorderStatus.add(root);
        if (right != -1) inorder(right);
    }

    private static void similarInOrder(int cur) {
        moveCnt++;

        if (!visited[cur]) {
            visited[cur] = true;
            visitedCnt++;
        }

        Node curNode = trees[cur];
        int left = curNode.left;
        int right = curNode.right;

        if (left != -1) {
            similarInOrder(left);
            moveCnt++;
        }
        if (right != -1) {
            similarInOrder(right);
            moveCnt++;
        }

        if (visitedCnt == N && cur == lastNode) {
            System.out.println(moveCnt-1);
        }
    }
}