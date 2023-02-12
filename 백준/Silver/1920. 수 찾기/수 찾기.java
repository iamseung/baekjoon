import java.io.*;
import java.util.*;

public class Main 
{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++)
        {
            B[i] = Integer.parseInt(st.nextToken());
        }

        pro();
        System.out.println(sb.toString());
    }

    static void pro()
    {
        // 이분탐색을 위한 정렬
        Arrays.sort(A, 1, N+1);
        
        for(int i=1;i<=M;i++)
        {
            if(lower_bound(B[i])) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }
    }

    static boolean lower_bound(int K)
    {
        int L=1,R=N;

        while(L <= R)
        {
            int mid = (L+R)/2;
            if(A[mid] == K) return true;

            if(A[mid] > K)
            {
                R = mid-1;
            }
            else if(A[mid] <= K)
            {
                L = mid+1;
            }
        }

        return false;
    }
}