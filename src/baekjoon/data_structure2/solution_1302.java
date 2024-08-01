import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class solution_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 책의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 2. HashMap 사용 <- 제목으로 검색해서 책 있는지 확인 많이 할 것
        HashMap<String, Integer> books = new HashMap<>();

        // 3. 책 제목 입력 받아서 추가하기
        while(N-- > 0){
            String title = br.readLine();
            if (books.containsKey(title)){ // 책 이미 있는 경우
                books.put(title, books.get(title) + 1);
            } else {
                books.put(title, 1);
            }
        }

        int maxBook = Collections.max(books.values());
        String bestBook = "";

        for(Map.Entry<String, Integer> entry : books.entrySet()) {
            if (entry.getValue()==maxBook){
                if (bestBook.equals("") || entry.getKey().compareTo(bestBook) < 0){
                    bestBook = entry.getKey();
                }
            }
        }
        System.out.println(bestBook);
    }

}
