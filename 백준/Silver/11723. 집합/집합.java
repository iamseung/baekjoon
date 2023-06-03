import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static boolean[] list = new boolean[21];

    static void input() 
    {
        N = scan.nextInt();
    }

    static void pro()
    {   
        while(N-->0)
        {
            st = new StringTokenizer(scan.nextLine());
            String cal = st.nextToken();
            int V = -1;
            if(st.hasMoreTokens()) V = Integer.parseInt(st.nextToken());

            switch(cal)
            {
                case "add" :
                    list[V] = true;
                    break;
                case "remove" :
                    list[V] = false;
                    break;
                case "check" :
                    if(list[V])
                        sb.append("1"+"\n");
                    else
                        sb.append("0"+"\n");
                    break;
                case "toggle" :
                    list[V] = !list[V];
                    break;
                case "all" :
                    for(int i=1; i<=20; i++) list[i] = true;
                    break;
                case "empty" :
                    for(int i=1; i<=20; i++) list[i] = false;
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