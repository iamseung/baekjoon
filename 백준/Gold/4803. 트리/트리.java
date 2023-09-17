import java.util.*;
import java.io.*;
import java.sql.Array;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int N,M,INDEX=1,vertexCNt,edgeCnt;

    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            input();
            prccess();
            INDEX++;
        }

        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        visit = new boolean[N+1];
        int A,B;
        int n = M;
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            // 양방향 연결
            adj[A].add(B);
            adj[B].add(A);
        }
    }

    public static void prccess() {
        int treeCnt = 0;
        
        for(int i=1; i<=N; i++) {
            if(visit[i]) continue;
            vertexCNt = 0;
            edgeCnt = 0;
            DFS(i);
            // 트리의 조건 => 간선(edge)는 정점(vertex)의 갯수 -1 이어야 한다.
            // 양방향 그래프로 *2 하여 비교!
            // 여기서 주의할 점은 연결되어 있는 간선이 없더라도 카운트!
            if(edgeCnt == (vertexCNt-1)*2) treeCnt++;
        }

        sb.append("Case ").append(INDEX).append(": ");
        if(treeCnt == 0) sb.append("No trees.");
        else if(treeCnt == 1) sb.append("There is one tree.");
        else sb.append("A forest of ").append(treeCnt).append(" trees.");
        sb.append("\n");
    }

    public static void DFS(int start) {
        vertexCNt++; // 정점 갯수 카운트
        edgeCnt += adj[start].size(); // 해당 정점에 연결된 간선의 수
        
        visit[start] = true;

        for(int Next : adj[start]) {
            if(visit[Next]) continue;

            DFS(Next);
        }
    }
}