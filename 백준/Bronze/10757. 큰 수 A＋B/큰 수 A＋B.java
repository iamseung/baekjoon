import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        BigInteger X = new BigInteger(st.nextToken());
        BigInteger Y = new BigInteger(st.nextToken());

        System.out.println(X.add(Y));
        
    }
}