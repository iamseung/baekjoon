import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        
        dp[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if(dp[i] == -1) continue;
            
            if (i * 2 <= y) {
                dp[i * 2] = (dp[i * 2] == -1) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
            }
            
            if (i * 3 <= y) {
                dp[i * 3] = (dp[i * 3] == -1) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
            }
            
            if (i + n <= y) {
                dp[i + n] = (dp[i + n] == -1) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }
        }
        
        return dp[y];
    }
}