import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,MAX,node;
    static ArrayList<int[]>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
            
        StringTokenizer st;
        int from, to, value;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            from = Integer.parseInt(st.nextToken());

            while(true) {;
                if((to = Integer.parseInt(st.nextToken())) == -1) break;
                value = Integer.parseInt(st.nextToken());

                adj[from].add(new int[] {to,value});
            }
        }
    }

    public static void process() {
        // 임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        visit = new boolean[N+1];
        DFS(1,0);

        // node에서 부터 가장 먼 노트까지의 거리를 구한다
        visit = new boolean[N+1];
        DFS(node,0);

        System.out.println(MAX);
    }

    public static void DFS(int start, int weight) {
        if(weight > MAX) {
            MAX = weight;
            node = start;
        }

        visit[start] = true;

        for(int[] K : adj[start]) {
            if(visit[K[0]]) continue;

            DFS(K[0], weight + K[1]);
        }
    }
}
