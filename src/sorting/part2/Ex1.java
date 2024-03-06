package sorting.part2;

public class Ex1 {
    // 선택 정렬
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        int n = 10;

        for (int i = 0; i < n; i++) {
            int min_index = i;  // 가장 작은 원소의 인덱스
            for (int j = i+1; j < n; j++) {
                if (array[min_index] > array[j]) {
                    min_index = j;
                }
            }
            // 스와프
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
