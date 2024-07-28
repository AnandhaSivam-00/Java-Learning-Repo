class Solution {
    public double angleClock(int hour, int minutes) {
        // double hoursAngle = ((hour % 12.0) + minutes / 60.0) * 30.0; // take 12 as reference point to calculate angle
        // // 30 comes from 360/12
        // double minsAngle = minutes * 6.0; // 6 comes from 360/60

        // double angle = Math.abs(hoursAngle - minsAngle);

        double angle = Math.abs(30.0 * hour - (11 * minutes / 2.0));

        if(angle > 180) {
            return 360 - angle;
        }
        return angle;
    }
}