package graph.part3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex4 {
    static class Point {
        int num, x, y, z;

        public Point(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Edge implements Comparable<Edge> {

        private int start;
        private int end;
        private int weight;

        public Edge(int weight, int start, int end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Edge other) {
            return weight - other.weight;
        }
    }
    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            points[i] = new Point(i, x, y, z);
        }
        edgeList = new ArrayList<>();

        // x, y, z 각각에 대해서 정렬하고 각 행성의 번호와 비용을 edgeList에 추가
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].x - points[i+1].x);
            edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
        }
        Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].y - points[i+1].y);
            edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
        }
        Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].z - points[i+1].z);
            edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        Collections.sort(edgeList);
        int ans = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            // 사이클이 발생하는 간선은 제외
            if (find(edge.start) != find(edge.end)) {
                ans += edge.weight;
                union(edge.start, edge.end);
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int find(int x){
        if ( x == parent[x] ){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if ( x!= y) {
            parent[y] = x;
        }
    }


}
