class Solution {
    public boolean isHappy(int n) {
        Set<Integer> list = new HashSet<>();
        while(n != 1){
            if(list.contains(n)){
                return false;
            }
            list.add(n);
            n = digitsquareSum(n);
        }
        return true;
    }

    public int digitsquareSum(int num){
        int sum = 0;
        while(num > 0){
            sum += Math.pow(num%10, 2);
            num /= 10;
        }
        return sum;
    }
}