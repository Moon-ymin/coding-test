import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb;

        int T = sc.nextInt();

        while(T-- > 0){
            String Line = sc.next();
            int n = sc.nextInt();
            Deque<Integer> nums = new ArrayDeque<>();
            boolean isFront = true;
            boolean isError = false;

            String input = sc.next();
            if (n > 0) {
                input = input.substring(1, input.length()-1);
                String[] inputs = input.split(",");
                for(int i=0; i<n; i++){
                    nums.add(Integer.parseInt(inputs[i]));
                }
            }


            for(char c : Line.toCharArray()){
                if (c == 'R'){
                    isFront = !isFront;
                } else {
                    if (nums.isEmpty()){
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if (isFront) {
                        nums.pollFirst();
                    }
                    else {
                        nums.pollLast();
                    }
                }
            }

            // 결과 출력
            if (isError) continue;
            sb = new StringBuilder();
            sb.append("[");
            while(!nums.isEmpty()){
                sb.append(isFront ? nums.pollFirst() : nums.pollLast());
                if (!nums.isEmpty()) sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
