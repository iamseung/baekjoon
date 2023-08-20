import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,M,R,index=1;
    static ArrayList<Integer>[] adj;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1]; // 자식, 부모 노드
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        visit = new int[N+1]; // 노드 별 방문 기록

        int x,y;
        while(M-- >0) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
    }
    
    public static void process() {
        // 내림차순 정렬
        for(int i=1; i<=N; i++) Collections.sort(adj[i], Collections.reverseOrder());

        DFS(R);
        
        for(int i=1; i<=N; i++) sb.append(visit[i]+"\n");
        System.out.println(sb.toString());
    }

    public static void DFS(int start) {
        visit[start] = index;
        index++;
        for(int k : adj[start]) {
            // 방문한 적이 있으면 패스
            if(visit[k] != 0) continue;

            DFS(k);
        }
    }

}