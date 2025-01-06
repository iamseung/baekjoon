import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,E,A,B;
    static List<Node>[] adj;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            adj[i] = new ArrayList<>();

        int u,v,e;
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, e));
            adj[v].add(new Node(u, e));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    // 1 -> N 으로
    public static void process(){
        // 1 -> A -> B -> N
        int ABN = 0;
        ABN += dijkstra(1, A);
        ABN += dijkstra(A, B);
        ABN += dijkstra(B, N);

        // 1 -> B -> A -> N
        int BAN = 0;
        BAN += dijkstra(1, B);
        BAN += dijkstra(B, A);
        BAN += dijkstra(A, N);

        int ans = (ABN >= INF || BAN >= INF) ? -1 : Math.min(ABN, BAN);

        System.out.println(ans);
    }

    static int dijkstra(int start, int end) {
        boolean[] visitied = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if(visitied[cur.from])
                continue;
            
            visitied[cur.from] = true;

            for(Node next : adj[cur.from]) {
                if(visitied[next.from])
                    continue;

                if(dist[next.from] > dist[cur.from] + next.weight)
                    dist[next.from] = dist[cur.from] + next.weight;

                que.add(new Node(next.from, dist[next.from]));
            }
        }

        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int from;
    int weight;

    Node(int f, int w) {
        from = f;
        weight = w;
    }

    @Override
    public int compareTo(Node other) {
        return weight - other.weight;
    }
}