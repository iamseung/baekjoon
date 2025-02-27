import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, Q;
    static ArrayList<int[]>[] adj;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            adj[p].add(new int[] { q, r });
            adj[q].add(new int[] { p, r });
        }
    }

    static void process() throws Exception {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // USADD
            int v = Integer.parseInt(st.nextToken()); // 타겟

            boolean[] visit = new boolean[N + 1];
            visit[v] = true;
            Queue<Integer> que = new LinkedList<>();
            que.add(v);

            int ans = 0;
            while (!que.isEmpty()) {
                int cur = que.poll();

                for (int[] a : adj[cur]) {
                    // USADD 가 K 이상인 동영상
                    if (!visit[a[0]] && a[1] >= k) {
                        que.add(a[0]);
                        visit[a[0]] = true;
                        ans++;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}