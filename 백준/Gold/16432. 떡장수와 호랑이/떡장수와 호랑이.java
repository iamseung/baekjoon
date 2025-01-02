import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Integer>[] riceCakes;
    static int[] result;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        riceCakes = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            riceCakes[i] = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            while (cnt-- > 0) {
                riceCakes[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    public static void process(){
        visited = new boolean[N+1][10];
        result = new int[N+1];
        DFS(1);
        System.out.println(-1);
    }

    static void DFS(int depth) {
        if(depth == N+1) {
            StringBuilder sb = new StringBuilder();
            for(int r=1; r<=N; r++)
                sb.append(result[r]).append("\n");
            
            System.out.println(sb.toString());
            System.exit(0);
        }

        for(int next : riceCakes[depth]) {
            if(next == result[depth-1] || visited[depth][next])
                continue;

            visited[depth][next] = true;
            result[depth] = next;
            DFS(depth+1);
        }
    }
}