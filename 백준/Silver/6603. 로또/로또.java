import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] arr, result;

    static void input() 
    {
        arr = new int[N];
        result = new int[N];
        for(int i=0; i<N; i++) arr[i] = scan.nextInt();
    }

    static void pro()
    {
        dfs(0,0);
    }

    static void dfs(int start, int depth)
    {
        if(depth == 6)
        {
            for(int i =0; i < N; i++) 
            {
                if(result[i] == 1)
                    sb.append(arr[i]+" ");
            }

            sb.append("\n");
        }

        for(int i=start; i<N; i++) 
        {
			result[i] = 1;
			dfs(i+1, depth+1);
			result[i] = 0;
		}
    }

    public static void main(String[] args) 
    {
        while(true)
        {
            N = scan.nextInt();
            if(N == 0)
            {
                System.out.println(sb);
                return;
            }
            input();
            pro();

            sb.append("\n");
        }
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