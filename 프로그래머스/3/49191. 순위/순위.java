class Solution {
    public int solution(int n, int[][] results) {
                int answer = 0;

        boolean[][] score = new boolean[n+1][n+1];

        for(int[] r : results)
            score[r[0]][r[1]] = true;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(score[j][i] && score[i][k])
                        score[j][k] = true;
                }
            }
        }

        for(int i=1; i<=n; i++) {
            int count = 0;
            for(int j=1; j<=n; j++) {
                if(score[i][j] || score[j][i])
                    count++;
            }

            if(count == n-1)
                answer++;
        }

        return answer;
    }
}