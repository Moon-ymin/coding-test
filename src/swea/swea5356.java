import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays; // Arrays 패키지를 임포트

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int testcase = 1; testcase <= T; testcase++) {
            List<String> words = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                String word = sc.nextLine();
                words.add(word);
            }

            int maxLen = 0;
            for (String word : words) {
                if (maxLen < word.length()) maxLen = word.length();
            }

            char[][] wordMap = new char[5][maxLen];

            for (int i = 0; i < 5; i++) {
                Arrays.fill(wordMap[i], ' '); // ⭐️ 공백 문자로 초기화 ⭐️ : 아니면 NullPointerException 발생
                for (int j = 0; j < words.get(i).length(); j++) {
                    wordMap[i][j] = words.get(i).charAt(j);
                }
            }

            String answer = "";
            for (int j = 0; j < maxLen; j++) {
                for (int i = 0; i < 5; i++) {
                    if (wordMap[i][j] != ' ') {
                        answer += (wordMap[i][j]);
                    }
                }
            }
            System.out.printf("#%d %s\n", testcase, answer);
        }
    }
}
