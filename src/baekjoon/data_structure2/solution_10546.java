import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solution_10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String name = br.readLine();
            if (map.get(name) == null) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }

        for (int i = 0; i < T-1; i++) {
            String name = br.readLine();
            map.put(name, map.get(name) -1);
        }

        for(String name : map.keySet()){
            if (map.get(name) != 0) {
                System.out.println(name);
                break;
            }
        }

    }
}
