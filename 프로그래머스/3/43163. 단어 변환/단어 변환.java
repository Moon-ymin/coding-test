import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        boolean[] isVisit = new boolean[words.length];

        // 1. target이 words 안에 있는지 부터 확인
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) break;
            if (i == words.length - 1) return 0;
        }
        // 2. 시작 단어 큐에 추가
        q.add(begin);

        // 3. bfs 진행
        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(target)) return answer;

                // 현재 단어에서 변환 가능한 단어 탐색
                int[] diff = changeDiff(words, word);
                for (int j = 0; j < diff.length; j++) {
                    if (isVisit[j] || diff[j] != 1) continue;
                    isVisit[j] = true;
                    q.add(words[j]);
                }
            }
            answer++;

        }

        // 5. diff의 1인 애들로 bfs 진행 -> 갱신
        return answer;
    }

    // 4. words의 단어들이 begin과 몇 글자가 다른지 diff{} 배열로 만듦
    private int[] changeDiff(String[] words, String begin){
        int[] answer = new int[words.length];

        int index = 0;
        for(String word : words){
            int diff = 0;
            for(int i=0; i<word.length(); i++){
                if (word.charAt(i) != begin.charAt(i)) diff++;
            }
            answer[index++] = diff;
        }
        return answer;
    }
}