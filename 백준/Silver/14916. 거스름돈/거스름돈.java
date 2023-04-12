import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] pay;
    static int[] gu = {25,10,5,1};
    
    static void input() 
    {
        N = scan.nextInt();
    }

    static void pro() 
    {
        int i = N / 5, sum = -1;
        
        while(i >= 0)
        {
            // 금액 - 5원을 낼 수 있는 개수
            int k = N - ( 5 * i );
            
            // 5원을 내고 남은 금액이 2원으로 지불 가능하다면
            if(k % 2 == 0)
            {
                sum = i + k/2;
                break;
            }

            i--;
        }

        System.out.println(sum);
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