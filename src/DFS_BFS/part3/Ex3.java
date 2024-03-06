package DFS_BFS.part3;

import java.util.*;

class Virus implements Comparable<Virus>{
    // (바이러스 종류, 시간, 위치 x, 위치 y)
    private int index;
    private int second;
    private int x, y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public int getSecond() {
        return second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 정렬 기준은 번호가 낮은 순서
    @Override
    public int compareTo(Virus v){
        if (this.index < v.index){
            return -1;
        } return 1;
    }
}
public class Ex3 {
    public static int n, k;
    public static int[][] graph = new int[200][200];
    public static ArrayList<Virus> viruses = new ArrayList<Virus>(); // 현재 바이러스 있는지 담기
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                // 해당 위치에 바이러스가 존재하는 경우
                if(graph[i][j] != 0) {
                    // (바이러스 종류, 시간, 위치 x, 위치 y) 삽입
                    viruses.add( new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        // 정렬 이후에 큐로 옮기기 (낮은 종류의 바이러스 먼저 증식)
        Collections.sort(viruses);
        Queue<Virus> q = new LinkedList<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer( viruses.get(i) );
        }

        int targetS = sc.nextInt();
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();

        // BFS 진행
        while (!q.isEmpty()) {
            Virus virus = q.poll();
            // 정확히 second만큼 초가 지나거나, 큐가 빌 때까지 반복
            if (virus.getSecond() == targetS) break;
            // 현재 노드에서 주변 4가지 위치를 각각 확인
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                // 좌표 범위 확인
                if (0<=nx && nx<n && 0<=ny && ny<n) {
                    // 아직 방문하지 않은 곳이라면, 그 위치에 바이러스 넣기
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.getIndex();
                        q.offer(new Virus(virus.getIndex(), virus.getSecond()+1, nx, ny));
                    }
                }
            }
        }
        System.out.println( graph[targetX-1][targetY-1] );
    }
}
