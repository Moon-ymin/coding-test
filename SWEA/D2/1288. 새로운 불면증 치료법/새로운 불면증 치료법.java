import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테케
        int total = (1 << 10) -1; // 모든 숫자가 등장했을 때

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int seen = 0; // 등장한 숫자 저장하는 비트마스크
            int i = 0; // 양 센 횟수

            while (seen != total){
                i++;
                int n = N * i;

                while (n>0){
                    int digit = n % 10;
                    seen |= (1 << digit); // 비트 마스킹 OR 연산
                    n /= 10;
                }
            }

            System.out.println("#"+t+" "+(N*i));

        }
    }

}