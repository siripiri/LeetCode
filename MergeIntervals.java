class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals,(arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);
        int[] currInterval = intervals[0];
        for(int[] interval : intervals){
            int currBegin = currInterval[0];
            int currEnd = currInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            if(currEnd >= nextBegin){
                currInterval[1] = Math.max(currEnd,nextEnd);
            }
            else{
                currInterval = interval;
                res.add(currInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}