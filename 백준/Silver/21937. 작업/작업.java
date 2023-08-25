import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,target,C;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        int a,b;
        while(M-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 역방향으로 연결
            adj[b].add(a);
        }

        target = Integer.parseInt(br.readLine());
    }

    public static void process() {
        DFS(target);

        System.out.println(C);
    }

    public static void DFS(int start) {
        visit[start] = true;

        for(int k : adj[start]) {
            if(visit[k]) continue;

            C++;
            DFS(k);
        }
    
    }
}