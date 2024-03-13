package implementation.part3;

import java.util.ArrayList;
import java.util.Scanner;

// 조합 : https://bcp0109.tistory.com/15
class Combination {
    private int n;
    private int r;
    private int[] now;  // 현재 조합
    private ArrayList<ArrayList<Position>> result;  // 모든 조합

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }
    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth+1, index+1, target+1);
        combination(arr, depth, index, target+1);
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
public class Ex7 {

    // 1. 모든 집과 치킨 집의 위치
    // 2. 집-모든 치킨 집 거리 저장
    // 3. 치킨 집 m개 뽑는 조합
    // 4. 조합 별 치킨 거리 구하기
    // 위치, 조합, 메인 클래스 생성
    public static int n, m;
    public static int[][] map = new int[50][50];
    public static ArrayList<Position> chicken = new ArrayList<Position>();
    public static ArrayList<Position> house = new ArrayList<Position>();

    public static int getSum(ArrayList<Position> candidates){
        int result =0;
        // 모든 집에 대해서
        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).getX();
            int hy = house.get(i).getY();
            // 가장 가까운 치킨 집 찾기
            int temp = (int) 1e9;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            // 가장 가까운 치킨 집까지의 거리를 더하기
            result += temp;
        }
        // 치킨 거리
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) house.add(new Position(i,j));
                else if (map[i][j] == 2) chicken.add(new Position(i,j));
            }
        }

        // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
        Combination comb = new Combination(chicken.size(), m);
        comb.combination(chicken, 0, 0, 0);
        ArrayList<ArrayList<Position>> chickenList = comb.getResult();

        // 치킨 거리의 합의 최소를 찾아 출력
        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);

    }
}
