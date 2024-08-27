import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int L, C;
    static List<Character> mo, ja;
    static List<String> results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        
        mo = new ArrayList<>();
        ja = new ArrayList<>();
        
        for(int i = 0; i < C; i++) {
            char c = sc.next().charAt(0);
            if ("aeiou".contains("" + c)) {
                mo.add(c);
            } else {
                ja.add(c);
            }
        }
        
        results = new ArrayList<>();
        List<Character> chars = new ArrayList<>(mo);
        chars.addAll(ja);
        Collections.sort(chars);
        
        // 조합 만들기
        combination(new ArrayList<>(), 0, chars);
        
        // 사전 순으로 정렬
        Collections.sort(results);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static void combination(List<Character> current, int start, List<Character> chars) {
        if (current.size() == L) {
            // 자음과 모음 조건을 만족하는지 체크
            int moCount = 0, jaCount = 0;
            for (char c : current) {
                if ("aeiou".contains("" + c)) {
                    moCount++;
                } else {
                    jaCount++;
                }
            }
            
            if (moCount >= 1 && jaCount >= 2) {
                // 조건을 만족하면~~ 결과 리스트에 추가
                StringBuilder sb = new StringBuilder();
                for (char c : current) {
                    sb.append(c);
                }
                results.add(sb.toString());
            }
            return;
        }
        
        for (int i = start; i < chars.size(); i++) {
            current.add(chars.get(i));
            combination(current, i + 1, chars);
            current.remove(current.size() - 1);
        }
    }
}