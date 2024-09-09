import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr = br.readLine().toCharArray();
			
			Arrays.sort(arr);
			sb.append(arr).append('\n');
			
			while(next_permutation(arr.length))
				sb.append(arr).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean next_permutation(int n) {
		int idx = n - 1;
		
		while(idx > 0 && arr[idx] <= arr[idx - 1]) 
			idx--;
		
		if(idx == 0)
			return false;
		
		for(int i=n - 1;i>=idx;i--) {
			if(arr[idx - 1] < arr[i]) {
				char temp = arr[i];
				arr[i] = arr[idx - 1];
				arr[idx - 1] = temp;
				break;
			}
		}
		
		Arrays.sort(arr, idx, n);
		return true;
	}
	
}