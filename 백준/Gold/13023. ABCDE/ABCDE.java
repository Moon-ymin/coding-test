
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 인접리스트 만들기 -> DFS 진행해서 너비 5이상이면 친구관계 있다고 판단하고 break
 * @author SSAFY
 *
 */

public class Main {
    static List<Integer> map[];
    static boolean isVisited[];
    static boolean isFriend;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new ArrayList[N];

        isFriend = false;

        for(int i=0; i<N; i++) {
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a].add(b);
            map[b].add(a);
        }

        for(int i=0; i<N; i++) {
            if(map[i].size() == 0) continue;
            isVisited = new boolean[N];

            dfs(i, 1);

            if (isFriend) break;
        }
        System.out.println(isFriend ? 1 : 0);

    }
    private static void dfs(int node, int depth) {
        if (depth == 5) {
            isFriend = true;
            return;
        }

        isVisited[node] = true;

        for(int i=0; i<map[node].size(); i++) {
            int next = map[node].get(i);
            if(!isVisited[next]) {
                dfs(next, depth+1);
            }
            if(isFriend) return; // 찾았으면 더 이상 탐색 안해도 됨
        }

        isVisited[node] = false; // 안되면 다른 경로 찾을 수 있게 방문 해제하기
    }

}
