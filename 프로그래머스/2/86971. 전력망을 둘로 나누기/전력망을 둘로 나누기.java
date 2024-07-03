import java.util.*;

class Solution {
    static boolean[][] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new boolean[n+1][n+1];

        for(int[] w : wires) 
            graph[w[0]][w[1]] = graph[w[1]][w[0]] = true;

        for(int[] w : wires) {
            int a = w[0], b = w[1];
            graph[a][b] = graph[b][a] = false;
            answer = Math.min(answer, bfs(n,a));
            graph[a][b] = graph[b][a] = true;
        }
        
        return answer;
    }

    static int bfs(int n, int start) {
        boolean[] visit = new boolean[n+1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visit[cur] = true;

            for(int i=1; i<=n; i++) {
                if(visit[i])
                    continue;
                
                if(graph[cur][i]) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }

        // Math.abs(cnt - (n-cnt))
        return (int) Math.abs(n-cnt*2);
    }
}