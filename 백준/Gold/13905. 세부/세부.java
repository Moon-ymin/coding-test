import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (this.weight - o.weight) * -1;
        }

    }

    static int N, M, A, B, C, s, e;
    static int[] parents;
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        edgeList = new Edge[M];

        st= new StringTokenizer(br.readLine()," ");
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(A,B,C);
        }

        make();

        Arrays.sort(edgeList);


        int res=0;
        for(int i=0;i<edgeList.length;i++) {
            union(edgeList[i].start, edgeList[i].end);
            res = edgeList[i].weight;
            if(find(s)==find(e)) break;

        }
        if(parents[s]!=parents[e]) res=0;
        System.out.println(res);
    }

    public static void print() {
        for (int i = 0; i <= N; i++)
            System.out.print(parents[i] + " ");
        System.out.println();
    }

    public static void make() {
        for (int i = 0; i <= N; i++)
            parents[i] = i;
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot <= bRoot) {
            parents[bRoot] = aRoot;
        }else {
            parents[aRoot] = bRoot;
        }
    }

    public static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

}