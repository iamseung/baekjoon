import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String str;

    static void input() 
    {
        while(true)
        {
            str = scan.nextLine();
            if(str.equals(".")) break;

            sb.append(solve(str)).append('\n');
        }

        System.out.println(sb);
    }

    static String solve(String s) 
    {	
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) 
        {	
			char c = s.charAt(i);	// i 번째 문자 
			
			// 여는 괄호일 경우 스택에 push 
			if(c == '(' || c == '[')
            {
				stack.push(c);
            }
			// 닫는 소괄호 일 경우 
			else if(c == ')') 
            {	
				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '(') 
					return "no";
				else 
					stack.pop();
			}
			else if(c == ']') 
            {	
				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '[') 
					return "no";
				else 
                    stack.pop();
			}
			
			// 그 외의 경우에는 불필요한 문자들이기에 skip한다. 
		}
		
		if(stack.empty())
			return "yes";
		else 
			return "no";
	}

    static void pro()
    { 
        System.out.println();
    }

    public static void main(String[] args) 
    {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() 
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try          
            {
                str = br.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}