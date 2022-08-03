import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int sum = 0;

        for(int i=0;i<length;i++)
        {
            sum += input.charAt(i) - 48;
        }

        System.out.println(sum);
    }
}