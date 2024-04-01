package graph.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex7 {
    // 도시 분할 계획
    // 전체 그래프에서 2개의 최소 신장 트리를 만든다
    // 1. 크루스칼 알고리즘으로 최소 신장 트리를 찾는다
    // 2. 간선 중에서 가장 비용이 큰 간선을 제거한다

    static class Edge implements Comparable<Edge> {
        private int distance;
        private int nodeA;
        private int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.distance < o.distance) {
                return -1;
            } return 1;
        }
    }
    public static int v, e;
    public static int[] parent = new int[100001];

    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            // 비용순으로 정렬하기 위해서 튜플의 첫 번째 원소를 비용으로 설정
            edges.add(new Edge(cost, a, b));
        }
        // 간선을 비용순으로 정렬
        Collections.sort(edges);
        int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }
        System.out.println(result - last);


    }
}
