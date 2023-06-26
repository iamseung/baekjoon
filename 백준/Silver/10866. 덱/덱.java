import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static Deque<Integer> Q;

    static void input() 
    {
        N = scan.nextInt();
    }

    static void pro()
    {
        Q = new LinkedList<>();

        while(N-- >0)
        {
            String[] s= scan.nextLine().split(" ");

            switch(s[0])
            {
                case "push_back" :
                    Q.offerLast(Integer.parseInt(s[1]));
                    break;
                case "push_front" :
                    Q.offerFirst(Integer.parseInt(s[1]));
                    break;
                case "pop_front" :
                    if(Q.peekFirst() == null)
                        sb.append("-1\n");
                    else
                        sb.append(Q.pollFirst()+"\n");
                    break;
                case "pop_back" :
                    if(Q.peekLast() == null)
                        sb.append("-1\n");
                    else
                        sb.append(Q.pollLast()+"\n");
                    break;
                case "size" :
                    sb.append(Q.size()+"\n");
                    break;
                case "empty" :
                    if(Q.size() == 0)
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                break;
                case "front" :
                    if(Q.peekFirst() == null)
                        sb.append("-1\n");
                    else
                        sb.append(Q.peekFirst()+"\n");
                break;
                case "back" :
                    if(Q.peekLast() == null)
                        sb.append("-1\n");
                    else
                        sb.append(Q.peekLast()+"\n");
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