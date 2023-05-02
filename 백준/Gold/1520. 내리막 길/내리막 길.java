import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{0,1},{1,0},{-1,0}, {0,-1}};
    static int[][] area, dp;
    static boolean[][] visit;
    static int N, M, cnt=0;

    static void input() 
    {
        N = scan.nextInt();
        M = scan.nextInt();

        area = new int[N][M];
        dp   = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                area[i][j] = scan.nextInt();
                dp[i][j] = -1; // 메모제이션과 구분하기 위해 -1로 초기화
            }
        }
    }

    static void pro() 
    {
        
        System.out.println(dfs(0,0));
    }

    static int dfs(int x, int y)
    {
        // 끝점에 도달한 경우 1을 반환
        if(x==N-1 && y==M-1)
        {
            return 1;
        }

        // 방문한 적이 있다면 dp 값을 반환, 종료시간 단축
        if(dp[x][y] != -1) return dp[x][y];

        // 방문한 경우 0으로 초기화, -1은 방문하지 않은!
        dp[x][y] = 0;

        for(int k=0; k<4; k++)
        {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            // 예외처리
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(area[x][y] <= area[nx][ny]) continue;

            dp[x][y] += dfs(nx, ny);
        }
        
        return dp[x][y];
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