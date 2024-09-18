import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M, S;
    static int[] dist;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

    }

    static void process() {
        for (int i = 1; i <= N; i++)
            Collections.sort(adj[i]);

        dist = new int[N + 1];
        int idx = 1;

        dist[S] = idx++;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (dist[next] != 0)
                    continue;

                dist[next] = idx++;
                queue.add(next);
            }
        }

        for (int i = 1; i <= N; i++)
            sb.append(dist[i]).append("\n");

        System.out.println(sb.toString());
    }
}