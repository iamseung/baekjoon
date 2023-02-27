/*
 길이가 N인 수열이 주어질 때, 수열에서 연속한 1개 이상의 수를 뽑았을 때 같은 수가 여러 번 등장하지 않는 경우의 수를 구하는 프로그램을 작성하여라.
 */

import java.io.*;
import java.util.*;

public class Main 
{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[] A, cnt;

    static void input() 
    {
        N = scan.nextInt(); // 수
        
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) 
        {
            A[i] = scan.nextInt();
        }

        cnt = new int[100000+1];
    }

    static void pro() 
    {
        long ans =0;
        
        // L 마다 R 을 최대한 옮겨준다
        for(int L=1, R=0; L <= N; L++)
        {
            // 다음 A 가 카운트 되지 않는 선에서 R을 가능한만큼 옮긴다
            while(R+1 <= N && cnt[A[R+1]] == 0)
            {
                R++;
                cnt[A[R]]++;
            }

            // 값을 갱신? 왜 길이를 구하지
            ans += R-L+1;

            // L 을 옮겨주면서 해당 L 의 카운트를 지우는, A[L] 의 개수를 감소시킴.
            cnt[A[L]]--;
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