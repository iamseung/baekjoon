import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static Queue<Integer> Q = new LinkedList<>();

    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();
        for(int i=1; i<=N; i++) Q.offer(i);
    }

    static void pro()
    {  
        sb.append("<");

        while(Q.size() != 1)
        {
            for(int i=0; i<M-1; i++) Q.offer(Q.poll());

            sb.append(Q.poll()+", ");
        }

        sb.append(Q.poll()+">");

        System.out.println(sb.toString());
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