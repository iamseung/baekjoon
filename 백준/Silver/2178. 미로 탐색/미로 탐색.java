import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] dist;
    static char[][] area;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();
        area = new char[N][M];
        dist = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = scan.nextLine();
            for(int j=0; j<M; j++) {
                area[i][j] = str.charAt(j);
            }
        }
    }

	static void pro()
	{
		bfs();
        System.out.println(dist[N-1][M-1]);
	}

    static void bfs()
    {
        // init
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        
        dist[0][0] = 1;
        Q.add(0);
        Q.add(0);

        while(!Q.isEmpty())
        {
            int x = Q.poll();
            int y = Q.poll();

            for(int k=0;k<4;k++)
            {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                // 좌표에 대한 예외처리
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                // 방문한 곳에 대한 예외처리
                if(dist[nx][ny] != -1) continue;
                // 갈 수 있는 곳에 대한 예외처리
                if(area[nx][ny] == '0') continue;

                Q.add(nx);
                Q.add(ny);

                dist[nx][ny] = dist[x][y] + 1;
            }
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