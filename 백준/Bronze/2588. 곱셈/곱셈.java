import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine()), Y = Integer.parseInt(br.readLine());

		System.out.println(X * (Y % 10));
		System.out.println(X * ((Y % 100) / 10));
		System.out.println(X * (Y / 100));
		System.out.println(X * Y);
	}
}