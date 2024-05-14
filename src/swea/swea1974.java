import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        for (int testcase = 1; testcase <= T ; testcase++) {
            boolean isDiff = false;

            // 스도쿠 입력받기
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] nums = sc.nextLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(nums[j]);
                }
            }

            // 행 확인
            for (int i = 0; i < 9; i++) {
                int[] compare = Arrays.copyOf(map[i], map.length);  // 배열 깊은 복사
                /* Arrays.copyOf() : 원본 배열의 요소는 새 배열에 복사되며, 새 배열과 원본 배열은 서로 독립적입니다.
                    ( 복사하고자 하는 배열, 복사하고자 하는 배열의 길이
                 */
                Arrays.sort(compare);
                for (int j = 0; j < 9; j++) {
                    if ( compare[j] != numbers[j] ) {
                        isDiff = true;
                        break;
                    }
                }
                if (isDiff) break;
            }

            // 열 확인
            if (!isDiff) {
                for (int i = 0; i < 9; i++) {
                    int[] compare = new int[9];
                    for (int j = 0; j < 9; j++) {
                        compare[j] = map[j][i];
                    }
                    Arrays.sort(compare);
                    for (int j = 0; j < 9; j++) {
                        if (compare[j] != numbers[j]) {
                            isDiff = true;
                            break;
                        }
                    }
                    if (isDiff) break;
                }
            }

            // 3X3 확인 : 이부분 삼중 포문 바로 구현 못 했음!!!
            if(!isDiff) {
                for (int i = 1; i <= 3; i++) {
                    List<Integer> compare = new ArrayList<>();
                    for (int j = (i - 1) * 3; j < i * 3; j++) {
                        for (int k = (i - 1) * 3; k < i * 3; k++) {
                            compare.add(map[j][k]);
                        }
                    }
                    Collections.sort(compare);
                    for (int j = 0; j < 9; j++) {
                        if(compare.get(j) != numbers[j]) {
                            isDiff = true;
                            break;
                        }
                    }
                    if (isDiff) {
                        break;
                    }
                }
            }


            if (!isDiff){
                for(int i=0; i<=6; i+=3) {      // 행 : i, 열 : j
                    for(int j=0; j<=6; j+=3) {
                        int[] compare = new int[9];

                        int a = i+3;    // 작은 박스 인덱스
                        int b = j+3;    // 작은 박스 행 : a, 열 : b

                        // 작은 박스 인덱스 범위로 값 찾기
                        int index = 0;
                        for(int x=i; x<a; x++) {
                            for(int y=j; y<b; y++) {
                                compare[index++] = map[x][y];
                                // System.out.printf("i : %d, j : %d, x : %d, y : %d, a : %d, b : %d\n", i, j, x, y, a, b);
                            }
                        }
                        Arrays.sort(compare);
                        for(int z=0; z<9; z++) {
                            if(compare[z] != numbers[z]) {
                                isDiff = false;
                                break;
                            }
                        }
                        if(isDiff) break;
                    }
                    if(isDiff) break;
                }
            }


            System.out.println("#"+testcase+" "+(isDiff ? "0" : "1"));
        }
    }
}
