class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> rangeList = new ArrayList<>();
        int prevInterval[] = intervals[0], i;

        for(i=1; i<intervals.length; i++) {
            int currInterval[] = intervals[i];

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