package shortest_path.part3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    // 플로이드
    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 최단거리 테이블 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }
        // 자기자신~자기자신 은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a==b) graph[a][b] = 0;
            }
        }
        // 연결된 정보 입력 받기
        for (int i = 0; i < m; i++) {
            // 시작 a -> 도착 b (비용 c)
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // 가장 짧은 간선 정보만 저장
            if (c < graph[a][b]) graph[a][b] = c;
        }

        // 점화식, 플로이드워셜 진행
        for (int k = 1; k <= n ; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n ; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        // 결과 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n ; b++) {
                // 도달 못하면 무한
                if (graph[a][b] == INF) {
                    System.out.println(0 + " ");
                } else {    // 도달 가능하면 거리 출력
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
