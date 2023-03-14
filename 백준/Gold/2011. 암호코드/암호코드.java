/*
 * 한자리씩 늘려가며 셀 수 있는 횟수를 저장해가는
 */
import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static int[] Dy;
    static int N, MOD = 1000000;

    static void input() 
    {
        str = scan.next();
        N = str.length();
    }

    // 'AB' 라는 두 자리 숫자가 하나의 수로 해독이 가능한가? 
    // 10 <= AB <= 26
    static boolean check(char A, char B) 
    {  
        if (A == '0') return false; // 한자릿수
        if (A == '1') return true;  // 10-19
        if (A >= '3') return false; // 26 초과부터는 해독 X
        return B <= '6';
    }

    static void pro() {
        Dy = new int[N];

        // 초기값 구하기, else = 0
        if (str.charAt(0) != '0') Dy[0] = 1;

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 1; i < N; i++) 
        {
            // i 번 숫자를 단독으로 해석 가능할 때, else = 0
            if (str.charAt(i) != '0') Dy[i] = Dy[i - 1];

            // i - 1번과 i 번 숫자를 하나의 문자로 해석 가능할 때
            if (check(str.charAt(i - 1), str.charAt(i))) 
            {
                // 세번째부터는 +[i-2]
                if(i >= 2)
                {
                    Dy[i] += Dy[i - 2];
                }
                else
                {
                    // 두번째까지는 +1
                    Dy[i] += 1;
                }
                
                Dy[i] %= MOD;
            }
        }

        // Dy배열로 정답 계산하기
        System.out.println(Dy[N - 1]);
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