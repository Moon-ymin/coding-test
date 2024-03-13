package implementation.part3;
// 1. 기둥을 설치한다 → 해당 위치에 설치할 수 있는지 확인
// 2. 기둥을 삭제한다 → 삭제 후 유효한지 확인
// 3. 보를 설치한다 → 해당 위치에 설치할 수 있는지 확인
// 4. 보를 삭제한다 → 삭제 후 유효한지 확인
// 5. 결과를 담은 배열을 만들어 반환한다
public class Ex6 {
    boolean[][] pillar;
    boolean[][] bar;

    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];

        int cnt = 0;
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];

            if (type == 0) {    // 기둥
                if (action == 1) {  // 1. 기둥을 설치
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        cnt++;
                    }
                } else {            // 2. 기둥을 제거
                    pillar[x][y] = false; // 일단 삭제
                    if (canDelete(n) == false) pillar[x][y] = true; // 괜찮은지 확인
                    else cnt--;
                }
            } else {    // 보
                if (action == 1) {  // 3. 보를 설치
                    if (checkBar(x, y)) {
                        bar[x][y] = true;
                        cnt++;
                    }
                } else {            // 4. 보를 제거
                    bar[x][y] = false; // 일단 삭제
                    if (canDelete(n) == false) bar[x][y] = true; // 괜찮은지 확인
                    else cnt--;
                }
            }
        }

        int[][] result = new int[cnt][3];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx++][2] = 0;
                }
                if(bar[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx++][2] = 1;
                }
            }
        }
        return result;
    }
    boolean canDelete(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(pillar[i][j] && checkPillar(i, j) == false) return false;
                // 기둥이 해당 위치에 있을 수 없다면 false
                else if(bar[i][j] && checkBar(i,j) == false) return false;
                // 보가 해당 위치에 있을 수 없다면 false
            }
        }
        return true;
    }

    boolean checkPillar(int x, int y) { // 기둥 설치 가능한지 확인
        if(y == 0) return true; // 바닥에 설치하는 경우
        else if (y>0 && pillar[x][y-1]) return true;    // 아래 기둥이 있는 경우
        else if (x>0 && bar[x-1][y] || bar[x][y]) return true; // 보의 한 쪽 끝 위에
        return false;
    }
    boolean checkBar(int x, int y) {    // 보 설치 가능한지 확인
        if (y>0 && pillar[x][y-1] || pillar[x+1][y-1]) return true; // 한쪽 끝부분이 기둥 위에
        else if (x>0 && bar[x-1][y] && bar[x+1][y]) return true; // 양쪽 끝이 보와 동시에 연결
        return false;
    }
}
