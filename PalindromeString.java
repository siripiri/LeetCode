import java.util.*;
public class PalindromeString{
     public static boolean isPalindrome(String s) {
        String modified = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                modified += s.charAt(i); 
            }
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                modified += (char)((int)s.charAt(i)+32);
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                modified += s.charAt(i); 
            }
        }
        System.out.println(modified);
        int i = 0;
        int j = modified.length()-1;
        while(i<j){
            if(modified.charAt(i) != modified.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        String str = scan.nextLine();
        System.out.println(isPalindrome(str));
    }
}