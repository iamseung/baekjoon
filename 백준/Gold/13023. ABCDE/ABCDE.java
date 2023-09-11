import java.util.*;
import java.io.*;

public class Main {
    static int N,M,ANS=0;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        visit = new boolean[N];
        for(int i=0; i<N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int j=0; j<M; j++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i=0; i<N; i++) {
            if(ANS == 0) DFS(i,1);
        }

        System.out.println(ANS);
    }

    static void DFS(int start, int depth) {
        if(depth == 5) {
            ANS = 1;
            return;
        }

        visit[start] = true;

        for(int k : adj[start]) {
            if(!visit[k]) DFS(k, depth + 1);
        }

        visit[start] = false;
    }
}