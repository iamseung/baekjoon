import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int N, LastA, LastB, ANS;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            input();
            prccess();
        }

        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        visit = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        int A,B;
        while(N-- > 1) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            // 역방향으로 연결
            adj[B].add(A);
        }

        st = new StringTokenizer(br.readLine());
        LastA = Integer.parseInt(st.nextToken());
        LastB = Integer.parseInt(st.nextToken());
    }

    public static void prccess() {
        DFS(LastA);
        FIND(LastB);
        sb.append(ANS+"\n");
    }

    public static void DFS(int start) {
        visit[start] = true;

        for(int next : adj[start]) {
            if(visit[next]) continue;

            DFS(next);
        }
    }

    public static void FIND(int start) {
        visit[start] = true;

        for(int next : adj[start]) {
            if(visit[next]) {
                ANS = next;
                return;
            }

            FIND(next);
        }
    }
}