import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] dics;

    static void input() 
    {
        N = scan.nextInt(); dics = new String[N+1];
        for(int i=1; i<=N; i++) dics[i] = scan.nextLine();
    }

    static void pro() 
    {
        Arrays.sort(dics, 1, N+1, Collections.reverseOrder());
        
        int curCnt = 1; // 현재 수의 최빈 값
        int mostCnt = 1; // 최빈
        String mode = dics[1]; // 최빈 값
        
        for(int i=2; i<=N; i++)
        {
            if(dics[i].equals(dics[i-1]))
            {
                curCnt++;
            }
            else
            {
                curCnt = 1;
            }

            // 여러 개일 경우 역순인 걸 출력해야 함으로
            if(curCnt >= mostCnt)
            {
                mostCnt = curCnt;
                mode = dics[i];
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