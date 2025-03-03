import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, A, B, C;
    static List<int[]>[] adj;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 교차로 개수
        M = Integer.parseInt(st.nextToken()); // 골목 개수
        A = Integer.parseInt(st.nextToken()); // 시작 교차로 번호
        B = Integer.parseInt(st.nextToken()); // 도착 교차로 번호
        C = Integer.parseInt(st.nextToken()); // 가진 돈

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        int a, b, c;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[] { b, c });
            adj[b].add(new int[] { a, c });
        }
    }

    static void process() {
        visited = new boolean[N + 1];
        visited[A] = true;
        DFS(A, C, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 다음 도착지, 현재 금액, 최대 금액
    static void DFS(int target, int cost, int maxCost) {
        if (target == B) {
            answer = Math.min(answer, maxCost);
            return;
        }

        for (int[] next : adj[target]) {
            int nxt = next[0];
            int nxtcost = next[1];

            // 방문 했거나, 금액 부족
            if (visited[nxt] || cost - nxtcost < 0)
                continue;

            visited[nxt] = true;
            DFS(nxt, cost - nxtcost, Math.max(maxCost, nxtcost));
            visited[nxt] = false;
        }
    }
}