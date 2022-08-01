import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nums  = Integer.parseInt(br.readLine());
        String score = br.readLine();

        StringTokenizer st = new StringTokenizer(score, " ");

        int max = -1;
        double sum = 0;
    

        while(st.hasMoreTokens())
        {
            int var = Integer.parseInt(st.nextToken());
            if(max<var)
            {
                max = var;
            }
            sum += var;
        }
        double avg = sum / nums;
        System.out.println(avg/max*100);
    }
}
