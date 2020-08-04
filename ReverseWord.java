import java.util.*;
public class ReverseWord{
    public static String reverse(String s) {
        if(s.length() == 0 || s == null)
            return "";
        String[] modified = s.split(" ");
        s = "";
        for(int i=modified.length-1;i>=0;i--){
            if(!modified[i].equals("")){
                s += modified[i];
                s += " "; 
            }
        }
        return s.length()==0 ? "" : s.substring(0,s.length()-1);
    }
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        String str = scan.nextLine();
        System.out.println(reverse(str));
    }
}