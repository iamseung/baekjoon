import java.util.*;

class Solution {
    static boolean[][] graph;
    
    public int solution(int n, int[][] wires) {
        conn(n, wires);
        
        int answer = n;
        
        int a,b;
        for(int[] w : wires) {
            a = w[0];
            b = w[1];
            
            graph[a][b] = false;
            graph[b][a] = false;
            
            answer = Math.min(answer, bfs(n,a));
            
            graph[a][b] = true;
            graph[b][a] = true;
        }
        
        return answer;
    }
    
    public int bfs(int n, int start) {
        boolean[] visit = new boolean[n+1];
        int cnt = 1;
        
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);
        
        while(!Q.isEmpty()) {
            int point = Q.poll();
            visit[point] = true;
            
            for(int i=1; i<=n; i++) {
                if(visit[i]) continue;
                if(graph[point][i]) {
                    Q.offer(i);
                    cnt++;
                }
            }
        }
        
        return (int) Math.abs(n-cnt*2);
    }
    
    public static void conn(int n, int[][] wires) {
        graph = new boolean[n+1][n+1];
        
        // 양방향
        for(int[] w : wires) {
            graph[w[0]][w[1]] = true;
            graph[w[1]][w[0]] = true;
        }
    }
}