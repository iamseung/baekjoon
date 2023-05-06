import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] dist;
    static boolean[] visit;
    
    static void input() 
    {
        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int[100005];
        visit = new boolean[100005];
    }

	static void pro()
	{
		bfs();
        System.out.println(dist[K]);
	}

    static void bfs()
    {
        Queue<Integer> Q = new LinkedList<>();

        Q.add(N);           // 시작좌표 Insert
        visit[N] = true;    // 시작좌표 방문 Check
        dist[N]  = 0;       // 제자리이기 때문에 0

        while(!Q.isEmpty())
        {
            int x = Q.poll();

            // 현재 좌표에서 -1 만큼의 좌표가 0보다 크고 방문하지 않은 경우
            if(x-1>=0 && !visit[x-1])
            {
                visit[x-1] = true;
                dist[x-1] = dist[x] + 1;
                Q.add(x-1);
            }
            // 현재 좌표에서 +1 만큼의 좌표가 100,000보다 작고 방문하지 않은 경우
            if(x+1<=100000 && !visit[x+1])
            {
                visit[x+1] = true;
                dist[x+1] = dist[x] + 1;
                Q.add(x+1);
            }
            // 현재 좌표에서 +1 만큼의 좌표가 100,000보다 작고 방문하지 않은 경우
            if(x*2<=100000 && !visit[x*2])
            {
                visit[x*2] = true;
                dist[x*2] = dist[x] + 1;
                Q.add(x*2);
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