package TwoPointers;

public class ContainerWithMostWater {
    /*
    * You are given an integer array heights where heights[i] represents the height of the ithith bar.
    * You may choose any two bars to form a container. Return the maximum amount of water a container can store
    */
    public static int maxArea(int[] heights) {
        int max_area = 0;
        // we take two pointer at both ends to maximize width and check for maxArea
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            // not matter how big the second piller is area will depent on small pillar
            int height = Math.min(heights[left], heights[right]);
            int width= right - left;
            int area = height * width; // length * breath.
            max_area = Math.max(max_area, area);
            if(heights[left] > heights[right])
                right--;
            else
                left++;
        }
    return max_area;
    }
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{0,2}));
    }
}
