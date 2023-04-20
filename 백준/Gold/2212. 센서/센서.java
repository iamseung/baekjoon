import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] arr, dif;

    static void input() 
    {
        N = scan.nextInt(); // 센서
        K = scan.nextInt(); // 집중국
        arr = new int[N+1];
        dif = new int[N];
        for(int i=1; i<=N; i++) arr[i] = scan.nextInt();
    }

    static void pro() 
    {
        if(K >= N)
        {
            System.out.println(0);
            return;
        }
            
        Arrays.sort(arr,1,N+1);

        for(int i=1; i<N; i++) dif[i] = arr[i+1] - arr[i];

        Arrays.sort(dif, 1, N);

        int ans = 0;

        for(int i=1; i<=N-K; i++) ans += dif[i];

        System.out.println(ans);
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