package DFS_BFS.part3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1 {
    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] d = new int[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        // 그래프 및 최단 거리 테이블 초기화
        for (int i = 0; i <= n ; i++) {
            graph.add( new ArrayList<Integer>() );
            d[i] = -1;
        }
        // 도로 정보 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        // 출발 도시까지의 거리는 0으로 설정
        d[x] = 0;

        // BFS
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while(!q.isEmpty()){
            int now = q.poll();
            // 현재 도시에서 이동할 수 있는 모든 도시 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                // 아직 방문안했으면
                if (d[nextNode] == -1) {
                    // 최단 거리 갱신
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        // 최단 거리가 k인 모든 도시의 번호를 오름차순 출력
        boolean check = false;
        for (int i = 1; i <=n ; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }
        // k인게 하나도 없으면 -1
        if (!check) System.out.println(-1);
    }
}
