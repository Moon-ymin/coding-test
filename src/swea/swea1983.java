import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class swea1983 {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[] credit = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
        for (int testcase = 1; testcase <= T; testcase++) {
            String[] nk = sc.nextLine().split(" ");
            int N = Integer.parseInt(nk[0]);
            int K = Integer.parseInt(nk[1]);

            double[] scores = new double[N];
            for (int i = 1; i <= N ; i++) {
                String[] score = sc.nextLine().split(" ");
                double total = Integer.parseInt(score[0])*0.35
                        + Integer.parseInt(score[1])*0.45
                        + Integer.parseInt(score[2])*0.2;
                scores[i-1] = total;
            }

            String ans = "";
            // 점수를 알고 싶은 k 번째 학생의 학점 먼저 구하고
            double goal = scores[K-1];
            // 점수 오름차순 정렬하고
            Arrays.sort(scores);
            // k 번째 학생의 점수 비교해서 몇 번째인지 찾고
            for (int i = 0; i < N; i++) {
                if (goal == scores[i]){
                    ans = credit[i/(N/10)];
                    break;
                }
            }
            System.out.println("#" + testcase + " " + ans);

        }
    }
}
