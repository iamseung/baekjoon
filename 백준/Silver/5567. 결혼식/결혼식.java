import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

    static void input() 
	{
		N = scan.nextInt();
		M = scan.nextInt();
		visit = new boolean[N+1];
		adj = new ArrayList[N+1];

		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

		while(M-- >0)
		{
			int x = scan.nextInt();
			int y = scan.nextInt();

			adj[x].add(y);
			adj[y].add(x);
		}
    }

	static void pro()
	{
		visit[1] = true;
		// adj[1] -> 상근이 친구들
		for(int s : adj[1])
		{
			// visit[s] = true;
			bfs(s);
		}

		int cnt = 0;

		for(int i=2; i<=N; i++)
		{
			if(visit[i]) cnt++;
		}

		System.out.println(cnt);
	}

	static void bfs(int x)
	{
		visit[x] = true;
		Queue<Integer> q = new LinkedList<>();

		q.add(x);

		while(!q.isEmpty())
		{
			int qx = q.poll();

			for(int qs : adj[qx])
			{
				if(!visit[qs]) visit[qs] = true; 
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