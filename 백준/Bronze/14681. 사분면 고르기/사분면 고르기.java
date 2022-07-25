import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 띄어쓰기로 입력
        int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());

		if(x > 0)
        {
            if(y > 0)
            {
                System.out.println(1);
            }
            else
            {
                System.out.println(4);
            }
        }
        else
        {
            if(y > 0)
            {
                System.out.println(2);
            }
            else
            {
                System.out.println(3);
            }
        }
	}
}