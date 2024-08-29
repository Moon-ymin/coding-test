import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, min;
    static boolean[] isVisited;
    static List<Position> houses, chickens, picks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        picks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    chickens.add(new Position(i, j));
                } else if (num == 1) {
                    houses.add(new Position(i, j));
                }
            }
        }
        // 치킨집들 중에 M개 뽑기 -> 조합
        isVisited = new boolean[chickens.size()];
        min = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(min);
    }
    private static void dfs(int depth, int start) {
        if (depth == M){ // M개 뽑았음
            // 치킨 거리 구하기
            int distance = getDistance();
            // 최소값 비교 및 갱신
            min = Math.min(min, distance);
            return;
        }
        for(int i=start; i<chickens.size(); i++){
            if (isVisited[i]) continue;
            isVisited[i] = true;
            picks.add(chickens.get(i));
            dfs(depth+1, i+1);
            picks.remove(picks.size()-1); // 선택했던 마지막 치킨집 삭제
            isVisited[i] = false;
        }
    }
    private static int getDistance() {
        int distance = 0;
        // houses의 모든 집의 치킨집까지의 최소거리 구하고, 치킨거리 구하기
        for(int i=0; i<houses.size(); i++){
            int hx = houses.get(i).x;
            int hy = houses.get(i).y;

            int d = Integer.MAX_VALUE;
            for(int j=0; j<picks.size(); j++){
                int cx = picks.get(j).x;
                int cy = picks.get(j).y;
                // 치킨집 - 집 까지 최소 거리
                d = Math.min(d, Math.abs(hx-cx) + Math.abs(hy-cy));
            }
            distance += d;
        }
        return distance;
    }
}
