import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
	static String str;
	static ArrayList<String> List;
	static HashMap<String, Integer> words;

    static void input() 
    {
		words = new HashMap<>();
		N = scan.nextInt(); M = scan.nextInt();
		while(N-- > 0)
		{
			str = scan.next();
			if(str.length() < M) continue;

			words.put(str, words.getOrDefault(str, 0)+1);
		}
    }

	static void pro() 
    {   
		// HashMap to List 변환
		List<String> word = words.keySet().stream().collect(Collectors.toList());

		word.sort((o1, o2) -> {
			int c1 = words.get(o1);
			int c2 = words.get(o2);

			if(c1 == c2)
			{
				if(o1.length() == o2.length()) return o1.compareTo(o2);

				return o2.length() - o1.length();
			}

			return c2 - c1;
		});

		for(int i=0; i<word.size(); i++) sb.append(word.get(i)+"\n");

		System.out.println(sb);
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

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}