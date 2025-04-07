import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        // 연결 리스트
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        // 연결된 길 만들기
        for(int[] r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        // destination 기준 최단 거리 
        int [] distance = new int[n+1];
        Arrays.fill(distance, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(destination);
        distance[destination] = 0;
        
        while(!q.isEmpty()){
            int c = q.poll();
            for(int next:graph.get(c)){
                if (distance[next] == -1){
                    distance[next] = distance[c] + 1;
                    q.offer(next);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i] = distance[sources[i]];
        }
        
        
        return answer;
    }
}