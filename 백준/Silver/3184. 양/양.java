import java.io.*;
import java.util.*;

import javax.naming.spi.StateFactory;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int R,C;
    static int Sheep,Fox,tSheep,tFox;
    static String[][] area;
    static boolean[][] visit;

    static void input() 
    {
        R = scan.nextInt(); C = scan.nextInt();
        area = new String[R][C];
        visit = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String str = scan.nextLine();
            for(int j=0; j<C; j++) {
                area[i][j] = String.valueOf(str.charAt(j));
            }
        }
    }

	static void pro()
	{
		for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(!area[i][j].equals("#") && !visit[i][j])
                {
                    tSheep = 0;
                    tFox = 0;
                    dfs(i,j);

                    if(tSheep == 0 && tFox == 0) continue;
                    
                    if(tSheep > tFox)
                        Sheep += tSheep;
                    else
                        Fox += tFox;
                }
            }
        }

        System.out.println(Sheep+" "+Fox);
	}

    static void dfs(int x, int y)
    {
        visit[x][y] = true;

        // 늑대면
        if(area[x][y].equals("v")) tFox += 1;
        // 양이면
        if(area[x][y].equals("o")) tSheep += 1;

        for(int k=0;k<4;k++)
        {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            // 범위 ?
            if(nx<0 || ny<0 || nx >=R || ny >=C) continue;
            // 울타리 ?
            if(area[nx][ny].equals("#")) continue;
            // 방문 ?
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void bfs()
    {
        
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