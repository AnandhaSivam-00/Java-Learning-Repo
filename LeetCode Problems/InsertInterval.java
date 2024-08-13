class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int interval[][] = new int[intervals.length+1][2], i;

        for(i=0; i<intervals.length; i++) {
            interval[i] = intervals[i];
        }
        interval[i] = newInterval;

        Arrays.sort(interval, (a, b) -> a[0] - b[0]);

        List<int[]> rangeList = new ArrayList<>();
        int prevInterval[] = interval[0];

        for(i=1; i<interval.length; i++) {
            int currInterval[] = interval[i];

            if(prevInterval[1] >= currInterval[0]) {
                prevInterval[1] = Math.max(currInterval[1], prevInterval[1]);
            }
            else {
                rangeList.add(prevInterval);
                prevInterval = currInterval;
            }
        }

        rangeList.add(prevInterval);

        int ranges[][] = new int[rangeList.size()][2];

        for(i=0; i<rangeList.size(); i++) {
            ranges[i] = rangeList.get(i);
        }

        return ranges;
    }
}