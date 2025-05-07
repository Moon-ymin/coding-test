import java.util.*;

class Solution {
    int[] dr = {0,1,-1,0};
    int[] dc = {1,0,0,-1};
    public int solution(int[][] land) {
        
        // 석유량 배열
        int[] oil = new int[land[0].length];
        
        for(int r=0; r<land.length; r++){
            for(int c=0; c<land[0].length; c++){
                if (land[r][c]!=1) continue;
                
                // BFS 시작
                land[r][c] = 0;
                Queue<int[]> q = new ArrayDeque<>();
                
                // 열 범위
                Set<Integer> col = new HashSet<>();
                col.add(c);
                
                // 석유량
                int amount = 0;
                
                q.add(new int[]{r, c});
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];
                    
                    amount++;
                    
                    for(int dir=0; dir<4; dir++){
                        int nr = cr + dr[dir];
                        int nc = cc + dc[dir];
                        if (nr<0||nr>=land.length||nc<0||nc>=land[0].length||land[nr][nc]==0) continue;
                        land[nr][nc] = 0;
                        q.add(new int[]{nr, nc});
                        col.add(nc);
                    }
                }
                
                // 석유량 업뎃
                for(int co : col){
                    oil[co] += amount;
                }
            }
        }
        
        int answer = 0;
        for(int o : oil) answer = Math.max(answer, o);
        return answer;
    }
}