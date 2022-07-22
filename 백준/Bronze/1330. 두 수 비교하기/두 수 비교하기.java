import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		// System.in 은 입력한 값을 Byte 단위로 읽는 것을 뜻한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if (a < b) {
			System.out.println("<");
		}

		if (a > b) {
			System.out.println(">");
		}

		if (a == b) {
			System.out.println("==");
		}
	}
}