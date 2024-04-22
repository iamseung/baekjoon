import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] vertex) {
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for(int[] v : vertex) {
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }
        
        visited = new boolean[n+1];
        return bfs(n);
    }
    
    static int bfs(int n) {
        Queue<int[]> que = new LinkedList<>();
        int answer = 0, maxDep = 0;

        visited[1] = true;
        que.add(new int[]{1,0});

        while(!que.isEmpty()) {
            int[] q = que.poll();
            int cur = q[0], dep = q[1];

            if(dep == maxDep) {
                answer++;
            } else if(maxDep < dep) {
                maxDep = dep;
                answer = 1;
            }

            for(int w : graph.get(cur)) {
                if(!visited[w]) {
                    que.add(new int[]{w, dep + 1});
                    visited[w] = true;
                }
            }    
        }

        return answer;
    }
}