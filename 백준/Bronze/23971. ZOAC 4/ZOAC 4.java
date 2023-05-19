import java.io.*;
import java.util.*;


public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
   
    static int H,W,N,M;

    static void input() 
    {
       H = scan.nextInt();
       W = scan.nextInt();
       N = scan.nextInt();
       M = scan.nextInt();
    }

    static void pro()
    {
        int x = 0, y=0;
       if(W % (M+1) == 0)
       {
            x = W / (M+1);
       }
       else
       {
            x = W / (M+1) + 1;
       }

       if(H % (N+1) == 0)
       {
            y = H / (N+1);
       }
       else
       {
            y = H / (N+1) + 1;
       }
        
       System.out.println(x*y);
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