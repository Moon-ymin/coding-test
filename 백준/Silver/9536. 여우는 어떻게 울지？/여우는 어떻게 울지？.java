import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            List<String> sounds = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
            Set<String> animalSounds = new HashSet<>();

            while (true) {
                String line = br.readLine();
                if (line.equals("what does the fox say?")) break;


                String[] parts = line.split(" ");
                animalSounds.add(parts[2]);
            }

            // 결과 출력 - 순서 유지, 다른 동물 소리 제외
            StringBuilder sb = new StringBuilder();
            for(String sound : sounds){
                if (!animalSounds.contains(sound)){
                    sb.append(sound).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}