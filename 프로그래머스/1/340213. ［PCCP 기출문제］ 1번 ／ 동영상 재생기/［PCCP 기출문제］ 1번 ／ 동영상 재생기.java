class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int start = changeMtoS(op_start);
        int end = changeMtoS(op_end);
        int now = changeMtoS(pos);
        int video = changeMtoS(video_len);
        
        now = isOp(start,end, now) == true ? end : now;
        
        for(String command : commands){
            if (command.equals("next")){
                now += 10;
                now = now > video ? video : now;             
            } else {
                now -= 10;
                now = now < 0 ? 0 : now;
            }
            now = isOp(start,end, now) == true ? end : now;
        }
        int answer_m = now / 60;
        int answer_s = now % 60;
        return String.format("%02d:%02d", answer_m, answer_s);
    }
    private int changeMtoS(String time){
        String[] origin = time.split(":");
        return Integer.parseInt(origin[0])*60 + Integer.parseInt(origin[1]);
    }
    
    private boolean isOp(int start, int end, int time){
        if (time >= start && time <= end) return true;
        return false;
    }
}