import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// 방문한 노드 
	static boolean[] visited;
	// 연결된 트리 구조 
	static ArrayList<Integer> list[];
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// 1. 노드의 개수
    	int N = Integer.parseInt(br.readLine());
    	visited = new boolean[N+1];	// 1~N 까지 인덱스 유지하기 위해 N+1 크기의 배열로 만들기
    	list = new ArrayList[N+1];
    	
    	// 2. 연결된 노드 넣을 수 있게 만들기
    	for(int i=1; i<list.length; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	// 3. 연결된 노드 정보 입력받기
    	for(int i=0; i<N-1; i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int n1 = Integer.parseInt(st.nextToken());
    		int n2 = Integer.parseInt(st.nextToken());
    		
    		list[n1].add(n1);
    		list[n2].add(n2);
    	}
    	
    	// 4. 질의의 개수 q
    	int q = Integer.parseInt(br.readLine());
    	
    	// 5. 단절점, 단절선 여부 답하기
    	while(q-->0) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int t = Integer.parseInt(st.nextToken());
    		int k = Integer.parseInt(st.nextToken());
    		String ans = "";
    		if (t==1) { // k번 정점이 단절점인가?
    			ans = list[k].size() >= 2 ? "yes": "no";
    		} else { // k번 간선이 단절선인가?
    			ans = "yes";
    		}
    		System.out.println(ans);
    	}
    	
    }
}
 
