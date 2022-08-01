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
        StringBuilder sb = new StringBuilder();

        for(int j=0;j<nums;j++)
        {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, "X");
            int result = 0;
            while(st.hasMoreTokens())
            {
                int count = (st.nextToken()).length();
                for(int i=1;i<=count;i++)
                {
                    result += i;
                }
            }
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
}
