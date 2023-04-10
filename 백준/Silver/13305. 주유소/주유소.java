import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] L, O;
    
    static void input() 
    {
        N = scan.nextInt();
        L = new int[N];
        O = new int[N+1];
        // 주유소와 주유소간의 거리
        for(int i=1; i<N; i++) L[i] = scan.nextInt();

        // 주유소의 가격
        for(int i=1; i<=N; i++) O[i] = scan.nextInt();
    }

    /*
     * 현재 주유소 가격 > 다음 주유소 가격 => 현재에서 최소 길이 만큼의 기름만 주유
     * 현재 주유소 가격 < 다음 주유소 가격 => 다음 주유소 길이만큼도 주유
     */
    static void pro() 
    {
        long price = 0;

        for(int i=1; i<N;)
        {
            int j = i + 1;
            long cm = L[i];

            for(;j<N; j++)
            {
                // 현재 주유소 가격 > 다음 주유소 가격
                // : 최소 길이만큼만 주유
                if(O[i] > O[j]) break;

                // 현재 주유소 가격 < 다음 주유소 가격
                // 더 싼 주유소가 나오기 전까지의 길이 축적
                cm += L[j];
            }

            // 정산
            price += cm * O[i];

            i = j;
        }

        System.out.println(price);
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