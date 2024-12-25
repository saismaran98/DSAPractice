package ArraysAndString;

import java.util.Arrays;

public class SlidingWindow {
    public static int maxProfit(int[] prices) {
       int today = 0;
       int newDay = 1;
       int maxProfit = 0;
       while(newDay < prices.length){
           int buyPrice = prices[today];
           int sellPrice = prices[newDay];
           int profit = sellPrice - buyPrice;
           if(profit > 0) // profit should be positive value else its loss
               maxProfit = Math.max(maxProfit, profit); // update maxProfit if its greater than cur profit.
           else // loss indicate we have a new low buy price.
                today = newDay; // poit to the new min buy date

           newDay+=1;
       }
       return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println( maxProfit(new int[]{7,1,5,3,6,4}));;
    }
}
