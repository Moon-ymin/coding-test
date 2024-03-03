import java.util.ArrayList;
import java.util.Collections;

public class Ex6 {
    // 무지의 먹방 라이브
    // 효율성 테스트 실패
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2}; // 음식을 먹는데 걸리는 시간
        int k = 5; // 네트워크 정상화까지 남은 시간

        int result = solution(food_times, k);
        System.out.println("음식 번호: " + result);
    }

    public static int solution(int[] food_times, long k) {
        ArrayList<int[]> foods = new ArrayList<>();
        int n = food_times.length;

        // (먹는데 걸리는 시간, 음식 번호) 저장
        for (int i = 0; i < n; i++) {
            foods.add(new int[]{food_times[i], i + 1});
        }

        // 튜플의 첫번째 인덱스 기준으로 정렬(걸리는 시간이 작은 음식부터 큰 음식순으로 정렬)
//        Collections.sort(foods, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o1[0], o2[0]);
//            }
//        });
        Collections.sort(foods, (o1, o2) -> Integer.compare(o1[0], o2[0]));


        int pretime = 0;
        for (int i = 0; i < foods.size(); i++) { // 음식을 먹는 루프
            int[] food = foods.get(i);
            int diff = food[0] - pretime;
            if (diff != 0) {
                int spend = diff * n; // 현재 음식을 다 먹는데 걸리는 시간
                if (spend <= k) {
                    k -= spend;
                    pretime = food[0];
                } else {
                    int idx = (int) (k % n); // 여기서 n은 남은 음식의 수이다
                    // 남은 음식을 번호 순으로 다시 정렬
                    /*Collections.sort(foods.subList(i, foods.size()), new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            return Integer.compare(o1[1], o2[1]);
                        }
                    });*/
                    Collections.sort(foods.subList(i, foods.size()), (o1, o2) -> Integer.compare(o1[1], o2[1]));

                    return foods.get(i + idx)[1];
                }
            }
            n--; // 현재 음식 다 먹음
        }
        // for문 도중 return이 안됬다는 것은 k가 남았다
        // -> 음식을 다 먹었다 -> -1 반환
        return -1;
    }
}