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
1. PriorityQueue<> : 일반적인 FIFO의 Queue가 아니라 들어가는 순서와 상관없이 우선
    순위가 높은 데이터가 먼저 나가는 자료구조
    - https://kbj96.tistory.com/49
    - 선언 방법
        1) 기본형 : 우선순위가 낮은 숫자가 먼저 나옴 (작은 숫자)
            PriorityQueue<Integer> pQ = new PriorityQueue<>()'
        2) 우선순위가 높은 숫자가 먼저 나옴 (큰 숫자)
            PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    - 기본 메서드
        1) .add() : 우선순위 큐에 원소 추가, 꽉 찬 경우 에러 발생
        2) .offer() : 원소 추가, 실패 시 false를 반환
        3) .poll() : 첫 번째 값을 반환하고 제거, 비어있으면 null 반환
        4) .remove() : 첫 번째 값을 반환하고 제거, 비어있으면 에러 발생
        5) .isEmpty() : 첫 번째 값을 반환하고 제거, 비어있으면 에러 발생
        6) .peek() : 첫 번째 값을 반환하고 제거하진 않음, 비어있으면 null 반환

2. ArrayList<> : 인덱스 0부터 시작, 연속된 메모리 공간 사용. 크기가 가변적
    - 선언 방법
        1) import java.util.ArrayList;
        2) ArrayList<Integer> list = new ArrayList<>();
    - 기본 메서드
        1) .add() : 값 추가
        2) .set(index, element) : index 에 element 추가
        3) .remove(index | element) : 값 제거, index 사용시 삭제되는 element 리턴받음
        4) .clear() : 전체 값 삭제
        5) .contains() : 값 존재 확인, boolean
        6) .indexOf() : 값이 존재하는 경우 해당 element의 인덱스 리턴
        7) .sort() : 오름차순 정렬
            .sort(list, Collections.reverseOrder()) : 내림차순 정렬
            .sort( Comparator.comparing(Food::getIndex) )
        3) .get(index) : 인덱스로 값 확인
            .get( (int) ((k-sumTime)%length) ).getIndex()
    - Iterator 인터페이스 ~ iterator() 메소드
        https://minhamina.tistory.com/18
       boolean .hasNext() : iteration이 다음 요소를 가지고 있으면 true
       E .next() : iteration의 다음 요소 반환
       void .remove() : 컬렉션에서 객체를 제거
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

