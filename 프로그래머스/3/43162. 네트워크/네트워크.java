import java.util.*;

class Solution {
    static List<Integer>[] adj;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;

        adj = new ArrayList[n];
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();

        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) continue;
                if(computers[i][j] == 1)
                    adj[i].add(j);
            }
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }
    
    static void dfs(int k) {
        visited[k] = true;

        for(int a : adj[k]) {
            if(visited[a]) continue;
            dfs(a);
        }
    }
}