import java.util.*;
public class ZigZagConversion{
    public static Scanner scan = new Scanner(System.in);
    public static String convert(String s, int numRow) {
        int temp = numRow-2;
        int len  = temp + numRow;
        String res = "";
        for(int i=0;i<numRow;i++){
            for(int j=0;j+i<s.length();j=j+len){
                res += String.valueOf(s.charAt(j+i));
                if(i!=0 && i!=numRow-1 && len-i+j < s.length()){
                    res += String.valueOf(s.charAt(len-i+j));
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String str = scan.nextLine();
        scan.nextLine();
        int numRow = scan.nextInt();
        System.out.println(convert(str,numRow));
    }
}
/* "PINALSIGYAHRPI" */