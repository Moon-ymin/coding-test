import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        
        // 1. 순열
        visited = new boolean[dungeons.length];
        arr = new int[dungeons.length];
        dfs(0, dungeons, k);
        
        
        return max;
    }
    public void dfs(int depth, int[][] dungeons, int k){
        if (depth == dungeons.length){
           // System.out.println(Arrays.toString(arr));
            calc(arr, dungeons, k);
        }
        for(int i=0; i<dungeons.length; i++){
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(depth+1, dungeons, k);
            visited[i] = false;
        }
    }
    
    // 2. 정해진 순열로 최소 필요 피로도 비교
    public void calc(int[] arr, int[][] dungeons, int k){
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if (k>=dungeons[arr[i]][0]) {
                cnt++;
                k -= dungeons[arr[i]][1];
            } else {
                break;
            }
        }
        // 3. 최소 필요도 만족하면 소모 피로도 만큼 빼기   
        max = Math.max(max, cnt);
    }
    
    
}