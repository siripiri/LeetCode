class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("[.]");
        String[] ver2 = version2.split("[.]");
        int i = 0;
        int j = 0;
        while(i<ver1.length && j<ver2.length){
            if(Integer.valueOf(ver1[i]) > Integer.valueOf(ver2[j])){
                return 1;
            }
            else if(Integer.valueOf(ver1[i]) < Integer.valueOf(ver2[j])){
                return -1;
            }
            i++;j++;
        }
        while(i<ver1.length){
            if(Integer.valueOf(ver1[i]) > 0)
                return 1;
            i++;
        }
        while(j<ver2.length){
            if(Integer.valueOf(ver2[j]) > 0)
                return -1;
            j++;
        }
        return 0;
    }
}