class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];

        for(int[] r : results) 
            graph[r[0]][r[1]] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(graph[j][i] == 1 && graph[i][k] == 1)
                        graph[j][k] = 1;
                }
            }
        }

        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                // 둘 중 하나라도 순위를 알 수 있을 때
                if(graph[i][j] == 1 || graph[j][i] == 1)
                    cnt++;
            }

            // 본인을 제외한 모든 노드들과의 순위를 알 수 있을 때
            if(cnt == n-1) 
                answer++;
        }

        return answer;
    }
}