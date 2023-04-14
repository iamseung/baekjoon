import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class People implements Comparable<People>
    {
        int s; // 서류점수
        int m; // 면접점수

        People(int s, int m)
        {
            this.s = s;
            this.m = m;
        }

        // 서류점수로 오름차순
        @Override
        public int compareTo(People other)
        {
            return s - other.s;
        }
    }

    static People[] person;
    static int N;

    static void input() 
    {
        int T = scan.nextInt();
        
        while(T-- >0)
        {
            N = scan.nextInt();
            person = new People[N+1];

            for(int i=1; i<=N; i++)
            {
                StringTokenizer st = new StringTokenizer(scan.nextLine(), " ");
                person[i] = new People(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            pro();
        }
        

        System.out.println(sb);
    }

    static void pro() 
    {
       Arrays.sort(person, 1, N+1);

       int ans = 1;            // 서류 1등은 통과
       int min = person[1].m;  // 면접 순위 최소값

       for(int i=2; i<=N; i++) // 2등부터 시작
       {
            if(person[i].m < min) // 최소 면접 순위보다 개인의 면접 순위가 높다면 
            {
                min = person[i].m; // 최소 면접 순위 Update
                ans++;             // count ++
            }
       }

       sb.append(ans+"\n");
    }

    public static void main(String[] args) 
    {
        input();
        // pro();
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