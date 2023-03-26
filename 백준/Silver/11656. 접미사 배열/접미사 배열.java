import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] D;

    static void input() 
    {
        // 입력을 받고 , 수의 길이를 N으로 init
        String str = scan.nextLine();
        N = str.length(); D = new String[N];
        
        for(int i=0; i<N; i++) D[i] = str.substring(i,N);
    }

    static void pro() 
    {
       Arrays.sort(D);
       for(int i=0; i<N; i++)
       {
            System.out.println(D[i]);
       }
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