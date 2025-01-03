import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static List<Node>[] adj;
    static final int START = 1, INF = 987654321;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            adj[i] = new ArrayList<>();

        int start, from, weight;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            adj[start].add(new Node(from, weight));
            adj[from].add(new Node(start, weight));
        }
    }

    public static void process() {
        System.out.println(dijkstra());
    }

    static int dijkstra() {
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[START] = 0;

        // dijkstra, 우선순위큐
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(START, 0));

        while (!que.isEmpty()) {
            // 현재 지점
            Node cur = que.poll();

            if(visited[cur.from])
                continue;

            visited[cur.from] = true;

            // 현재 지점에서 연결된 노드 탐색
            for(Node next : adj[cur.from]) {
                
                // 현재 지점에서 다음 지점까지의 거리 dp > 현재 지점까지의 거리 dp + 다음 지점까지의 거리
                if(distance[next.from] > distance[cur.from] + next.weight) 
                    distance[next.from] = distance[cur.from] + next.weight;

                que.add(new Node(next.from, distance[next.from]));
            }
        }

        return distance[N];
    }
}

class Node implements Comparable<Node> {
    int from;
    int weight;

    public Node(int f, int w) {
        from = f;
        weight = w;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}