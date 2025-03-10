import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][8];

        // 톱니바퀴 상태 입력받기
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] rotateDir = new int[4];  // 각 톱니바퀴의 회전 방향 저장
            rotateDir[num] = dir; // 선택한 톱니바퀴의 회전 방향 설정

            // 왼쪽 톱니바퀴 회전 방향 결정
            for (int i = num - 1; i >= 0; i--) {
                if (map[i][2] != map[i + 1][6]) {
                    rotateDir[i] = -rotateDir[i + 1];
                } else {
                    break; // 극이 같으면 회전 멈춤
                }
            }

            // 오른쪽 톱니바퀴 회전 방향 결정
            for (int i = num + 1; i < 4; i++) {
                if (map[i][6] != map[i - 1][2]) {
                    rotateDir[i] = -rotateDir[i - 1];
                } else {
                    break; // 극이 같으면 회전 멈춤
                }
            }

            // 한꺼번에 회전 적용
            for (int i = 0; i < 4; i++) {
                if (rotateDir[i] != 0) rotate(i, rotateDir[i]);
            }
        }

        // 점수 계산
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][0] == 1) result += (1 << i);  // 1, 2, 4, 8
        }
        System.out.println(result);
    }

    // 톱니바퀴 회전 함수
    private static void rotate(int idx, int dir) {
        if (dir == 1) {  // 시계 방향 회전
            int temp = map[idx][7];
            for (int i = 7; i > 0; i--) {
                map[idx][i] = map[idx][i - 1];
            }
            map[idx][0] = temp;
        } else {  // 반시계 방향 회전
            int temp = map[idx][0];
            for (int i = 0; i < 7; i++) {
                map[idx][i] = map[idx][i + 1];
            }
            map[idx][7] = temp;
        }
    }
}
