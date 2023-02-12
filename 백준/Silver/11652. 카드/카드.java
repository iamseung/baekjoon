import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] card;

    static void input() {
        N = scan.nextInt();
        card = new long[N + 1];
        for (int i = 1; i <= N; i++) 
        {
            card[i] = scan.nextLong();
        }
    }

    static void pro() 
    {
        // Sort
        Arrays.sort(card, 1, N+1);
        
        /*
         * mode, 최빈값
         * modeCnt, 최빈값의 등장 횟수
         * curCnt, 현재 값(card[1])의 등장 횟수
         */
        long mode = card[1];
        int modeCnt=1, curCnt =1;

        for(int i=2;i<=N;i++)
        {
            if(card[i] == card[i-1])
            {
                curCnt++;
            }
            else
            {
                curCnt = 1;
            }

            if(modeCnt < curCnt)
            {
                modeCnt = curCnt;
                mode = card[i];
            }
        }

        System.out.println(mode);
    }

    public static void main(String[] args) 
    {
        input();
        pro();
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