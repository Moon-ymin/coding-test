import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class solution_21942 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // 1. 부품 대여장의 정보의 개수 N, 대여기간 L, 벌금 F
        // 대여기간 DDD/hh:mm 
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int day = Integer.parseInt(L.substring(0, 3));
        int hour = Integer.parseInt(L.substring(4, 6));
        int min = Integer.parseInt(L.substring(7));
        int F = Integer.parseInt(st.nextToken());

        // 대여 기간을 분 단위로 변환
        int limitMinutes = (day * 1440) + (hour * 60) + min;

        TreeMap<String, Long> result = new TreeMap<>(); // 출력해야 할 결과 - 사람 이름 : 벌금
        HashMap<String, String> rent = new HashMap<>(); // 대여 정보

        for (int i = 0; i < N; i++) {
            // 2. 시간순으로 정보 (시각, 부품 이름 P, 회원 닉네임 M)
            String value = br.readLine();
            String[] parts = value.split(" ");
            String dateStr = parts[0] + " " + parts[1];
            String partName = parts[2];
            String nickname = parts[3];
            String key = partName + nickname;

            if (rent.containsKey(key)) { // 이미 대여한 기록이 있는지 확인하기
                // 대여 기록이 있을 경우 -> 반납, 벌금 내야하는지 확인
                String rentVal = rent.get(key);
                Date rentDate = format.parse(rentVal.substring(0, 16));
                Date returnDate = format.parse(dateStr);
                long minutes = (returnDate.getTime() - rentDate.getTime()) / (1000 * 60);

                if (limitMinutes < minutes) { // 벌금 내야 할 경우
                    long fine = (minutes - limitMinutes) * F;
                    result.put(nickname, result.getOrDefault(nickname, 0L) + fine);
                }
                rent.remove(key);
            } else { // 대여 기록이 없음 -> 대여
                rent.put(key, dateStr);
            }
        }

        // 3. 벌금 내야 하는 사람들을 사전순으로 (회원 닉네임 M, 벌금)
        if (result.size() > 0) {
            for (Map.Entry<String, Long> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } else {
            System.out.println(-1);
        }
    }
}
