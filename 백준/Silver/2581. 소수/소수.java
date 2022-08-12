import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int S = 0;

        boolean min = true;
        int minNum = 0;

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
                S += j;

                if(min)
                {
                    minNum = j;
                    min = false;
                }
            }
             
        }

        if(S == 0)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(S);
            System.out.println(minNum);
        }
    }
}