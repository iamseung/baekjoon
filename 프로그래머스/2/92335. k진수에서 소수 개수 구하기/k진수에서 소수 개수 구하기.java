import java.util.*;

class Solution {    
    public int solution(int n, int k) {
        int ANS = 0;
        
        String s = Integer.toString(n,k);
        StringTokenizer st = new StringTokenizer(s, "0");

        while (st.hasMoreTokens()) {
            Long N = Long.parseLong(st.nextToken());
            if(isPrime(N)) ANS ++;
        }
        
        return ANS;
    }
    
    static boolean isPrime(Long k) {
        if(k <= 1) return false;

        for(int i=2; i<=(int) Math.sqrt(k); i++) {
            if(k % i == 0) return false;
        }

        return true;
    }
}