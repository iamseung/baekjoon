import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V, E, ans;
    static int INF = 987654321;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

    public static void input() throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V+1][V+1];

        // init
        // INF 는 해당 노드에서 연결되는 노드가 없음을 의미
        // 자신에서 자신은 0
        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                if (i != j) {
                    graph[i][j] = INF;
                }
            }   
        }

        while(E-- >0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }
    }

    public static void pro() {
        // 플로이드 와샬
        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                for(int k=1; k<=V; k++) {
                    // jl -> lk = jk 이기 때문에 자기 자신임을 의미
                    if(j==k) continue;

                    // 최단거리 초기화
                    if(graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] =  graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        ans = INF;
        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                // 자기 자신을 제외한 두 정점이
                if(i == j) continue;
                // 서로에게 가는 경로가 있다면 사이클이 존재한다는 뜻!
                if(graph[i][j] != INF && graph[j][i] != INF) {
                    ans = Math.min(ans, graph[i][j] + graph[j][i]);
                }
            }
        }

        ans = (ans == INF) ? -1 : ans;
        System.out.println(ans);
    }
}