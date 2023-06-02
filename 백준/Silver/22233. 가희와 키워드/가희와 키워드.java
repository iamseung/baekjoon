import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, cnt;
    static HashMap<String, Boolean> words = new HashMap<>();

    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt(); cnt = N;
        while(N-->0) words.put(scan.nextLine(), true);
    }

    static void pro()
    {
        while(M-- > 0)
        {
            st = new StringTokenizer(scan.nextLine(), ",");
            while(st.hasMoreTokens())
            {
                String w = st.nextToken();
                if(words.containsKey(w))
                {
                    words.remove(w);
                    cnt--;
                }
            }

            sb.append(words.size()+"\n");
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