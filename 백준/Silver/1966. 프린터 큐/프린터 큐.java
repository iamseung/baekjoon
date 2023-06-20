import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, T;
    static LinkedList<int[]> q;
    
    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();

        // 참조할 큐
        q = new LinkedList<>();

        // 큐 Insert
        // 정렬 순서, 값
        for(int i=0; i<N; i++) q.offer(new int[] {i, scan.nextInt()});
    }

    static void pro()
    {
        int count = 0;

        while(!q.isEmpty())
        {
            // 가장 첫 원소
            int[] front = q.poll();
            // front 원소가 가장 큰 원소인지 확인하는 flag
            boolean isMax = true;

            // 큐에 남아있는 원소들과 비교
            for(int i=0; i<q.size(); i++)
            {
                // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                if(front[1] < q.get(i)[1])
                {
                    // 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
                    // 즉, 중요도가 더 큰 원소를 맨 앞에 배치
                    q.offer(front);
                    for(int j=0; j<i; j++) q.offer(q.poll());

                    // front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                    isMax = false;
                    break;
                }
            }

            // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
            if(!isMax)
                continue;
            // front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
            count++;
            // 찾고자 하는 문서라면 해당 테스트케이스 종료
            if(front[0] == M)
                break;
        }

        sb.append(count).append('\n');
    }


    public static void main(String[] args) 
    {
        T = scan.nextInt();
        while(T-- > 0)
        {
            input();
            pro();
        }

        System.out.println(sb);
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