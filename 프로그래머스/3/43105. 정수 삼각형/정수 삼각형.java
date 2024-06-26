import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<len; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                    continue;
                }

                if(j == triangle[i].length) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int answer = Arrays.stream(dp[len-1]).max().getAsInt();

        return answer;
    }
}