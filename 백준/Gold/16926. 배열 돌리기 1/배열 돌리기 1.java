import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 행의 수 N, 열의 수 M, 회전 수 R
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		// 2. N*M 크기의 map 채워넣기
		int[][] map = new int[N][M];
		int[][] result = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 3. Math.min(M, N) / 2 번 반복하기
		int loop = Math.min(N, M) / 2;
		
		for(int l=0; l<loop; l++) {
			Queue<Integer> q = new LinkedList<>();
			
			// 4. 큐에 쭉 넣었다가
			int x=l, y=l;
			q.add(map[x][y]);
			for(int a=0; a<M-1; a++) {
				q.add(map[x][++y]);
			}
			for(int b=0; b<N-1; b++) {
				q.add(map[++x][y]);
			}
			for(int c=0; c<M-1; c++) {
				q.add(map[x][--y]);
			}
			for(int d=0; d<N-2; d++) {
				q.add(map[--x][y]);
			}
			// 5. R번 맨 앞에서 뺐다가 맨 뒤로 다시 넣기 반복
			for(int r=0; r<R; r++) {
				q.add(q.poll());
			}
			
			// 6. result 다시 채워넣기
			x = l; y=l;
			result[l][l] = q.poll();
			for(int a=0; a<M-1; a++) {
				result[x][++y] = q.poll();
			}
			for(int b=0; b<N-1; b++) {
				result[++x][y] = q.poll();
			}
			for(int c=0; c<M-1; c++) {
				result[x][--y] = q.poll();
			}
			for(int d=0; d<N-2; d++) {
				result[--x][y] = q.poll();
			}
			
			M -= 2; N -= 2;
		}
		
		// 출력
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[0].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}