import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> 
    {

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) 
        {
            // [내림차순] 국어
            if (korean != other.korean) return other.korean - korean;

            // [내림차순] 영어
            if (english != other.english) return english - other.english;

            // [내림차순] 수학
            if (math != other.math) return other.math - math;

            // [내림차순] 이름
            return name.compareTo(other.name);
        }
    }

    static int N;
    static Elem[] a;

    static void input() 
    {
        N = scan.nextInt();
        a = new Elem[N];

        for (int i = 0; i < N; i++) 
        {
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].korean = scan.nextInt();
            a[i].english = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }

    static void pro() 
    {
        // 기준을 통해 정렬하기
        Arrays.sort(a);

        // 정답을 출력하기
        for (int i = 0; i < N; i++) 
        {
            sb.append(a[i].name).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
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