import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A, selected;
    static int total;

    static void input() 
    {
        A = new int[10];
        selected = new int[8];
        for(int i=1; i<=9; i++)
        {
            A[i] = scan.nextInt();
            total += A[i];
        }
        
    }

    static void pro() 
    {
        Arrays.sort(A,1,10);
    }

    static void recF(int k)
    {
        if(k == 8)
        {
            int sum = 0;
            for(int i=1;i<=7;i++) sum += selected[i];

            if(sum == 100)
            {
                for(int T : selected)
                {
                    if(T == 0) continue;
                    sb.append(T).append("\n");
                }
                
                System.out.println(sb);
                System.exit(0);
            }
        }
        else
        {
            for(int cur=1; cur<=9; cur++)
            {
                boolean isUsed = false;

                for(int i=1; i<=k; i++)
                {
                    if(A[cur] == selected[i])
                    {
                        isUsed = true;
                        continue;
                    }
                }

                if(!isUsed)
                {
                    selected[k] = A[cur];

                    recF(k+1);
    
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        input();
        pro();
        recF(1);
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