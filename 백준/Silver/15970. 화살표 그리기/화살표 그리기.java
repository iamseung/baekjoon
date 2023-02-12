import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] a;

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];

        // a를 색깔별로 정리
        for (int color = 1; color <= N; color++) 
        {
            a[color] = new ArrayList<Integer>();
        }

        // 같은 색깔의 점들을 모두 모아주는
        for (int i = 1; i <= N; i++) 
        {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx)
    {
        // 왼쪽에 점이 없다면 무한대를 return
        if(idx == 0)
        {
            return Integer.MAX_VALUE;
        }

        return a[color].get(idx) - a[color].get(idx-1);
    }

    static int toRight(int color, int idx)
    {
        // 오른쪽에 점이 없다면 무한대를 return
        if(idx+1 == a[color].size())
        {
            return Integer.MAX_VALUE;
        }

        return a[color].get(idx+1) - a[color].get(idx);
    }

    static void pro() 
    {
        // 색깔별로 정리하기
        for(int color = 1; color <= N; color++)
        {
            Collections.sort(a[color]);
        }

        // 총 길이
        int ans = 0;

        for(int color=1; color<=N; color++)
        {
            for(int i=0; i<a[color].size(); i++)
            {
                // 왼쪽 점까지의 거리
                int toLeft = toLeft(color, i);
                // 오른쪽 점까지의 거리
                int toRight = toRight(color, i);

                // 더 작은 값을 계산
                ans += Math.min(toLeft, toRight);
            }
        }
        
        System.out.println(ans);
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