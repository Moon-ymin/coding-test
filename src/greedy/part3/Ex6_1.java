package greedy.part3;

import java.util.*;

class Food implements Comparable<Food> {
    private int index;
    private int time;

    public Food(int index, int time){
        this.index = index;
        this.time = time;
    }

    public int getIndex(){ return this.index; }
    public int getTime(){ return this.time; }

    @Override
    public int compareTo(Food other){
        return Integer.compare(this.time, other.getTime());
    }
}

class Solution {
    public static int solution(int[] food_times, long k) {
        long sumTime = 0;

        for (int i = 0; i < food_times.length; i++) {
            sumTime += food_times[i];
        }

        if(sumTime <= k){
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        sumTime = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        while(sumTime + ((pq.peek().getTime() - previous) * length) <= k){
            int now = pq.poll().getTime();
            sumTime += (now - previous) * length;
            previous = now;
            length--;
        }

        ArrayList<Food> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        result.sort(Comparator.comparing(Food::getIndex));

        return result.get((int) ((k-sumTime) % length)).getIndex();
    }
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2}; // 음식을 먹는데 걸리는 시간
        long k = 5; // 네트워크 정상화까지 남은 시간

        int result = solution(food_times, k);
        System.out.println(result);
    }
}

/* 사용함수
1. PriorityQueue<> :
    1) .offer()
    2) .peek().getTime()
    3) .poll().getTime()
    4) .isEmpty()
2. ArrayList<> :
    1) .add()
    2) .sort( Comparator.comparing(Food::getIndex) )
    3) .get( (int) ((k-sumTime)%length) ).getIndex()
 */

/* 효율성검사 실패 이유
1. Collections.sort() 호출 시마다 정렬이 이루어져 많은 시간
2. k가 매우 큰 경우도 고려

1. 우선순위 큐 활용 : 음식을 먹는 시간이 가장 적은 음식을 먼저 선택하는 방법
    이를 통해 정렬 과정을 줄이고 시간 복잡도를 개선할 수 있다.
2. 누적 시간 활용 : 각 음식을 먹는데 걸리는 시간을 누적하여 계산하면서 k를 초과
    하는 시점을 찾아 해당 음식을 반환한다.
    이 방법은 모든 음식을 일일이 정렬하지 않아도 되므로 효율적
*/

