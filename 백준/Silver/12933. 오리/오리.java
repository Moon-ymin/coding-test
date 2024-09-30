import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ducks = sc.next();
        sc.close();

        if (ducks.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int[] count = new int[5];  // 'q', 'u', 'a', 'c', 'k'에 대한 카운트를 저장
        int quackCount = 0;  // 현재 진행 중인 'quack'의 개수
        int duckCount = 0;   // 오리의 총 개수

        for (char ch : ducks.toCharArray()) {
            switch (ch) {
                case 'q':
                    if (count[4] > 0) count[4]--;  // 'k'를 다 마친 오리가 다시 'q'로 시작
                    else quackCount++;  // 새로운 'quack' 시작
                    count[0]++;
                    break;
                case 'u':
                    if (count[0] > 0) {
                        count[0]--;
                        count[1]++;
                    } else {
                        System.out.println(-1);  // 순서가 맞지 않으면 -1
                        return;
                    }
                    break;
                case 'a':
                    if (count[1] > 0) {
                        count[1]--;
                        count[2]++;
                    } else {
                        System.out.println(-1);
                        return;
                    }
                    break;
                case 'c':
                    if (count[2] > 0) {
                        count[2]--;
                        count[3]++;
                    } else {
                        System.out.println(-1);
                        return;
                    }
                    break;
                case 'k':
                    if (count[3] > 0) {
                        count[3]--;
                        count[4]++;
                    } else {
                        System.out.println(-1);
                        return;
                    }
                    break;
                default:
                    System.out.println(-1);
                    return;
            }
        }

        // quack이 끝나지 않은 경우
        if (count[0] == 0 && count[1] == 0 && count[2] == 0 && count[3] == 0) {
            System.out.println(quackCount);
        } else {
            System.out.println(-1);
        }
    }
}