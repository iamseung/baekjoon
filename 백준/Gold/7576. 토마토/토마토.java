import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, H;
    static int[][] dist, area;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    static void input() 
	{
        M = scan.nextInt(); // 6
		N = scan.nextInt(); // 4

		area = new int[N][M];
		dist = new int[N][M];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                area[i][j] = scan.nextInt();
            }
        }
    }

	static void bfs()
	{
		Queue<Integer> Q = new LinkedList<>();

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // NO 방문
                dist[i][j] = -1;
                // 토마토가 있다면
                if(area[i][j] == 1)
                {
                    dist[i][j] = 0;
                    Q.add(i);
                    Q.add(j);
                }
            }
        }

		while(!Q.isEmpty())
		{
			int i = Q.poll();
			int j = Q.poll();

			for(int k=0;k<4;k++)
			{
				int ni = i + dir[k][0];
				int nj = j + dir[k][1];

				// 범위 예외처리
				if(ni<0 || nj<0 || ni>=N || nj>=M) continue;
				// 방문한 적이 있다면
				if(dist[ni][nj] != -1) continue;
				// 울타리에 막혀있다면
				if(area[ni][nj] == -1) continue;

				dist[ni][nj] = dist[i][j] + 1;
				Q.add(ni); Q.add(nj);
			}
		}
	}

	static void pro()
	{
		int ans = Integer.MIN_VALUE;
		bfs();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 울타리면 pass
                if(area[i][j] == -1) continue;
                // 울타리를 제외한 공간에 방문한 적이 없다면 
                // 울타리에 막혀서 토마토가 접근할 수 없다는 것을 의미
                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return;
                } 
                ans = Math.max(ans, dist[i][j]);
            }
        }
		System.out.println(ans);
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