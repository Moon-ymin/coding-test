import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1. N : 포켓몬의 개수 M : 문제의 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>(); // 포켓몬 저장할 맵 (인덱스, 이름)
        HashMap<String, Integer> map1 = new HashMap<>(); // 포켓몬 저장할 맵 (이름, 인덱스)

        // 2. 포켓몬 입력 받기
        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            map.put(i, name);
            map1.put(name, i);
        }

        // 3. 문제 답하기
        while(M-->0) {
            String q = br.readLine();
            if (isNumber(q)) { // 숫자면
                System.out.println(map.get(Integer.parseInt(q)));
            } else { // 문자면
                System.out.println(map1.get(q));
            }
        }
    }
    static boolean isNumber(String str) {
        return str.matches("\\d+");
    }
}
