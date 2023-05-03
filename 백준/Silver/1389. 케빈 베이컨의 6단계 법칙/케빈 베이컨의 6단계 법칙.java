import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() 
    {
       N = scan.nextInt();
       M = scan.nextInt();
       adj = new ArrayList[N+1];

       for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

       for(int i=1; i<=M; i++)
       {
            int x = scan.nextInt();
            int y = scan.nextInt();
            // 양방향
            adj[x].add(y);
            adj[y].add(x);
       }
    }

    static void pro() 
    {
        dist = new int[N + 1];
        int minV = bfs(1), minIdx = 1;
        for (int i = 2; i <= N; i++) {
            int v = bfs(i);
            if (minV > v){
                minV = v;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }

    static int bfs(int start)
    {
        int ret = 0;
        Queue<Integer> que = new LinkedList<>();

        // 가지 않은 곳은 -1로 초기화
        for(int i=1; i<=N; i++) dist[i] = -1;
        // 들어온 좌표를 바로 insert 
        que.add(start);
        // 방문한 곳은 0으로 초기화, visit 과 같은 의미
        dist[start] = 0;

        while(!que.isEmpty())
        {
            // x = start
            int x = que.poll();
            
            ret += dist[x];

            for(int y : adj[x])
            {
                // 방문한 곳이라면 pass
                if(dist[y] != -1) continue; 

                que.add(y);
                // x 와 y 의 관계에서 y는 x까지의 연결 횟수에 +1을 해주면 된다
                dist[y] = dist[x] + 1;
            }
        }
        return ret;
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

        String next() 
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
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
            try          
            {
                str = br.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}