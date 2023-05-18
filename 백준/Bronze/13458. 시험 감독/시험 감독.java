import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,B,C;
    static int[] A;

    /*
     * 시험장의 개수 : N
     * 각 시험장에 응시자 수 :  A[i]
     * 총감독관이 감시할 수 있는 수 : B
     * 부감독관이 감시할 수 있는 수 : C
     */
    static void input() 
    {
        N = scan.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++) A[i] = scan.nextInt();
        B = scan.nextInt(); C = scan.nextInt();
    }

	static void pro() 
    {  
        long ans = 0;
        for(int i=1; i<=N; i++)
        {
            ans++;
            A[i] -=B;

            if(A[i] <= 0) continue;

            ans += A[i]/C;
            if(A[i] % C != 0) ans ++;
        }

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