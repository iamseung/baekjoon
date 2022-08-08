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

        for(int i=0;i<C;i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
            int one = (N % H == 0)?H : N%H;
            int two = (N % H == 0)?N/H : N/H+1;
            if(two < 10)
            {
                System.out.println(one+"0"+two);
            }
            else
            {
                System.out.println(one+""+two);
            }
            
        }

    }
}