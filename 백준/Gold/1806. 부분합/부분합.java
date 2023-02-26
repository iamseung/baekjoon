/*
 * 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
 * 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
 */

import java.io.*;
import java.util.*;

public class Main 
{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n, S;
    static int[] a;

    static void input() 
    {
        n = scan.nextInt(); // 수열의 수
        S = scan.nextInt(); // 수열의 합
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) 
        {
            a[i] = scan.nextInt();
        }
    }

    static void pro() 
    {
        int R = 0, sum = 0;
        int ans = n + 1; // 가장 짧은 것의 길이를 구하는 것이기 때문에 배열의 크기 + 1로 초기화

        for (int L = 1; L <= n; L++) 
        {
            /*
             * [L의 위치를 한칸씩 옮길 때마다 L - 1 을 구간에서 제외하기]
             * R의 위치는 전 탐색이 마친 그 위치에 있기 때문에 따로 초기화 해주지 않고
             * 막 탐색을 마친 값만 빼줘서 R을 이어서 서치한다는 개념
             */
            sum -= a[L - 1];
            
            /*
             * [R 을 옮길 수 있을 때 까지 옮기기]
             * 배열의 크기가 n+1이니까 R+1<=N까지 반복하고 부분합을 넘는다면 Stop
             */
            while (R + 1 <= n && sum < S)
            {
                /*
                 * ++R 은 R에+1 을 선행, 
                 * R+1을 넣을 수도 있지만 R의 값 자체를 +1 해준다는 개념
                 */
                sum += a[++R]; 
            }
            
            /*
             * [[L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기]
             * 가장 짧은 것의 길이를 구하는 것이기 때문에 ans 와 길이 (R-N+1) 중 낮은 값을 ans 에 갱신
             */
            if (sum >= S) ans = Math.min(ans, R - L + 1);
        }

        // 모든 배열의 탐색을 마쳤을 때 ans 의 값이 초기화한 값과 같다면, 불가능
        if (ans == n + 1)
        {
            ans = 0;
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