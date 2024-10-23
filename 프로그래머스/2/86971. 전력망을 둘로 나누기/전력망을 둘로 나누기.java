import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 1. 끊을 전선 하나 선택
        for(int i=0; i<wires.length; i++){
            List<Integer> graph[] = new ArrayList[n+1];
            for(int j=0; j<=n; j++){
                graph[j] = new ArrayList<>();
            }
            
            // 끊어진 전선 제외하고 그래프 구성
            for(int j=0; j<wires.length; j++){
                if (i==j) continue;
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            
            boolean[] visited = new boolean[n+1];
            int count = bfs(1, graph, visited);
            // 차이 계산
            int diff = Math.abs(count-(n-count));
            //System.out.println("송전탑 개수 : "+count);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    private int bfs(int start, List<Integer> graph[], boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int count =1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph[cur]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        return count;
    }
}