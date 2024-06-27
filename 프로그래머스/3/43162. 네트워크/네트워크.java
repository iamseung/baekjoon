import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        adj = new ArrayList[n];

        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();

        // 양방향 Mapping
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j && computers[i][j] == 1) {
                    adj[i].add(j);
                }
            }
        }

        int idx = 0;
        for(int i=0; i<n; i++) {
            if(visited[i]) 
                continue;
            
            dfs(i);
            idx++;
        }
        
        return idx;
    }
    
    static void dfs(int k) {
        visited[k] = true;

        for(int ele : adj[k]) {
            if(visited[ele])
                continue;

            dfs(ele);
        }
    }
}