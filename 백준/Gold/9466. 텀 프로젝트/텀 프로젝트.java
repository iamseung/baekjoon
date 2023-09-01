import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, ANS;
    static int[] adj;
    static boolean[] visit;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            input();
            process();
        }

        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        adj = new int[N+1];
        visit = new boolean[N+1];
        finished = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) adj[i] = Integer.parseInt(st.nextToken());
    }

    public static void process() {
        ANS = 0;
        for(int i=1; i<=N; i++) DFS(i);
        sb.append(N-ANS+"\n");
    }

    public static void DFS(int start) {
        visit[start] = true;
        int next = adj[start];

        if(!visit[next]) {
            DFS(next);
        }
        else {
            if(!finished[next]) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야 한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                ANS++;
                while(next != start) {
                    ANS++;
                    next = adj[next];
                }
            }
        }

        finished[start] = true;
    }
}