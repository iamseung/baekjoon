import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M,S;
    static ArrayList<Integer>[] adj;
    static int[] visit;
    public static void main (String[] args) throws IOException  {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 점정의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        S = Integer.parseInt(st.nextToken()); // 시작 좌표

        adj = new ArrayList[N+1];
        visit = new int[N+1];

        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
            visit[i] = -1;
        }

        int a,b;
        while(M-- >0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    public static void process() {
        // 오름차순 정렬
        for(int i=1; i<=N; i++) Collections.sort(adj[i], Collections.reverseOrder());

        DFS(S, 0);

        for(int i=1; i<=N; i++) sb.append(visit[i]+"\n");

        System.out.println(sb.toString());
    }

    public static void DFS(int start, int depth) {
        visit[start] = depth;

        for(int k : adj[start]) {
            // 방문한 적이 있다면 pass
            if(visit[k] != -1) continue;

            DFS(k, depth+1);
        }

    }
}