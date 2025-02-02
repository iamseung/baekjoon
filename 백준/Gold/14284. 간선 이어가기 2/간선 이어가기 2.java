import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, S, T;
    static List<Node>[] adj;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 양방향
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
    }

    static void process() {
        int answer = dijkstra(S, T);
        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean[] visited = new boolean[N + 1];

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.from;

            if (cur == end)
                return curNode.weigth;

            if (visited[cur])
                continue;

            visited[cur] = true;

            for (Node node : adj[cur]) {
                if (dist[node.from] > dist[cur] + node.weigth) {
                    dist[node.from] = dist[cur] + node.weigth;
                    queue.add(new Node(node.from, dist[node.from]));
                }
            }
        }

        return -1;
    }
}

class Node implements Comparable<Node> {
    int from;
    int weigth;

    Node(int from, int weigth) {
        this.from = from;
        this.weigth = weigth;
    }

    @Override
    public int compareTo(Node o) {
        return weigth - o.weigth;
    }
}