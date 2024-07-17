import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1. 원의 개수 입력
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 원의 정보 담는 배열 말고 스택 활용
        // 이유 : 2개씩 비교하는 과정에서 중복 비교 필요없기 때문에, 비교한 대상은 pop()하려고
        // x 값 기준 정렬하게 TreeMap 활용
        List<int[]> list = new ArrayList<>();
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new int[]{x-r, x+r});
        }
        list.sort((c1, c2) -> {
            if (c1[0] != c2[0]) return c1[0] - c2[0];
            return c1[1] - c2[1];
        });

        // 2. 원의 중심 x좌표, 원의 반지름 r이 공백
        boolean isFold = false;
        int[] prev = new int[]{-(int)1e9, -(int)1e9};
        for (int[] c : list){
            if(prev[1] >= c[0] && prev[1] <= c[1]) {
                isFold = true;
                break;
            }
            prev = c;
        }
        System.out.println(isFold ? "NO" : "YES");

        /* 조건
         * 1. 모든 원의 중심 좌표는 x축 위에 존재 (x,0)
         * 2. N개의 원 중 임의의 2개를 선택했을 때, 교점이 존재하면 안됨
         * -> 외부에 있거나   r1 + r2 < |x1-x2|
         * -> 내부에 있어야 함 |x1-x2| < |r1-r2|
         */

    }
}
