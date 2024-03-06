package sorting.part2;

public class Ex2 {
    // 스와프
    public static void main(String[] args) {
        int[] arr = {3,5};

        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;

        System.out.println(arr[0] + " " + arr[1]);
    }

}
