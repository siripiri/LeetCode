import java.util.*;
public class PalindromeNumber{
    public static boolean isPalindrome(int x) {
        int x1 = x;
        if(x < 0 )
            return false;
        int res = 0;
        while(x>0){
            int temp = x%10;
            res = (res*10) + temp;
            x = x/10;
        }
        System.out.println(res);
        return res == x1 ? true : false;
    }
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int x = scan.nextInt();
        System.out.println(isPalindrome(x));
    }
}