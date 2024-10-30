import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int parent[], N, M;
    static List<Integer> parties[];

    static void make(){
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
    }
    static int findSet(int a){
        if (parent[a] == a) return a;
        return parent[a] = findSet(parent[a]);
    }
    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        make();

        // 진실을 아는 사람 
        st = new StringTokenizer(br.readLine());
        int trustCnt = Integer.parseInt(st.nextToken());

        // 진실 아는 사람 없으면 -> 모든 파티 수 M 만큼 과장 가능
        if (trustCnt==0) { 
            System.out.println(M);
            return;
        }

        // 진실 아는 사람들 같은 집합으로 
        int trust = Integer.parseInt(st.nextToken());
        for(int i=1; i<trustCnt; i++){
            union(trust, Integer.parseInt(st.nextToken()));
        }

        // 파티 정보 저장하기
        parties = new ArrayList[M];
        for(int i=0; i<M; i++){
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyCnt = Integer.parseInt(st.nextToken());

            if (partyCnt > 0){
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);

                for(int j=1; j<partyCnt; j++){
                    int p = Integer.parseInt(st.nextToken());
                    parties[i].add(p);
                    union(person, p);
                }
            }
        }

        // 각 파티마다 진실을 아는 사람이랑 같은 집합에 속한 사람인지 확인하기
        int result = M;
        int truthRoot = findSet(trust);

        for(List<Integer> party : parties){
            if (party.size() > 0){
                int partyRoot = findSet(party.get(0));
                if (partyRoot == truthRoot) result--;
            }
        }

        System.out.println(result);
    
    }
}