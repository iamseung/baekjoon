import java.util.*;

class Solution {
    static final int INF = 987654321;
    static List<ArrayList<Node>> list;
    
    public int solution(int N, int[][] road, int K) {
         // 자기 자신의 마을은 무조건 방문
        int answer = 1;

        // 인접 리스트
        list = new ArrayList<>();

        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            list.get(a).add(new Node(a, b, c));
            list.get(b).add(new Node(b, a, c));
        }

        return bfs(N, K);
    }
    
    static int bfs(int N, int K) {
        int answer = 1;

        int[] dist = new int[N+1];

        for(int i=2; i<=N; i++)
            dist[i] = INF;

        Queue<Node> queue = new LinkedList<>();

        // 1번에서 갈 수 있는 마을 전부 추가
        queue.addAll(list.get(1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 방문 예정 마을이 이동거리의 합보다 크거나 같지 않으면
            if(!(dist[node.b] <= dist[node.a] + node.l)) {
                dist[node.b] = dist[node.a] + node.l;
                queue.addAll(list.get(node.b));
            }
        }

        for(int i=2; i<=N; i++) 
            if(dist[i] <= K) answer++;

        return answer;
    }

    static class Node {
        int a, b, l;

        Node(int a, int b, int l) {
            this.a = a;
            this.b = b;
            this.l = l;
        }
    }
}