import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 100*100 크기의 map을 rectangle 개수만큼 차원 높여서 만들기
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        
        // rectangle 들을 차원대로 map에 넣기
        for(int i=0; i<rectangle.length; i++){
            int fromR = rectangle[i][0] * 2;
            int fromC = rectangle[i][1] * 2;
            int toR = rectangle[i][2] * 2;
            int toC = rectangle[i][3] * 2;
            
            for(int r=fromR; r<=toR; r++){
                for(int c=fromC; c<=toC; c++){
                    if (r==fromR || r==toR || c==fromC || c==toC) {
                        if (map[r][c]==0) map[r][c] = 1;
                    }
                    else map[r][c] = 2; // 내부
                }
            }
        }
        
        // bfs 최단 경로
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{characterX*2, characterY*2, 0}); // x, y, 이동 거리
        visited[characterX*2][characterY*2] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            
            // System.out.printf("지금 좌표 : %d, %d, %d\n", cx, cy, dist);
            
            if (cx == itemX*2 && cy == itemY*2) return dist/2;
            
            for(int dir=0; dir<4; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                
                
                if (nx<0 || nx>=101 || ny<0 || ny>=101) continue;            
                if (map[nx][ny] != 1 || visited[nx][ny]) continue; // map 값이 1인 곳만 갈 수 있음 (2이상 = 겹침)
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist+1});
                
            }
            
        }
        

        return -1;
    }
}