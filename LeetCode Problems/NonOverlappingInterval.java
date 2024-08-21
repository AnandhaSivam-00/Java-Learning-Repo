class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removalCount = 0, i, currInterval[];
        int prevInterval[] = intervals[0];

        for(i=1; i<intervals.length; i++) {
            currInterval = intervals[i];

            if(prevInterval[1] > currInterval[0]) {
                prevInterval[1] = Math.max(prevInterval[1], currInterval[0]);
                removalCount++;
            }
            else {
                prevInterval = currInterval;
            }
        }

        return removalCount;
    }
}