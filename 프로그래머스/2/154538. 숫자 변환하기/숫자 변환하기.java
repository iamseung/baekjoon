import java.util.*;

class Solution {
    static final int maxValue = Integer.MAX_VALUE;
    static int cnt = maxValue;
    
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        
        dp[x] = 0;
        
        // x - y 까지 주어진 연산을 최소한으로 사용해서 몇번 만에 갈 수 있는지 계산
        for (int i = x; i <= y; i++) {
            if(dp[i] == -1) 
                continue;

            int next = dp[i] + 1;
            
            if (i * 2 <= y) {
                dp[i * 2] = (dp[i * 2] == -1) ? next : Math.min(next, dp[i * 2]);
            }
            
            if (i * 3 <= y) {
                dp[i * 3] = (dp[i * 3] == -1) ? next : Math.min(next, dp[i * 3]);
            }
            
            if (i + n <= y) {
                dp[i + n] = (dp[i + n] == -1) ? next : Math.min(next, dp[i + n]);
            }
        }
        
        return dp[y];
    }
}