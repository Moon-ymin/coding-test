import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, parent[], cost[];

    // 초기화: 각 노드는 자기 자신을 부모로 가짐
    static void make() {
        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;
    }

    // 루트 찾기 (경로 압축)
    static int findSet(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findSet(parent[a]);
    }

    // 두 집합을 합치기 (작은 비용을 가진 노드를 루트로 설정)
    static boolean unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        // 비용이 적은 애를 루트로 설정
        if (cost[aRoot] < cost[bRoot]) {
            parent[bRoot] = aRoot; // aRoot를 루트로 설정
        } else {
            parent[aRoot] = bRoot; // bRoot를 루트로 설정
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        make(); // 초기화

        // 친구 관계 입력
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionSet(a, b);
        }

        // 최소 비용 계산
        int total = 0;
        boolean[] visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            int root = findSet(i); // 루트 찾기
            if (!visited[root]) {
                visited[root] = true;
                total += cost[root]; // 각 그룹의 최소 비용을 더함
            }
        }

        // 예산 초과하는지 확인
        if (total <= K) {
            System.out.println(total);
        } else {
            System.out.println("Oh no");
        }
    }
}