import java.util.*;

class Solution {
    Queue<Integer> servers;
    
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 최소 서버 증설 횟수
        servers = new ArrayDeque<>();
        
        for(int i=0; i<players.length; i++){
            int time = players[i]; // 해당 시간대 게임 이용자의 수
            int n = servers.size();
            
            if (time < (n+1)*m) { // 커버 가능함
                // System.out.printf("서버 수: %d, 지금 게임 이용자 수: %d\n", n, time);
                timeDiscnt(); // 증설된 모든 서버의 시간 감소
            } else {
                // 서버 추가하기                
                int cnts = time / m - servers.size();
                for(int cnt=0; cnt<cnts; cnt++){
                    servers.add(k);
                    answer++;
                }
                // System.out.println("증설 횟수: "+answer+", 게임 이용자 수: "+time);
                
                // 증설된 모든 서버의 시간 감소
                timeDiscnt();
            }
        }
        return answer;
    }
    private void timeDiscnt(){
        int size = servers.size();
        while(size-- > 0){
            Integer time = servers.poll() - 1;
            if (time > 0) servers.add(time);
        }
        return;
    }
}