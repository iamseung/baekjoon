import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static List<Node>[] adj;
    static boolean[] visible;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for(int i=0; i<N; i++)
            adj[i] = new ArrayList<>();

        visible = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++)
            visible[i] = (Integer.parseInt(st.nextToken()) == 1) ? true : false;

        // visible[N-1] = false;
        
        int u,v,e;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());  
            e = Integer.parseInt(st.nextToken());

            // 양방향 매핑
            adj[u].add(new Node(v, e));
            adj[v].add(new Node(u, e));
        }
    }

    /*
     * visible true 이면 갈 수 없음
     * 0 부터 최단 거리를 계산한 후에 최단 거리를 체크하며 그 좌표에서 부터 이동
     */
    public static void process(){
        int start = 0;
        long distance = dijkstra(start);
        System.out.println((distance == INF) ? -1 : distance);
    }

    static long dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        long[] dist = new long[N];
        Arrays.fill(dist, INF); 
        dist[start] = 0;

        boolean[] visited = new boolean[N];
        que.add(new Node(start, 0));

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            int cur = curNode.end;

            if(visited[cur] || visible[cur])
                continue;

            visited[cur] = true;

            for(Node next : adj[cur]) {
                // 넥서스 예외처리
                if((next.end != N - 1) && visible[next.end])
                    continue;

                if(dist[next.end] > dist[cur]  + next.weight) 
                    dist[next.end] = dist[cur] + next.weight;

                que.add(new Node(next.end, dist[next.end]));
            }   
        }

        return dist[N-1];
    }
}

class Node implements Comparable<Node> {
    int end; 
    long weight;

    Node(int e, long w) {
        end = e;
        weight = w;
    }

    @Override
    public int compareTo(Node other) {
        if(this.weight - other.weight > 0)
            return 1; 
        return -1;
    }
}