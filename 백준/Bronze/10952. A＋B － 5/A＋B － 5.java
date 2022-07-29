import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int X, Y;

        while(true)
        {
            in = br.readLine();
            st = new StringTokenizer(in, " ");
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            if(X == 0 && Y == 0)
            {
                break;
            }

            sb.append(X+Y);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}