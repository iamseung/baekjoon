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
        
        StringTokenizer st = new StringTokenizer(input, " ");

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if(M < 45) {
			H--;		// 시(hour) 1 감소
			M= 60 - (45 - M); 	// 분(min) 감소
			if(H < 0) {
				H = 23;
			}
			System.out.println(H + " " + M);
		}
		else {
			System.out.println(H + " " + (M - 45));
		}
	}
}