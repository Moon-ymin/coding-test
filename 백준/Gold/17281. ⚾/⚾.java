import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] innings;
    static int maxScore = 0;
    static int[] order = new int[9];
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[3] = 0; // 4번 타자는 0번 선수로 고정한다
        visited[0] = true;
        permute(0);

        System.out.println(maxScore);
    }

    // 타순의 순열을 생성
    static void permute(int depth){
        if (depth == 9) {
            simulate();
            return;
        }

        if (depth == 3){
            permute(depth+1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                permute(depth+1);
                visited[i] = false;
            }
        }
    }

    // 시뮬레이션 진행
    static void simulate(){
        int score = 0;
        int playerIndex = 0; // 지금 타석에 선 선수

        for (int i = 0; i < N; i++) {
            int out = 0;
            boolean[] base = new boolean[3]; // 1~3 루

            while (out < 3){
                int hitter = order[playerIndex]; // 이번 타자
                int result = innings[i][hitter];

                switch (result) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        score += advance(base, 1);
                        base[0] = true;
                        break;
                    case 2:
                        score += advance(base, 2);
                        base[1] = true;
                        break;
                    case 3:
                        score += advance(base, 3);
                        base[2] = true;
                        break;
                    case 4:
                        score += advance(base, 4) + 1;
                        break;
                }

                playerIndex = (playerIndex + 1) % 9;
            }
        }
        maxScore = Math.max(maxScore, score);
    }

    // 주자 진루하기
    static int advance(boolean[] base, int hitter){
        int score = 0;
        for(int i=2; i>=0; i--){
            if (base[i]){
                if (i + hitter >= 3) score++;
                else base[i+hitter] = true;
            }
            base[i] = false;
        }
        return score;
    }
}
