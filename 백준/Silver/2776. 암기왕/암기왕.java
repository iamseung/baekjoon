import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, T;
    static int[] one, two;

    static void input() 
    {
        // 수첩1
        N = scan.nextInt();
        one = new int[N+1];
        for(int i=1;i<=N;i++)
        {
            one[i] = scan.nextInt();
        }

        // 수첩2
        M = scan.nextInt();
        two = new int[M+1];
        for(int i=1;i<=M;i++)
        {
            two[i] = scan.nextInt();
        }
    }

    static boolean binarySearch(int k)
    {
        int L = 1, R = N;

        while(L <= R)
        {
            int mid = (L+R)/2;

            if(one[mid] == k) return true;

            if(one[mid] > k)
            {
                R = mid - 1;
            }
            else
            {
                L = mid + 1;
            }
        }

        return false;
    }
    static void pro() 
    {
        // 정렬
        StringBuilder sb = new StringBuilder();
        Arrays.sort(one, 1, N+1);
        
        // k 는 수첩2에 적혀있는 숫자
        for(int j=1 ; j<=M; j++)
        {
            if(binarySearch(two[j]))
            {
                sb.append("1").append("\n");
                // System.out.println("1");
            }
            else
            {
                sb.append("0").append("\n");
                // System.out.println("0");
            }            
        }
        System.out.print(sb);
    }

    public static void main(String[] args) 
    {
        T = scan.nextInt();
        while(T-- >0)
        {
            input();
            pro();
        }
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