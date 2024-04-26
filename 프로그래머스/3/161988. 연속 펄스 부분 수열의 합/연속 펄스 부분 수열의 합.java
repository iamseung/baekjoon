class Solution {
    public long solution(int[] sequence) {
        long answer = 0L;

        int[] seq1 = new int[sequence.length];
        int[] seq2 = new int[sequence.length];

        for(int i=0; i<sequence.length; i++) {
            if(i%2==0) {
                seq1[i] = sequence[i];
                seq2[i] = sequence[i] * -1;
            } else {
                seq1[i] = sequence[i] * -1;
                seq2[i] = sequence[i];
            }
        }

        answer = maxSum(seq1);
        answer = Math.max(answer, maxSum(seq2));
        return answer;
    }
    
    public static long maxSum(int[] arr) {
        long max = 0L;
        long[] dp = new long[arr.length];

        dp[0] = arr[0];
        max = arr[0];

        for(int i=1; i<dp.length; i++) {
            // 이전까지의 최대값 + 현재값 과 현재값을 비교
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }          

        return max;
    }
}