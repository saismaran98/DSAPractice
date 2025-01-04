package ArraysAndString;

public class BestTimeToBuyAndSellStocks {
    public static int maxProfit(int[] nums) {
        // buy stock if cur price is min.
       int minPrice = 0;
       int maxPrice = Integer.MAX_VALUE;
       int day = 0;
        while(day < nums.length ){
        //find minimun value in array.
        minPrice = Math.min(minPrice, nums[day]);
        maxPrice =Math.max(maxPrice, nums[day]);

        day+=1;
        }
        return maxPrice - minPrice;
    }

    public static void main(String[] args) {
       int maxProfit = maxProfit(new int[] {2,1,2,1,0,1,2});
        System.out.println("maxProfit = "+maxProfit);
    }
}
