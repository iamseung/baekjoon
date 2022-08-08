import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st;
        int C = Integer.parseInt(br.readLine());

        for(int x=0;x<C;x++)
        {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            int result = 1;
            int arr[][] = new int[k+1][n];

            // i는 층 루프, t는 호 루프
            for(int i=0;i<=k;i++)
            {
                // 0층
                if(i==0)
                {
                    for(int j=0;j<n;j++)
                    {
                        arr[0][j] = j+1;
                    }
                }
                // 1층부터
                else
                {
                    for(int t=0;t<n;t++)
                    {   
                        // 1호
                        if(t == 0)
                        {
                            arr[i][t] = 1;
                        }
                        else
                        {
                            arr[i][t] = arr[i-1][t] + arr[i][t-1];
                        }
                    }
                }
            }
            System.out.println(arr[k][n-1]);
        }
    }
}
