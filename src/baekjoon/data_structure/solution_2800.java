import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solution_2800 {

    static class Product {
        int index;
        int matchingIndex;

        public Product(int index, int matchingIndex) {
            this.index = index;
            this.matchingIndex = matchingIndex;
        }
    }

    static void generateCombinations(List<Product> pairs, boolean[] visited, int start, int r, Set<String> result, char[] chars) {
        if (r == 0) {
            generateExpression(pairs, visited, result, chars);
            return;
        }
        for (int i = start; i < pairs.size(); i++) {
            visited[i] = true;
            generateCombinations(pairs, visited, i + 1, r - 1, result, chars);
            visited[i] = false;
        }
    }

    static void generateExpression(List<Product> pairs, boolean[] visited, Set<String> result, char[] chars) {
        boolean[] toRemove = new boolean[chars.length];
        for (int i = 0; i < pairs.size(); i++) {
            if (visited[i]) {
                toRemove[pairs.get(i).index] = true;
                toRemove[pairs.get(i).matchingIndex] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!toRemove[i]) {
                sb.append(chars[i]);
            }
        }
        result.add(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        List<Product> pairs = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                int openIndex = stack.pop();
                pairs.add(new Product(openIndex, i));
            }
        }

        Set<String> result = new TreeSet<>();
        boolean[] visited = new boolean[pairs.size()];

        for (int i = 1; i <= pairs.size(); i++) {
            generateCombinations(pairs, visited, 0, i, result, chars);
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
