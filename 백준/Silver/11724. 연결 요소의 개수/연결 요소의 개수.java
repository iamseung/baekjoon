import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() 
    {
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N + 1]; // 인접 리스트
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            
            // 무방향 = 양방향, 서로의 ArrayList 에 값 insert
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) 
    {
        // x(정점) 를 방문했다.
        visit[x] = true;

        // x 에서 갈 수 있는 곳들을 작은 번호부터 모두 방문한다.
        for (int y : adj[x]) 
        {
            // y 를 이미 갈 수 있다는 사실을 안다면, 굳이 갈 필요 없다.
            if (visit[y]) continue;

            // y에서 갈 수 있는 곳들도 확인 해보자
            dfs(y);
        }
    }

    static void pro() 
    {
        visit = new boolean[N + 1]; // 정점에 대한 visit 여부를 체크하기 때문에 1차원 배열
        int ans = 0;
        for (int i = 1; i <= N; i++) 
        {
            // 이미 방문했으면 continue, 안했으면 탐색 시작
            if (visit[i]) continue;
            dfs(i);
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) 
    {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
