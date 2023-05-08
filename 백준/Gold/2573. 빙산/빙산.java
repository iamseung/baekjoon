import java.io.*;
import java.util.*;

import javax.naming.spi.StateFactory;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int N, M;
    static int[][] area,dist;
    static boolean[][] visit;

    static void input() 
    {
        N = scan.nextInt();
        M = scan.nextInt();
        area = new int[N][M];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                area[i][j] = scan.nextInt();
            }
        }
    }

	static void pro() 
    {
        int cnt = 0;
        int ans = 0;

        // 빙산의 개수가 2개 이상이 될 때 까지 녹이는 작업을 반복
        while((cnt = iceCount()) < 2)
        {
            // 전부다 녹은 경우
            if(cnt == 0)
            {
                ans = 0;
                break;
            }
            
            // 빙산을 녹이는 BFS
            bfs();
            ans++;
        }

        System.out.println(ans);
    }

    // 빙산의 갯수를 카운트
    static int iceCount()
    {
        visit = new boolean[N][M];

        int cnt = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(area[i][j] != 0 && !visit[i][j])
                {
                    // 호출될 때마다 빙산의 개수 + 1
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // DFS
    static void dfs(int x, int y) 
    {
        visit[x][y] = true;

        for(int k=0;k<4;k++)
        {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=N || ny>= M) continue;
            if(visit[nx][ny]) continue;
            if(area[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

    static void bfs() 
    {
        Queue<Integer> Q = new LinkedList<>();

        boolean[][] visit = new boolean[N][M];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(area[i][j] != 0)
                {
                    visit[i][j] = true;
                    Q.add(i);
                    Q.add(j);
                }
            }
        }

        while(!Q.isEmpty())
        {
            int x = Q.poll();
            int y = Q.poll();

            int minusNum = 0;

            for(int k=0;k<4;k++)
            {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                // 범위에 대한 예외처리
                if(nx<0 || ny<0 || nx>=N || ny>= M) continue;
                if(visit[nx][ny]) continue;
                // 바닷물과 인접해 있는 경우
                if(area[nx][ny] == 0) minusNum++;
            }

            if(area[x][y] - minusNum < 0)
                area[x][y] = 0;
            else
                area[x][y] -= minusNum;
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