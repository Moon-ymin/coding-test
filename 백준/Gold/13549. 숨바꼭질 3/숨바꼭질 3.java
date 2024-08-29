
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);

        // BFS
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            int[] next = {now-1, now+1, now*2};

            for (int i = 0; i < 3; i++) {
                int n = next[i];

                // 다음 위치가 범위 내에 있는지 확인
                if (n >= 0 && n <= 100000) {
                    int nextTime = (i==2) ? time[now] : time[now]+1;

                    if (nextTime < time[n]) {
                        time[n] = nextTime;
                        queue.add(n);
                    }
                }
            }
        }

        System.out.println(time[K]);
    }
}