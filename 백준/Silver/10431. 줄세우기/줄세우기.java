import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int index;
    static int[] arr;
    static void input() 
    {
        index = scan.nextInt();
        arr = new int[20];
        for(int i=0; i<20; i++) arr[i] = scan.nextInt();
    }

	static void pro() 
    {  
        int res = 0;
        for(int i=1; i<20; i++)
        {
            for(int j= i-1; j>=0; j--)
            {
                if(arr[j] > arr[i]) res++;
            }
        }
        sb.append(index+" "+res+"\n");
	}

    public static void main(String[] args) 
    {
        int T = scan.nextInt();
        while(T-- > 0)
        {
            input();
            pro();
        }
        System.out.println(sb);
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