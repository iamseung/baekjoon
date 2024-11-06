import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int V, E, S;
    static int[][] adj;
    static final int INF = 987654321;

    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        dist = new int[V + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }
    }

    public static void process() {
        dijkstra();

        for (int i = 1; i <= V; i++)
            sb.append((dist[i] == INF) ? "INF" : dist[i]).append("\n");

        System.out.println(sb.toString());
    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        queue.add(new Node(S, 0));
        dist[S] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (check[cur])
                continue;

            check[cur] = true;

            // 연결된 지점 탐색
            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}