import java.util.stream.Collectors;

class Solution
{
    
    public String solution(String s, int n)
    {
        return s.chars().mapToObj(value -> Character.toString(converter(value, n))).collect(Collectors.joining(""));
    }
    
    private int converter(int num, int n)
    {
        // 대문자일 경우
        if (num >= 65 && num <= 90)
        {
            // 대문자 영역을 넘어버릴 경우
            if (num + n > 90)
            {
                return num + n - 90 + 65 - 1;
            }
            
            return num + n;
        }
        
        // 소문자일 경우
        else if (num >= 97 && num <= 122)
        {
            // 소문자 영역을 넘어버릴 경우
            if (num + n > 122)
            {
                return num + n - 122 + 97 - 1;
            }
            
            return num + n;
        }
        
        // 공백일 경우
        else
        {
            return ' ';
        }
    }
}