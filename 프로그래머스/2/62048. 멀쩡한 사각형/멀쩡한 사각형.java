class Solution {
    public long solution(int w, int h) {
        long W = (long)w;
        long H = (long)h;
        long gcd = getGCD(W, H);
        
        return W * H - (W + H - gcd);
    }
    
    public long getGCD(long a, long b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}

// 1. 최대 공약수가 1 : w+h-1
// 2. 최대 공약수가 1보다 큼 : w*h-(w+h-g)