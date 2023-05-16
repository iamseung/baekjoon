import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] res;

    static void input() 
    {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        res = new int[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        while(M-- >0)
        {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
        }
        
    }

	static void pro() 
    {  
        int max = 0;
        
        for(int i=1; i<=N; i++) bfs(i);
        
        for(int i=1; i<=N; i++) max = Math.max(res[i], max);    

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++)
        {
            if(res[i] == max) list.add(i);
        }

        Collections.sort(list);

        for(int k: list) sb.append(k+" ");
        System.out.println(sb);
	}

    static void bfs(int x)
    {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        boolean[] visit = new boolean[N+1];
        visit[x] = true;

        while(!Q.isEmpty())
        {
            int k = Q.poll();
            
            for(int y : adj[k])
            {
                if(visit[y]) continue;

                Q.add(y);
                visit[y] = true;
                res[y]++;
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