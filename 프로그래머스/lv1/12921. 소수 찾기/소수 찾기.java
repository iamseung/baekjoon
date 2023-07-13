import java.util.*;

class Solution {
    static int cnt = 0;
    static boolean[] prime;
    
    public int solution(int n) {
        prime = new boolean[n+1];
        getPrime();
        
        for(int i=2; i<=n; i++) if(!prime[i]) cnt++;
        
        return cnt;
    }
    
    static void getPrime()
    {
        // 0과 1은 소수가 아님, true
        prime[0] = prime[1] = true;
        
        for(int i=2; i<=prime.length; i++) {
            for(int j=2; i*j<prime.length; j++) {
                prime[i*j] = true;
            }
        }
    }
}