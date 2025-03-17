import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int[][] alphaArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        alphaArray = new int[N][26];

        // 입력받기
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for(char ch : str.toCharArray()){
                alphaArray[i][ch - 'A']++;
            }
        }

        // 비교
        int total = 0;
        for (int i = 1; i < N; i++) {
            int add = 0, remove = 0;
            for(int j=0; j<26; j++){
                int diff = alphaArray[i][j] - alphaArray[0][j];

                if (diff > 0) add += diff;
                else if (diff < 0) remove -= diff;
            }
            // 유사 단어 판별 조건
            if (add <= 1 && remove <= 1 && add + remove <= 2) total++;
        }

        System.out.println(total);
    }


}
