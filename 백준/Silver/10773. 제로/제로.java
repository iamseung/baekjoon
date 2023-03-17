import java.util.*;
import java.io.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static Stack<Integer> stack;

    public static void main(String[] args)
    {
        input();
        pro();
    }

    static void input() 
    {
       N = scan.nextInt();
    }

    static void pro() 
    {
        int ans = 0;
        stack = new Stack<>();
        while(N--> 0)
        {
            int X = scan.nextInt();
            if(X == 0)
            {
                if(stack.size() != 0) stack.pop();
            }
            else
            {
                stack.push(X);
            }
        }

        for(int K : stack)
        {
            ans += K;
        }   

        System.out.println(ans);
    }

    static class FastReader 
    {
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