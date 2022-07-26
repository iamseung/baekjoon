import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		// System.in 은 입력한 값을 Byte 단위로 읽는 것을 뜻한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());

		for (int i = 1; i < 10; i++) {
			System.out.println(a + " * " + i + " = " + a * i);
		}
		// System.out.println(a);

	}
}