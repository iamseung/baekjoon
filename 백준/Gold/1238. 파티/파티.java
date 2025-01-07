import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M,X;
    static final int INF = 100_000;
    static List<Node>[] adj, reverseAdj;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        reverseAdj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }

        int u,v,e;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, e));
            reverseAdj[v].add(new Node(u, e));
        }
    }

    public static void process(){
        // 각각의 노드에서 X 까지의 최단 거리는 반대 값으로 다익스트라
        int[] NodeToX = dijkstra(X, reverseAdj);
        int[] XToNode = dijkstra(X, adj);

        int max = 0;
        for(int i=1; i<=N; i++)
            max = Math.max(NodeToX[i] + XToNode[i], max);
        
        System.out.println(max);
    }

    static int[] dijkstra(int start, List<Node>[] road) {
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            int cur = curNode.end;

            if(visited[cur])
                continue;

            visited[cur] = true;

            for(Node next : road[cur]) {
                if(dist[next.end] > dist[cur] + next.weight) {
                    dist[next.end] = dist[cur] + next.weight;
                }

                que.add(new Node(next.end, dist[next.end]));
            }
        }

        return dist;
    }
}

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int e, int w) {
        end = e;
        weight =w;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}