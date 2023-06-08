import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, K;
    static String str, IN;

    static void input() 
    {
        N = scan.nextInt();
    }

    static void pro()
    {   
        Queue<Integer> Q = new LinkedList<>();

        while(N-- > 0)
        {
            str = scan.nextLine();
            st = new StringTokenizer(str);
            IN = st.nextToken();
            if(st.hasMoreTokens()) K = Integer.parseInt(st.nextToken());

            switch(IN) 
            {
                case "push":
                    Q.offer(K);
                    break;

                case "pop":
                    if(Q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(Q.poll()+"\n");
                    break;

                case "size":
                    sb.append(Q.size()+"\n");
                    break;

                case "empty":
                    if(Q.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append(0+"\n");
                    break;
                case "front":
                    if(Q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(Q.peek()+"\n");
                    break;
                case "back":
                    if(Q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(K+"\n");
                    break;
            }
            
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