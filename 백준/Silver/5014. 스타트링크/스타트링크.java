import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int F, S, G, U, D;
    static int[] dist;

    static void input() 
    {
        F = scan.nextInt(); // 총 F층
        S = scan.nextInt(); // 강호가 있는 곳
        G = scan.nextInt(); // 목표
        U = scan.nextInt(); // 위로
        D = scan.nextInt(); // 아래로

        dist = new int[F+1];
    }

	static void pro() 
    {
       bfs(S);
       if(dist[G] == -1)
            System.out.println("use the stairs");
        else
            System.out.println(dist[G]);
    }

    static void bfs(int start)
    {
        for(int i=1;i<=F;i++) dist[i] = -1;

        dist[start] = 0;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);

        while(!Q.isEmpty())
        {
            int x = Q.poll();

            if(x+U <= F && dist[x+U] == -1)
            {
                Q.add(x+U);
                dist[x+U] = dist[x] + 1;
            }

            if(x-D > 0 && dist[x-D] == -1)
            {
                Q.add(x-D);
                dist[x-D] = dist[x] + 1;
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