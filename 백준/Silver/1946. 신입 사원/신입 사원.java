import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static int[] rank;

    static void input() 
    {
        T = scan.nextInt();

        while(T-- > 0)
        {
            N = scan.nextInt();
            rank = new int[N+1];

            for(int i=1; i<=N; i++)
            {
                StringTokenizer st = new StringTokenizer(scan.nextLine(), " ");
    
                rank[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            pro();
        }    

        System.out.println(sb);
    }

    static void pro() 
    {
        int cnt = 1, min = rank[1];

        for(int i=2; i<= N; i++)
        {
            if(min < rank[i]) continue;

            min = rank[i];
            cnt++;
        }

        sb.append(cnt+"\n");
    }

    public static void main(String[] args) 
    {
        input();
        // pro();
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

        String nextLine() 
        {
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