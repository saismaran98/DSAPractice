package SearchingAndSorting;

import java.util.HashMap;

public class KokoEatinBananas {
    public static int minEatingSpeedBruteForceSol(int[] piles, int h) {
        // Find maximum pile as the upper bound for speed (BRUTE FORCE)
        int maxPile = 0;
        int minSpeed = Integer.MAX_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        for(int speed = 1; speed<= maxPile;speed++){
            int totalHoursToEat = 0;
            //calculate hours to eat with current speed.
            for(int pile : piles){
                totalHoursToEat += Math.ceil((double) pile / speed);
            }
            if(totalHoursToEat <= h){
                minSpeed = Math.min(minSpeed, speed);
                break; // found first valid speed which will be min.
            }
        }
        return minSpeed;
    }
    public static int minEatingSpeedWithBinarySearch(int[] piles, int h){
        // Find maximum pile as the upper bound for speed (Binary Search : Optimized)
        int maxPile = 0;
        int minSpeed = Integer.MAX_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int left = 1;
        int right = maxPile;

        while(left <= right){
            int mid = (left + right) / 2;
            int totalTime = getTotalTime(piles, mid);
            if(totalTime > h) // cannot finish in h time. too slow move to right
                left = mid + 1;
            else if( totalTime <= h){ // correct window, slide to left to check for more.
                right = mid - 1;
                minSpeed = Math.min(minSpeed, mid);
            }
        }
        return minSpeed;
    }
    public static int getTotalTime(int[] piles, int k){
        int totalTime = 0;
        for(int pile : piles){
            totalTime += Math.ceil((double) pile / k);
        }
        return totalTime;
    }
    public static void main(String[] args) {
        System.out.println(minEatingSpeedBruteForceSol(new int[]{25,10,23,4}, 4));;
    }
}
