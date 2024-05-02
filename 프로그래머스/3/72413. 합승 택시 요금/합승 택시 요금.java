import java.util.*;

class Solution {
    static int N;
    static int E;
    static int[][] matrix;
    static final int MAX = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        E = fares.length;
        matrix = new int[n][n];

        for (int i = 0; i < E; i++) {
            int u = fares[i][0] - 1;
            int v = fares[i][1] - 1;
            int cost = fares[i][2];
            matrix[u][v] = matrix[v][u] = cost;
        }

        // int[], 출발지로부터 최소 거리를 계산
        int[] together = dijkstra(s - 1);

        int minCost = MAX;
        for(int i = 0; i < N; i++) {
            // i 부터 모든 Node 까지 거리 최소 값 계산
            int[] alone = dijkstra(i);

            // 출발지 -> i + i -> a + i -> b
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            if(cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }
    
    public int[] dijkstra(int start) {
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, MAX);
        distance[start] = 0;

        // 최소 거리를 계산해야 하기 때문에 거리 오름차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, start});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int cur = node[1];
            if (visited[cur])
                continue;

            visited[cur] = true;

            for (int next = 0; next < N; next++) {
                // 갈 수 없는 곳 예외처리
                if(matrix[cur][next] == 0) 
                    continue;

                // 거리 최소 값 계산
                if (distance[next] > distance[cur] + matrix[cur][next]) {
                    distance[next] = distance[cur] + matrix[cur][next];
                    pq.add(new int[]{distance[next], next});
                }
            }
        }

        return distance;
    }
}