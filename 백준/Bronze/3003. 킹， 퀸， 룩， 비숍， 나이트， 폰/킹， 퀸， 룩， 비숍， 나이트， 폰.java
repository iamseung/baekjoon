import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		System.out.println( (1-Integer.parseInt(input[0]))+" "+(1-Integer.parseInt(input[1]))+" "+(2-Integer.parseInt(input[2]))+" "+
		(2-Integer.parseInt(input[3]))+" "+(2-Integer.parseInt(input[4]))+" "+(8-Integer.parseInt(input[5])));
	}
}