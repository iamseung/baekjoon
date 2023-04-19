import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static Lecture[] L;
    static int N;
    
    static class Lecture
    {
        public int sdate;
        public int edate;

        Lecture(int startDate, int endDate)
        {
            this.sdate = startDate;
            this.edate = endDate;
        }
    }

    static void input() 
    {
        N = scan.nextInt();   
        L = new Lecture[N+1];
        for(int i=1; i<=N; i++) L[i] = new Lecture(scan.nextInt(), scan.nextInt());
    }

    static void pro() 
    {
        // 오름차순 정렬
        Arrays.sort(L, 1, N+1, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if(o1.sdate == o2.sdate) return o1.edate - o2.edate;
                return o1.sdate - o2.sdate;
            }
        });

        // 우선순위 큐에는 종료 시간만 들어가고, 오름차순으로 자동정렬
        q.offer(L[1].edate);

        for(int i=2; i<=N; i++)
        {
            /*
             * peek() : 우선순위가 가장 높은 값을 참조
             * 종료시간 <= 시작시간의 경우에 직전의 종료시간을 꺼내고 다음 종료시간을 넣고 계속 비교
             */
            if(q.peek() <= L[i].sdate) q.poll();

            // 순회하면서 현재 end 값을 넣어준다.
            q.offer(L[i].edate);
        }

        System.out.println(q.size());

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