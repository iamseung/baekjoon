import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] map;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static final int INF = Integer.MAX_VALUE;
    static int idx = 1;

    public static void main(String[] args) throws Exception {
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            input();
            process();
        }

        System.out.println(sb.toString());
    }

    static void input() throws Exception {
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
        int cost = BFS();
        sb.append("Problem " + idx + ": " + cost + "\n");
        idx++;
    }

    static int BFS() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(0, 0, map[0][0]));

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], INF);

        dist[0][0] = map[0][0];

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int curX = cur.x, curY = cur.y;
            int curW = cur.weight;

            // 목표지점 도착
            if (curX == N - 1 && curY == N - 1) {
                return cur.weight;
            }

            for (int k = 0; k < 4; k++) {
                int nx = curX + dir[k][0];
                int ny = curY + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                // 최단 거리 갱신
                if (curW + map[ny][nx] < dist[ny][nx]) {
                    dist[ny][nx] = curW + map[ny][nx];
                    que.add(new Node(nx, ny, dist[ny][nx]));
                }
            }
        }

        return -1;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;

        Node(int X, int Y, int W) {
            x = X;
            y = Y;
            weight = W;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}