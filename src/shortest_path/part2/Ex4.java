package shortest_path.part2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {
    // 미래 도시
    static int n, m, x, k;
    static int[][] graph = new int[101][101];
    static final int INF = (int) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }
        // `자기 자신 - 자기 자신`은 0으로 초기화
        for (int a = 1; a <= n ; a++) {
            for (int b = 1; b <= n; b++) {
                if ( a == b ) graph[a][b] = 0;
            }
        }

        // 연결된 회사에 대한 정보
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        x = sc.nextInt();
        k = sc.nextInt();

        // 점화식으로 플로이드 워셜 알고리즘 진행
        for (int k = 1; k <= n ; k++) {
            for (int a = 1; a <= n ; a++) {
                for (int b = 0; b <= n ; b++) {
                    graph[a][b] = Math.min( graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        int distance = graph[1][k] + graph[k][x];

        // 도달할 수 없는 경우, -1을 출력
        if (distance >= INF) {
            System.out.println(-1);
        } else {    // 도달할 수 있다면, 최단 거리를 출력
            System.out.println(distance);
        }


    }
}
