import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr, expect, parent;
    static boolean[] visit;
    static String ANS;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        visit = new boolean[N+1];
        expect = new int[N+1];
        parent = new int[N+1];

        StringTokenizer st;
        int A,B;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            // 양방향 연결
            adj[A].add(B);
            adj[B].add(A);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            expect[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void process() {
        DFS(1, 0);

        System.out.println(1);
    }

    public static void DFS(int current, int index) {
        visit[current] = true;

        // 현재 값 뒤에 나올 수 있는 값들에 대한 정보를 저장.
        int count = 0;
        for (int nextCandidate : adj[current]) {
            if (!visit[nextCandidate]) {
                visit[nextCandidate] = true;
                parent[nextCandidate] = current;
                count++;
            }
        }

        index++;
        for (int i = 0; i < count; i++) {
            int next = expect[index];
            if (parent[next] != current) {
                System.out.println(0);
                System.exit(0);
            }
            DFS(next, index);
        }
    }
}