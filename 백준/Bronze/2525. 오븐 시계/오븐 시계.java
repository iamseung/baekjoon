import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // 16 50
        int C = Integer.parseInt(br.readLine()); // 20
        
        StringTokenizer st = new StringTokenizer(input, " ");

        int A   = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int total = A * 60 + B + C;

        int hour = (total / 60 >= 24) ? (total / 60) - 24 : total / 60 ;
        int minute = total % 60;

        System.out.println(hour + " " + minute);		
	}
}