import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Bug {
        int r, c, dir, cnt;
        public Bug(int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    static List<Bug> bugs;
    static int N;
    static int[] dx = {0, -1, 1, 0, 0}; // 1-상 2-하 3-좌 4-우
    static int[] dy = {0, 0, 0, -1, 1};
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            bugs = new ArrayList<>();
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                bugs.add(new Bug(x, y, dir, cnt));
            }
            for(int i=0; i<M; i++){
                move();
            }
            int total = 0;
            for(int i=0; i<bugs.size(); i++){
                total += bugs.get(i).cnt;
            }
            sb.append("#"+t).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }
    private static void move(){
        // tempMap을 List<Bug>의 2차원 배열로 초기화
        List<Bug>[][] tempMap = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = new ArrayList<>();
            }
        }

        // 미생물 이동 구현
        for(int i=0; i<bugs.size(); i++) {
            Bug bug = bugs.get(i);

            // 1시간마다 이동방향에 있는 다음 셀로 이동
            bug.r += dx[bug.dir];
            bug.c += dy[bug.dir];

            // 약품이 칠해진 곳에 도달하면 미생물의 절반이 죽음, 이동방향 반대로 바뀜
            if (bug.r == 0 || bug.c == 0 || bug.r == N - 1 || bug.c == N - 1) {
                switch (bug.dir) {
                    case 1:
                        bug.dir = 2;
                        break;
                    case 2:
                        bug.dir = 1;
                        break;
                    case 3:
                        bug.dir = 4;
                        break;
                    case 4:
                        bug.dir = 3;
                        break;
                }
                bug.cnt = bug.cnt / 2;
            }
            tempMap[bug.r][bug.c].add(bug);
        }
        bugs.clear();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (tempMap[i][j].size() > 0) {
                    Collections.sort(tempMap[i][j], new Comparator<Bug>() {
                        @Override
                        public int compare(Bug o1, Bug o2) {
                            return o2.cnt - o1.cnt;
                        }
                    });

                    // 군집 수 가장 큰 미생물 기준으로 방향 설정하고 미생물 합치기
                    Bug maxBug = tempMap[i][j].get(0);
                    for (int k=1; k<tempMap[i][j].size(); k++) {
                        Bug smallBug = tempMap[i][j].get(k);
                        maxBug.cnt += smallBug.cnt;
                    }
                    if (maxBug.cnt > 0) bugs.add(maxBug);
                }
            }
        }
    }
}