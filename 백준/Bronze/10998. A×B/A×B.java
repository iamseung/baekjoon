import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// BufferedReader 의 경우 문자열을 받는 대표적인 방법은 readLine()과 read()이다.
// readLine()은 한 행을 읽어오고, read()는 한 문자만 읽어온다.
// 특별한 경우가 없는 한 대부분 readLine()을 사용

public class Main 
{
	public static void main(String[] args) throws IOException
    {
		// System.in 은 입력한 값을 Byte 단위로 읽는 것을 뜻한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(a*b);
	}
}