import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int[][] area;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 상하좌우로 한칸씩 이동한 좌표를 비교하기 위함
    
    static void input() 
    {
        N     = scan.nextInt();
        area  = new int[N+1][N+1];
        

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
            {
                area[i][j] = scan.nextInt();
                if(!list.contains(area[i][j])) list.add(area[i][j]);
            }
        }
    }

    static void pro() 
    {
        int max = Integer.MIN_VALUE;

        for(int k : list)
        {
            int cnt = 0;
            visit = new boolean[N+1][N+1]; // 방문여부

            for(int i=1; i<=N; i++)
            {
                for(int j=1; j<=N; j++)
                {
                    if(area[i][j] >= k && !visit[i][j])
                    {
                        cnt++;
                        dfs(i,j, k);
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y, int k)
    {
        // 방문 표기
        visit[x][y] = true;

        for(int i=0; i<4; i++)
        {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            // 지도를 벗어나는 경우
            if(nx<0 || ny<0 || nx>N || ny>N) continue;
            // 안전 지역이 아닌 경우, 5미만
            if(area[nx][ny]<k) continue;
            // 이미 방문했으면 pass
            if(visit[nx][ny]) continue;

            dfs(nx, ny, k);
        }

    }

    public static void main(String[] args) 
    {
        input();
        pro();
    }

    static class FastReader 
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() 
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException 
        {
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