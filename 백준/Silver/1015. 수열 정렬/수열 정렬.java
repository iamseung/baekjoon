import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> 
    {

        public int num, idx;

        @Override
        public int compareTo(Elem other) 
        {
            // 1. num 의 비내림차순
            // 2. num이 같으면 idx 오름차순
            // -> B 배열의 index는 자동으로 오름차순이기 때문에 생략 가능
            return num - other.num;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    static void input() 
    {
        N = scan.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) 
        {
            B[i] = new Elem();
            B[i].num = scan.nextInt(); // 입력받는 정수
            B[i].idx = i;              // index
        }
    }

    static void pro() 
    {
        // B 배열 정렬
        Arrays.sort(B);

        // B 배열의 값을 이용해서 P 배열 채우기
        for (int i = 0; i < N; i++) 
        {
            P[B[i].idx] = i;
        }

        for (int i = 0; i < N; i++) 
        {
            sb.append(P[i]).append(' ');
        }

        System.out.println(sb.toString());
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