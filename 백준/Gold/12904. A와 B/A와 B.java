import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static String S,T;

    static void input() 
    {
        S = scan.nextLine(); T = scan.nextLine();
    }

    static void pro() 
    {
        // T의 길이가 S보다 작아질 경우 종료
       while(T.length() >= S.length())
       {
            // 마지막 글자 확인
            if(T.charAt(T.length()-1) == 'A')
            {
                // 마지막 글자인 A제거 
                T = T.substring(0, T.length()-1);
            }
            else if(T.charAt(T.length()-1) == 'B')
            {
                // 마지막 글자인 B제거 후, 문자열 reverse
                T = T.substring(0, T.length()-1);
                StringBuffer sb = new StringBuffer(T);
                T = sb.reverse().toString();
            }

            if(T.equals(S))
            {
                System.out.println(1);
                return;
            }
       }
       System.out.println(0);
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