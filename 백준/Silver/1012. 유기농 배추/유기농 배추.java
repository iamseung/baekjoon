import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static boolean[][] visit;
    static int T,M,N,K;
    static int[][] area;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static void input() 
    {
        M = scan.nextInt();  // 가로길이
        N = scan.nextInt();  // 세로길이
        K = scan.nextInt();  // 배추개수
        area  = new int[N][M];
        visit = new boolean[N][M];

        // 배추심기
        while(K-- >0)
        {
            int y = scan.nextInt();
            int x = scan.nextInt();
            area[x][y] = 1;
        }
    }

    static void pro() 
    {
        int cnt = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(area[i][j] == 1 && !visit[i][j])
                {
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        sb.append(cnt+"\n");
    }

    static void dfs(int x, int y)
    {
        visit[x][y] = true;

        for(int i=0; i<4; i++)
        {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(area[nx][ny] == 0) continue;
            if(visit[nx][ny]) continue;
            
            dfs(nx, ny);
        }
    }
    

    public static void main(String[] args) 
    {
        T = scan.nextInt();
        while(T-- > 0)
        {
            input();
            pro();
        }
        System.out.println(sb.toString());
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

        String nextLine() 
        {
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