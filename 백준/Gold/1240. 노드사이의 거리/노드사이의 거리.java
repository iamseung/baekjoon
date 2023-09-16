import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static ArrayList<int[]>[] adj;
    static int[][] target;
    static boolean[] visit;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 개수
        M = Integer.parseInt(st.nextToken()); // 타겟의 개수

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        int A,B,C;
        for(int j=0; j<N-1; j++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            adj[A].add(new int[]{B,C});
            adj[B].add(new int[]{A,C});
        }

        target = new int[M][2];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            target[i][0] = A;
            target[i][1] = B;
        }
        
    }

    public static void process() {
        int start, end;
        for(int[] T : target) {
            start = T[0];
            end = T[1];

            visit = new boolean[N+1];
            DFS(start,end,0);
        }

        System.out.println(sb.toString());
    }

    public static void DFS(int start, int end, int depth) {
        if(start == end) {
            sb.append(depth+"\n");
            return;
        }

        visit[start] = true;

        int next, length;
        for(int[] k : adj[start]) {
            next = k[0];
            length = k[1];

            if(visit[next]) continue;

            DFS(next, end, depth + length);
        }
    }
}