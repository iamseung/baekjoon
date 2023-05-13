import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, cnt;
    static int[][] area;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static ArrayList<Integer> P = new ArrayList<>();
    
    static void input() 
	{
        N = scan.nextInt(); M = scan.nextInt();
        area = new int[N][M];
        visit = new boolean[N][M];

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
        int ans = 0;
		for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(area[i][j] == 1 && !visit[i][j])
                {
                    cnt = 0;
                    dfs(i,j);
                    P.add(cnt);
                    ans = Math.max(cnt, ans);
                }
            }
        }
        
        System.out.println(P.size());
        System.out.println(ans);
        
	}

    static void dfs(int x, int y)
    {
        visit[x][y] = true;
        cnt++;
        for(int k=0;k<4;k++)
        {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(visit[nx][ny]) continue;
            if(area[nx][ny] == 0) continue;

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