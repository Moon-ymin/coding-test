

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        solveSudoku(0, 0);
        printBoard();
    }

    static boolean solveSudoku(int row, int col) {
        if (row == 9) return true; // 모든 행을 다 채웠다면
        if (col == 9) return solveSudoku(row + 1, 0); // 다음 행으로 이동

        if (board[row][col] != 0) return solveSudoku(row, col + 1); // 이미 숫자가 채워져 있다면

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num; // 숫자를 삽입
                if (solveSudoku(row, col + 1)) return true; // 다음 셀로 진행
                board[row][col] = 0; // 되돌리기
            }
        }
        return false; // 해결할 수 없는 경우
    }

    static boolean isValid(int row, int col, int num) {
        // 행, 열 체크
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // 3x3 박스 체크
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // 유효한 경우
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
