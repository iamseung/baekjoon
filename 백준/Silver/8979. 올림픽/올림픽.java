import java.io.*;
import java.util.*;

public class Main 
{
    static class Con implements Comparable<Con>
    {
        int f;
        int s;
        int t;
    
        Con(int F, int S, int T)
        {
            this.f = F;
            this.s = S;
            this.t = T;
        }
    
        @Override
        public int compareTo(Con other) {
            
            if(f == other.f)
                return other.s - s;
            if(s == other.s)
                return other.t - t;
            return other.f - f;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static Con[] list;
    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();
        list = new Con[N+1];
        for(int i=1; i<=N; i++)
        {
            list[scan.nextInt()] = new Con(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }
    }

	static void pro() 
    {  
        int index = 2;
        int[] result = new int[N+1];
        result[1] = 1;
        for(int i=2; i<=N; i++)
        {
            // 이전 나라와 메달 획득률이 동일하다면
            if(list[i].f == list[i-1].f && list[i].s == list[i-1].s && list[i].t == list[i-1].t)
                result[i] = result[i-1];
            else
                result[i] += index;

            index++;
        }

        System.out.println(result[M]);
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