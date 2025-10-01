class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total=numBottles;;
        int rem=0;
       while(numBottles/numExchange!=0){
        total=total+numBottles/numExchange;
        rem=numBottles%numExchange;
        numBottles=numBottles/numExchange + rem;
       } 
       return total;
    }
}