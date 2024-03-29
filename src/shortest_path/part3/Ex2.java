package shortest_path.part3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    // 정확한 순위
    static final int INF = (int)1e9;
    static int n, m;
    static int[][] graph = new int[501][501];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }
        // 자기 자신 -> 자기 자신은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n ; b++) {
                if (a==b) graph[a][b] = 0;
            }
        }
        // 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        // n <= 500 -> 플로이드워셜 알고리즘
        for (int k = 1; k <= n ; k++) {
            for (int a = 1; a <= n ; a++) {
                for (int b = 0; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        int result = 0;
        //성적 순위를 정확히 알 수 있는 학생 카운트
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n ; j++) {
                if (graph[i][j] != INF || graph[j][i] != INF) { cnt+=1; }
            }
            if (cnt == n) result +=1;
        }
        System.out.println(result);

    }
}
