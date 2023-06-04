import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, dx, dy;
    static int[][] area, dist;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();
        area = new int[N][M];
        dist = new int[N][M];

        // 초기화
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j] = -1;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                area[i][j] = scan.nextInt();
                // 시작 좌표
                if(area[i][j] == 2)
                {
                    dx = i; 
                    dy = j;
                }

                if(area[i][j] == 0) dist[i][j] = 0;
            }
        }
    }

    static void pro()
    {   
        dfs();

        for(int i=0; i<N; i++) 
        {
            for(int j=0; j<M; j++) 
            {
                sb.append(dist[i][j]+" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }   

    static void dfs()
    {
        Queue<Integer> Q = new LinkedList<>();

        Q.offer(dx); Q.offer(dy);
        
        dist[dx][dy] = 0;

        while(!Q.isEmpty())
        {
            int x = Q.poll();
            int y = Q.poll();

            for(int k=0; k<4; k++)
            {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(dist[nx][ny] != -1) continue;
                if(area[nx][ny] == 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                Q.offer(nx); Q.offer(ny);
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