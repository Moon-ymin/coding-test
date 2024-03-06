package sorting.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Fruit implements Comparable<Fruit> {
    // Comparable : 사용자가 정의한 클래스의 객체를 정렬하는 인터페이스
    private String name;
    private int score;

    public Fruit(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // 정렬 기준은 score가 낮은 순서
    @Override
    public int compareTo(Fruit o) {
        if (this.score < o.score) {
            return -1;
        }
        return 1;
    }
}
public class Ex8 {
    // 정렬 라이브러리 키(Key) 기준 정렬 예제
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore() + ") ");
        }
    }

}
