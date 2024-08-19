import java.util.*;

class Solution {
    boolean[] isVisited;
    ArrayList<String> worlds;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        isVisited = new boolean[tickets.length];
        worlds = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(worlds);
        answer = worlds.get(0).split(" ");

        return answer;
    }
    public void dfs(String dept, String world, String[][] tickets, int cnt){
        if (cnt == tickets.length){
            worlds.add(world);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (dept.equals(tickets[i][0]) && !isVisited[i]) {
                isVisited[i] = true;
                dfs(tickets[i][1], world+" "+tickets[i][1], tickets, cnt+1);
                isVisited[i] = false;
            }
        }
    }
}