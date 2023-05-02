import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int M,N,K, ans;
    static boolean[][] area;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static void input() 
    {
       M = scan.nextInt();
       N = scan.nextInt();
       K = scan.nextInt();

       area = new boolean[M][N];
       while(K-- > 0)
       {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            for(int i=y1; i<y2; i++)
            {
                for(int j=x1; j<x2; j++)
                {
                    area[i][j] = true;
                }
            }
       }
    }

    static void pro() 
    {
        for(int i=0; i<M; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(!area[i][j])
                {
                    ans = 0;
                    dfs(i,j);
                    list.add(ans);
                }
            }
        }

        sb.append(list.size()+"\n");
        Collections.sort(list);
        for(int k: list)
        {
            sb.append(k+" ");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int x, int y)
    {
        area[x][y] = true;
        ans++;
        for(int k=0; k<4; k++)
        {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(area[nx][ny]) continue;

            dfs(nx, ny);
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