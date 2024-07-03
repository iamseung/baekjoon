import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int max = 0;

        // distance
        int[] dist = new int[n+1];
        for(int i=1; i<=n; i++)
            Arrays.fill(dist, -1);

        // mapping
        boolean[][] graph = new boolean[n+1][n+1];
        for(int[] e : edge)
            graph[e[0]][e[1]] = graph[e[1]][e[0]] = true;
        
        Queue<Integer> queue = new LinkedList<>();

        dist[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i=1; i<=n; i++) {
                if(dist[i] != -1) continue;
                if(!graph[cur][i]) continue;

                dist[i] = dist[cur] + 1;
                queue.add(i);

                max = Math.max(max, dist[i]);
            }
        }

        final int finalMax = max;
        
        return (int) Arrays.stream(dist)
                        .filter(i-> i == finalMax)
                        .count();
    }
}