import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, a, b, c;
    static List<Node> list[];

    static class Node implements Comparable<Node>{
        int to;
        int val;

        public Node(int to, int val) {
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, val));
            list[to].add(new Node(from, val));
        }

        long[] dist1 = dijkstra(a);
        long[] dist2 = dijkstra(b);
        long[] dist3 = dijkstra(c);

        int vertex = 0;
        long diff = 0;
        for (int i = 1; i <= n; i++) {
            long minDiff = Math.min(dist1[i], Math.min(dist2[i], dist3[i]));

            if(minDiff == diff) continue;
            if(minDiff > diff){
                diff = minDiff;
                vertex = i;
            }
        }
        System.out.println(vertex);
    }
    private static long[] dijkstra(int start) {
        long[] dist = new long[n+1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curTo = cur.to;
            int curVal = cur.val;

            if(dist[curTo] < curVal) continue;

            for (int i = 0; i < list[curTo].size(); i++) {
                int nVal = curVal + list[curTo].get(i).val;
                int nTo = list[curTo].get(i).to;

                if(dist[nTo] > nVal) {
                    dist[nTo] = nVal;
                    pq.add(new Node(nTo, nVal));
                }
            }
        }
        return dist;
    }
}