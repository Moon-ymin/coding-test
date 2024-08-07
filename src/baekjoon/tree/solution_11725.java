import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solution_11725 {
	// 방문 처리에 사용 할 배열 선언
	static boolean[] visited;
	
	// 인덱스가 각각의 노드 번호가 될 수 있게 0번 인덱스는 아무것도 없는 상태로 생각
	static ArrayList<Integer> list[];    // 저장될 노드
	static int[] parents; // 출력할 부모 노드 저장하는 배열
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// 1. 노드의 개수 입력
    	int N = Integer.parseInt(br.readLine());
    	visited = new boolean[N+1]; // 노드의 인덱스는 1부터 시작하니까 0~N+1의 크기로 만들기
    	parents = new int[N+1];
    	list = new ArrayList[N+1];
    	
    	// 2. 노드 - 인접한 노드들 저장할 수 있게 만들기
    	for(int i=0; i<N+1; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	// 3. 연결된 노드들 입력받아서 저장하기
    	for(int i=0; i<N-1; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		list[a].add(b);
    		list[b].add(a);
    	}
    	
    	// 4. dfs 실행
        dfs(1);
        
        // 5. 결과 출력
        for(int i=2; i<parents.length; i++) {
        	System.out.println(parents[i]);
        }
    }
    
    static void dfs(int nodeIndex) {
    	// 방문처리
    	visited[nodeIndex] = true;
    	
    	// 방문한 노드에 인접한 노드 찾기
    	for (int node : list[nodeIndex]) {
    		// 인접한 노드가 방문한 적이 없다면 DFS 수행
    		if (!visited[node]) {
    			parents[node] = nodeIndex;
    			dfs(node);
    		}
    	}
    }
}
