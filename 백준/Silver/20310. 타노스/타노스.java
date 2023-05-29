import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int one, two;

    static void input() 
    {
        String str = scan.nextLine();
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) == '0')
                one++;
            else
                two++;
        }
    }

	static void pro() 
    {   
        one /= 2; two /= 2;
        while(one-- > 0)
        {
            sb.append("0");    
        }

        while(two-- > 0)
        {
            sb.append("1");    
        }

        System.out.println(sb);
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