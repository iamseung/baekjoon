import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M,R,count;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        dist = new int[N+1];

        int x,y;
        while(M-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        // 오름차순
        for(int i=1; i<=N; i++) Collections.sort(adj[i]);
    }

    public static void pro(){
        count = 1;
        DFS(R);
        
        for(int i=1; i<=N; i++) sb.append(dist[i]+"\n");
        System.out.println(sb.toString());
    }

    public static void DFS(int start) {
        // 해당숫자는 index번에 방문하였다.
        dist[start] = count;

        for(int k : adj[start]) {
            if(dist[k] != 0) continue;
            count++;
            DFS(k);
        }
    }
}