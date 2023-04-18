import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static long A, B;

    static void input() 
    {
        A = scan.nextLong();
        B = scan.nextLong();
    }

    static void pro() 
    {
        int cnt = 1;

        while(A < B)
        {
            if(B%10 == 1) // 끝자리가 1이면 
            { 
                B /= 10;
            }
            else if(B%2 == 0) // 2로 나눌 수 있으면
            {
                B /= 2;
            }
            else
            {
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
        }
        if(A != B)
            System.out.println(-1);
        else
            System.out.println(cnt);
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