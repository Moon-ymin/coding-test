import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        // 연결리스트 채워넣기
        for (int[] e : edge) {
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }

        // BFS로 1번 노드부터 모든 노드까지의 최단 거리 구하기
        int[] distance = new int[n + 1];
        boolean[] isVisit = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(1);
        isVisit[1] = true;
        distance[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : arr[cur]) {
                if (!isVisit[next]) {
                    isVisit[next] = true;
                    distance[next] = distance[cur] + 1; // 현재 노드의 거리 + 1
                    q.offer(next);
                }
            }
        }

        // 최대 거리 찾기
        int maxDistance = 0;
        for (int dist : distance) {
            maxDistance = Math.max(maxDistance, dist);
        }

        // 최대 거리를 가진 노드 수 세기
        int count = 0;
        for (int dist : distance) {
            if (dist == maxDistance) {
                count++;
            }
        }

        return count; // 최종 정답
    }
}
