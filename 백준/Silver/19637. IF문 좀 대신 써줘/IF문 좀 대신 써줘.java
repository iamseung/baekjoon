import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static String[][] range;

    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();
        range = new String[N][2];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(scan.nextLine(), " ");
            range[i][0] = st.nextToken(); // 칭호
            range[i][1] = st.nextToken(); // 점수
        }
    }

    static void pro()
    {
        while(M-- > 0) binarySearch(scan.nextInt());

        System.out.println(sb);
    }   

    static void binarySearch(int k)
    {
        int L = 0, R = N-1;

        while(L<=R)
        {
            int mid = (L+R)/2, target = Integer.parseInt(range[mid][1]);;

            if(target<k)
                L = mid + 1;
            else
                R = mid - 1;
        }

        sb.append(range[L][0]+"\n");
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