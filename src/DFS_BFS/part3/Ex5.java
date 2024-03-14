package DFS_BFS.part3;

public class Ex5 {

    // 균형잡힌 괄호 문자열 의 인덱스 반환
    public int balancedIndex(String p) {
        int count = 0;  // 왼쪽 괄호 개수
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') count += 1;
            else count -= 1;
            if (count == 0) return i;
        } return -1;
    }

    // 올바른 괄호 문자열인지 판단
    public boolean checkProper(String p) {
        int count = 0;  // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else {
                if (count == 0) { // 쌍이 맞지 않는 경우에 false 반환
                    return false;
                }
                count -= 1;
            }
        }
        return true; // 쌍이 맞는 경우에 true 반환
    }

    public String solution(String p){
        String answer = "";
        if (p.equals("")) return answer;    // 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
        int index = balancedIndex(p);
        // 2. 문자열을 두 균형잡힌 괄호 문자열 u, v로 분리
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);
        // 3. 올바른 괄호 문자열이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(u)) {
            answer = u + solution(v);
        }
        // 4. 올바른 괄호 문자열이 아니면
        else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자 제거
            String temp = "";
            for (int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') temp += ")";
                else temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
}
