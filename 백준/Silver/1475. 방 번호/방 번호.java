import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String N;
    static int[] arr;

    static void input() 
    {
        N = scan.nextLine();
    }

    static void pro()
    {
        arr = new int[10];

        // 6->9로 변환
        N = N.replace('6', '9');

        for (char ch : N.toCharArray()) arr[ch-48]++;

        int curCnt = 0, max = 0;

        for(int i=0; i<10; i++)
        {
            curCnt = arr[i];

            if(i == 9)
            {
                curCnt = (int) Math.round(arr[9] / 2.0);
            }
            
            if(curCnt > max)
            {
                max = curCnt;
            }
        }

        System.out.println(max);
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