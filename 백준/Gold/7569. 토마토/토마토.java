import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, H;
    static int[][][] dist, area;
	static int[][] dir = { {1,0,0,},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1}, {0,0,-1} };
    // static int[][] dir = {{-1,-2,0},{-2,-1,0},{-1,2,0},{-2,1,0},{0,0,-1},{0,0,1}};
    
    static void input() 
	{
        M = scan.nextInt();
		N = scan.nextInt();
		H = scan.nextInt();

		area = new int[H][N][M];
		dist = new int[H][N][M];

		for(int i=0;i<H;i++){
			for(int j=0;j<N;j++){
				for(int l=0;l<M;l++){
					area[i][j][l] = scan.nextInt();
				}
			}
		}        
    }

	static void bfs()
	{
		Queue<Integer> Q = new LinkedList<>();

		for(int i=0;i<H;i++){
			for(int j=0;j<N;j++){
				for(int l=0;l<M;l++){
					// NO 방문
					dist[i][j][l] = -1;
					// 토마토가 있다면
					if(area[i][j][l] == 1)
					{
						dist[i][j][l] = 0;
						Q.add(i);
						Q.add(j);
						Q.add(l);
					}
				}
			}
		}

		while(!Q.isEmpty())
		{
			int i = Q.poll();
			int j = Q.poll();
			int l = Q.poll();
			for(int k=0;k<6;k++)
			{
				int ni = i + dir[k][0];
				int nj = j + dir[k][1];
				int nl = l + dir[k][2];

				// 범위 예외처리
				if(ni<0 || nj<0 || nl<0 || ni>=H || nj>=N || nl >= M) continue;
				// 방문한 적이 있다면
				if(dist[ni][nj][nl] != -1) continue;
				// 울타리에 막혀있다면
				if(area[ni][nj][nl] == -1) continue;

				dist[ni][nj][nl] = dist[i][j][l] + 1;
				Q.add(ni); Q.add(nj); Q.add(nl);
			}
		}
	}

	static void pro()
	{
		int ans = Integer.MIN_VALUE;
		bfs();
		for(int i=0;i<H;i++){
			for(int j=0;j<N;j++){
				for(int l=0;l<M;l++){
					// 울타리면 pass
					if(area[i][j][l] == -1) continue;
					// 울타리를 제외한 공간에 방문한 적이 없다면 
					// 울타리에 막혀서 토마토가 접근할 수 없다는 것을 의미
					if(dist[i][j][l] == -1){
						System.out.println(-1);
						return;
					} 
					ans = Math.max(ans, dist[i][j][l]);
				}
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