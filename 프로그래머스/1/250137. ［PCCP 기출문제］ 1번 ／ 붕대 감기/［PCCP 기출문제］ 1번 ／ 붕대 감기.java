class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health; // 현재 체력
        int success = 0; // 연속된 횟수
        int attackIdx = 0; // 공격 순서
        
        int lastAttack = attacks[attacks.length - 1][0];
        
        for(int time=0; time<=lastAttack; time++){
            // 공격 시간
            if (attackIdx < attacks.length && time == attacks[attackIdx][0]) {
                currentHealth -= attacks[attackIdx][1];
                success = 0; // 연속 성공 횟수 초기화
                attackIdx++; // 다음 공격으로
                
                // 체력이 0이하면 즉시 종료
                if (currentHealth <= 0) return -1;
            } else {
            // 공격 아닌 시간
                // 회복 처리
                currentHealth += bandage[1];
                success++;
                
                // 
                if (success == bandage[0]){
                    currentHealth += bandage[2];
                    success = 0;
                }
                // 최대 체력 초과 못하게
                if (currentHealth > health){
                    currentHealth = health;
                }
            }
        }
        return currentHealth;
    }
}