import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, MAX;
    static ArrayList<int[]>[] nodes;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        int M = N;
        // init
        nodes = new ArrayList[N+1];
        for(int i=1; i<=N; i++) nodes[i] = new ArrayList<>();

        StringTokenizer st;
        int a,b,c;

        while(M-->1) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            nodes[a].add(new int[]{b,c});
            nodes[b].add(new int[]{a,c});
        }
    }

    public static void process() {
        MAX = 0;

        for(int i=1; i<=N; i++) {
            visit =  new boolean[N+1];
            DFS(i,0);
        }

        System.out.println(MAX);
    }

    // index, cost
    public static void DFS(int from, int weight) {
        visit[from] = true;
        MAX = Math.max(weight, MAX);
        
        // 0 => index, 1 => weight
        for(int[] node : nodes[from]) {
            if(!visit[node[0]]) {
                visit[node[0]] = true;
                DFS(node[0], weight + node[1]);
            }
        }
    }
}