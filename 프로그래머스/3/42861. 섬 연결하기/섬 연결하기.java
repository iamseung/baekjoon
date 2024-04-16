import java.util.*;

class Solution {
    static private int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for(int i=0; i<n; i++)
            parent[i] = i;
        
        // 가중치 기준 오름차순
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        // Kruskal Algorithm
        for(int i=0; i<costs.length; i++) {
            // 두 정점이 연결되어 있지 않은 경우
            if(find(costs[i][0]) != find(costs[i][1])) {
                // 두 정점 연결
                union(costs[i][0], costs[i][1]);
                // 최소 비용의 간선들만 이용하여 모든 정점 연결
                answer += costs[i][2];
            }
        }

        return answer;
    }

    // 부모찾기
    static int find(int a) {
        if(parent[a] == a) return a;
        return find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) 
            parent[b] = a;
    }
}