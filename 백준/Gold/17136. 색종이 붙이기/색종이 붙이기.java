import java.util.Scanner;

public class Main {
    // 색종이 개수 최소 -> 큰 것부터 둬야 함
    // 색종이 배치 - 가능한지 확인 - 안되면 백트래킹 + 원상복구
    static int[][] board = new int[10][10];
    static int[] colors = {0, 5, 5, 5, 5, 5}; // 크기별로 개수
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        backtrack(0, 0, 0);
        System.out.println(minCnt == Integer.MAX_VALUE ? -1 : minCnt);
    }


    static void backtrack(int r, int c, int cnt) {
        // 모든 칸 다 봄
        if (r >= 10){ // board의 범위는 0~9라서 10되면 더 이상 탐색할 칸 없다는 거임
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        // 마지막 열이면 다음 행으로 이동
        if(c>=10){
            backtrack(r+1, 0, cnt);
            return;
        }

        // 0킨이면 넘어감
        if (board[r][c] == 0) {
            backtrack(r, c+1, cnt);
            return;
        }

        // 색종이 크기 5부터 1까지 시도 (큰 것부터 고려하기)
        for (int size = 5; size>=1; size--){
            if (canPlace(r, c, size)){ // size의 색종이 둘 수 있는지 확인
                placeColor(r,c,size,0); // 색종이 보드에 두기
                colors[size]--;
                backtrack(r, c+1, cnt+1);
                placeColor(r,c,size,1); // 색종이 보드에서 제거
                colors[size]++;
            }
        }
    }

    // 색종이를 둘 수 있는지 확인
    static boolean canPlace(int r, int c, int size){
        // 1. 해당 크기의 색종이 남아있는지 확인
        if (colors[size] == 0) return false;
        // 2. 색종이가 종이의 범위를 벗어나진 않는지 확인
        if (r+size>10 || c+size>10) return false;

        // 3. 색종이 둘 곳이 모두 1인지 확인
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if (board[i][j]==0) return false;
            }
        }
        return true;
    }

    // 색종이 보드에 두거나 없애기
    static void placeColor(int r, int c, int size, int value){
        for (int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                board[i][j] = value;
            }
        }
    }
}
