import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String s = "         ,r'\"7\n" + // \", \n 이 제어문자다.
				"r`-_   ,'  ,/\n" + // \n 이 제어문자다.
				" \\. \". L_r'\n" + // \\, \", \n 이 제어문자다.
				"   `~\\/\n" + // \\, \n 이 제어문자다.
				"      |\n" + // \n 이 제어문자다.
				"      |";

		System.out.print(s);
	}
}