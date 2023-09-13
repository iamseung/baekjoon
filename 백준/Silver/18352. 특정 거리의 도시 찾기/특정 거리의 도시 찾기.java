import java.util.*;
import java.io.*;

public class Main {
    static int N,M,K,X;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static ArrayList<Integer> ANS = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // init
        dist = new int[N+1];

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = -1;
        }
        

        int A,B;
        while(M-- >0) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
        }
        
        BFS();
    }

    public static void BFS() {
        Queue<Integer> Q = new LinkedList<>();

        // 출발도시, 거리 = 0
        dist[X] = 0;
        Q.add(X);

        while(!Q.isEmpty()) {
            int now = Q.poll();

            for(int next : adj[now]) {
                if(dist[next] != -1) continue;

                Q.add(next);
                dist[next] = dist[now] + 1;
            }
        }

        boolean pick = false;
        for(int i=1; i<=N; i++) {
            if(dist[i] == K) {
                System.out.println(i);    
                pick = true;
            }
        }

        if(!pick) {
            System.out.println(-1);
            return;
        }
    }
}