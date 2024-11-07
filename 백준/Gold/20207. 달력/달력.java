import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] calender = new int[365];

        // 일정 입력 받기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            for (int j = start; j <= end; j++) {
                calender[j]++;
            }
        }

        // 면적 계산
        int total = 0;
        int width = 0, height = 0;

        for (int i = 0; i < 365; i++) {
            if (calender[i] > 0) {
                width++;
                height = Math.max(height, calender[i]);
            } else if (width > 0){
                total += width * height;
                width = 0;
                height = 0;
            }
        }

        // 마지막 구간 처리
        if (width > 0) total += width * height;

        System.out.println(total);
    }
}