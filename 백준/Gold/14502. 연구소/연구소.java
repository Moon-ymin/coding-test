import java.util.Scanner;

public class Main {
    static int n, m, result = 0;
    static int[][] before = new int[8][8]; // 초기 맵
    static int[][] after = new int[8][8]; // 벽 설치 후 맵

    // 4가지 이동 방향
    static int[] dx = { -1, 0, 1, 0};
    static int[] dy = { 0, 1, 0, -1};

    // 바이러스 퍼지는 DFS
    public static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < m ) {
                if (after[nx][ny] == 0) {
                    // 바이러스 배치하기, 다시 재귀 수행
                    after[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    // 안전영역 계산 메서드
    public static int safe() {
        int zero = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (after[i][j] == 0) zero++;
            }
        }
        return zero;
    }

    // DFS로 벽 설치하면서 매 번 안전영역 계산
    public static void dfs(int count){
        // 벽이 3개인 경우
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    after[i][j] = before[i][j];
                }
            }
            // 각 바이러스의 위치에서 전파 발생
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(after[i][j] == 2) { virus(i, j); }
                }
            }
            // 안전 영역의 최대값
            result = Math.max(result, safe());
            return;
        }
        // 빈 공간에 벽 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] == 0) {
                    before[i][j] = 1; // 방문처리
                    count++;          // 방문처리 ⇒ 벽 세움
                    dfs(count);
                    before[i][j] = 0;
                    count--;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                before[i][j] = sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(result);
    }
}