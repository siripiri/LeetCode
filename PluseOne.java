class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1] < 9){
            digits[digits.length-1]++;
            return digits;
        }
        int[] res = new int[digits.length+1];
        int i = 0;
        int carry = 0;
        for(i=digits.length-1;i>=0;i--){
            if(digits[i] != 9){
                if(carry == 1){
                    digits[i]++;
                    carry = 0;
                }
                break;
            }
            digits[i] = 0;
            carry = 1;
        }
        if(i < 0){
            res[0] = 1;
            for(i=1;i<res.length;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }
}