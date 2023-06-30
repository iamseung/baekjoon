import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N,K,cnt,index;
    static boolean[] prime, arr;

    static void input() 
    {
       N = scan.nextInt();
       K = scan.nextInt();
    }

    static void pro()
    {
        isPrime();

        arr = new boolean[N+1];
        
        for(int i=2; i<=N; i++)
        {
            // 이미 뽑았다면 pass
            if(arr[i]) continue;

            // 소수라면 제거 실행
            if(!prime[i])
            {
                if(delete(i))
                {
                    System.out.println(index);
                    return;
                }
            }
        }
        
    }

    // 제일 작은 소수를 기반으로 비워가는 메서드
    static boolean delete(int i)
    {
        for(int k=1; k<=500; k++)
        {
            index = i*k;

            // 범위에 대한 예외처리
            if(index > N) return false;

            // 아직 뽑지 않았다면
            if(!arr[index])
            {
                arr[index] = true;
                cnt++;

                if(cnt == K)
                {
                    return true;
                }
            }
        }

        return false;
    }

    // 소수 배열 생성, 소수는 false
    static void isPrime()
    {
        prime = new boolean[1001];
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(prime.length); i++)
        {
            if(prime[i]) continue;

            for(int j = i * i; j < prime.length; j += i) 
            {
				prime[j] = true;
			}
        }

        // for(int i=2; i<=1000; i++)
        // {
        //     if(!prime[i]) sb.append(i+" ");
        // }

        // System.out.println(sb);
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