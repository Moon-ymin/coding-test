import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        int loop = Math.min(N, M) / 2;
        
        for (int l = 0; l < loop; l++) {
            int length = 2 * (N + M - 4 * l) - 4; // 회전 그룹의 총 길이
            int rotations = R % length; // 필요 회전 수
            
            for (int r = 0; r < rotations; r++) {
                int temp = map[l][l];
                
                for (int i = l; i < M - l - 1; i++) map[l][i] = map[l][i + 1];
                for (int i = l; i < N - l - 1; i++) map[i][M - l - 1] = map[i + 1][M - l - 1];
                for (int i = M - l - 1; i > l; i--) map[N - l - 1][i] = map[N - l - 1][i - 1];
                for (int i = N - l - 1; i > l; i--) map[i][l] = map[i - 1][l];
                
                map[l + 1][l] = temp;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
