import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static boolean[][] visit;
    static int N;
    static String[][] area;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    // static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};

    static void input() 
    {
        N = scan.nextInt();
        area = new String[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++)
        {
            String str = scan.nextLine();
            for(int j=0; j<N; j++) area[i][j] = String.valueOf(str.charAt(j));
        }
    }

    static void pro() 
    {
        int cnt1 = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(!visit[i][j])
                {
                    cnt1++;
                    dfs(i,j, area[i][j]);
                }
            }
        }
     
        sb.append(cnt1+" ");

        // Green -> Red
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(area[i][j].equals("G"))
                {
                    area[i][j] = "R";
                }
            }
        }

        visit = new boolean[N][N];
        int cnt2 = 0;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(!visit[i][j])
                {
                    cnt2++;
                    dfs(i,j, area[i][j]);
                }
            }
        }
        
        sb.append(cnt2);
    }

    static void dfs(int x, int y, String ele)
    {
        visit[x][y] = true;
        for(int k=0; k<4; k++)
        {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(visit[nx][ny]) continue;
            if(!area[nx][ny].equals(ele)) continue;

            dfs(nx, ny, ele);
        }
    }

    public static void main(String[] args) 
    {
        input();
        pro();
        
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