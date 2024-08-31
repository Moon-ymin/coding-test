import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Node implements Comparable<Node> {
        int to, weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int V, E;
    static long result;
    static List<Node> adjList[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[V+1];
            visited = new boolean[V+1];

            for(int i=1; i<=V; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int e=1; e<=E; e++) {
                // 정점 A, 정점 B의 가중치 C
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                adjList[A].add(new Node(B, C));
                adjList[B].add(new Node(A, C));
            }

            result = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(1, 0));

            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                int curTo = cur.to;
                int curWeight = cur.weight;

                if(visited[curTo]) continue;
                visited[curTo] = true;
                result += curWeight;

                for(Node node : adjList[curTo]) {
                    if (visited[node.to]) continue;
                    pq.offer(node);
                }
            }
            System.out.println("#"+t+" "+result);
        }

    }
}