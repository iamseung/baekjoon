import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ox, oy;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() 
    {
        N = scan.nextInt();
        adj = new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) adj[i] = new ArrayList<>();

        ox = scan.nextInt(); oy = scan.nextInt();

        M = scan.nextInt();
        while(M-- >0)
        {
            // 양방향 연결
            int x = scan.nextInt(); int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

	static void pro() 
    {
       bfs(ox);
       System.out.println(dist[oy]);
    }

    // start 에서 시작해서 갈 수 있는 모든 점점 탐색
    static void bfs(int start) 
    {
        Queue<Integer> Q = new LinkedList<>();
        dist = new int[N+1];
        for(int i=1; i<=N; i++) dist[i] = -1;
        
        Q.add(start);
        dist[start] = 0;

        while(!Q.isEmpty())
        {
            int x = Q.poll();

            for(int y : adj[x])
            {
                // 방문한 적이 있다면 pass
                if(dist[y] != -1) continue;

                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
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