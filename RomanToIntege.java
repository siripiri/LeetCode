import java.util.*;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        hash.put('I',1);
        hash.put('V',5);
        hash.put('X',10);
        hash.put('L',50);
        hash.put('C',100);
        hash.put('D',500);
        hash.put('M',1000);
        int result = 0;
        for(int i=0;i<s.length();i++){
            if(i+1 < s.length()){
                int add = hash.get(s.charAt(i));
                int next = hash.get(s.charAt(i+1));
                if(add < next){
                    result -= add;
                }
                else{
                    result += add;
                }
            }
            else{
                int add = hash.get(s.charAt(i));
                result += add;
            }
        }
        return result;
    }
}