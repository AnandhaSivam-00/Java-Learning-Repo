class Solution {
    public int findMinArrowShots(int[][] points) {
        int size = points.length;
        if(size == 1) {
            return 1;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int minShot = 1, i;
        int prev[] = points[0];

        for(i=1; i<size; i++) {
            int current[] = points[i];

            if(prev[1] < current[0]) {
                minShot++;
                prev = current;
            }
        }

        return minShot;

    }
}