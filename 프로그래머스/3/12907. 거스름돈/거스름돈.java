class Solution {
    public int solution(int n, int[] money) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];

        // 0원을 만드는 방법은 아무것도 사용하지 않는 것 한 가지
        dp[0] = 1; 

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        return dp[n];
    }
}