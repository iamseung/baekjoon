import java.util.*;
import java.io.*;

class Main
{
    static int N, Sum;
    static int[] P,ans;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        P = new int[N];
        ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) P[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(P);

        ans[0] = P[0];

        for(int i=1;i<=N-1;i++)
        {
            ans[i] = ans[i-1] + P[i];
        }
        for(int K : ans) Sum += K;

        System.out.println(Sum);
    }
}