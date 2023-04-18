import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static Long N, M;
    // 최소 우선 순위 큐
    static PriorityQueue<Long> q = new PriorityQueue<>();

    static void input() 
    {
        N = scan.nextLong();
        M = scan.nextLong();

        for(int i=1; i<=N; i++) q.add(scan.nextLong());
    }

    static void pro() 
    {
        while(M-- > 0)
        {
            // 제일 작은 요소 2개를 꺼내서
            long x = q.poll();
            long y = q.poll();

            // 2개 업데이트
            q.add(x+y);
            q.add(x+y);
        }

        long ans = 0;
        for(long k : q)
        {
            ans += k;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) 
    {
        input();
        pro();
    }

    static class FastReader 
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() 
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException 
        {
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