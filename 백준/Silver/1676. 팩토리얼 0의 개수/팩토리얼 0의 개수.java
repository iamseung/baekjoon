import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main 
{
	public static void main(String[] args) throws IOException 
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int num = Integer.parseInt(br.readLine());
		int count = 0;
 
        // 5의 갯수를 구하는
		while (num >= 5) 
        {
			count += num / 5;
			num /= 5;
		}
        
		System.out.println(count);
	}
 
}