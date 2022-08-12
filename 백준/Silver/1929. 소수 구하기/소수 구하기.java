import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int j=M;j<=N;j++)
        {
            if(j == 1) continue;
            boolean check = true;

            for(int i=2;i<=Math.sqrt(N);i++)
            {
                if(j == i) continue;
                if(j % i == 0)
                {
                    check = false;
                }
            }

            if(check)
            {
                System.out.println(j);
            }    
        }
    }
}