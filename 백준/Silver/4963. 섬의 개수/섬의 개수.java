import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static boolean[][] visit;
    static int W,H;
    static int[][] area;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};

    static void input() 
    {
        W = scan.nextInt();
        H = scan.nextInt();
        area = new int[H][W];
        visit = new boolean[H][W];
        for(int i=0; i<H; i++)
        {
            for(int j=0; j<W; j++)
            {
                area[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() 
    {
        int cnt = 0;
        for(int i=0; i<H; i++)
        {
            for(int j=0; j<W; j++)
            {
                if(!visit[i][j] && area[i][j] == 1)
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
        for(int k=0; k<8; k++)
        {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
            if(area[nx][ny] == 0) continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }
    

    public static void main(String[] args) 
    {
        while (true) {
            input();
            if (W == 0 && H == 0) break;
            pro();
        }
        System.out.println(sb);
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