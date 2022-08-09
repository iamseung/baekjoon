import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int C = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t;
        int count = 0;

        for(int i = 0; i<C; i++)
        {
            Boolean check = true;
            t = Integer.parseInt(st.nextToken());
            
            if(t == 1){continue;}
            for(int j=2;j<t;j++)
            {
                if(t % j == 0)
                {
                    check = !check;
                    break;
                } 
            }
            
            if(!check){continue;}
            count++;
        }
        System.out.println(count);       
    }
}