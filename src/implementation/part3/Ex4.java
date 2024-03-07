package implementation.part3;

/*
1. 자물쇠와 열쇠의 크기는 20X20보다 작다
2. 20X20의 2차원 배열에 모드 접근하기 위해서는 400만큼의 연산이 필요
3. 완전탐색 가능
4. 자물쇠 배열의 크기를 3배 이상으로 변경한다 -> 자물쇠 (n*3)X(n*3)
 */

public class Ex4 {
    // 자물쇠와 열쇠
    // 2차원 리스트 90도 회전 메소드 암기하기

    // 2차원 리스트 90도 회전
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 90도 회전된 배열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    // 열쇠가 들어간 자물쇠 부분이 모두 1인지 확인
    public static boolean check(int[][] newLock){
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[n*3][n*3];
        // 새로운 자물쇠의 중앙에 기존의 좌물쇠 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        // 4방향 확인
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key); // 열쇠 회전
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // 자물쇠에 열쇠 끼워넣기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }
                    // 확장된 자물쇠에 열쇠가 들어맞는지 검사
                    if (check(newLock)) return true;
                    // 자물쇠에서 열쇠 다시 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

}
