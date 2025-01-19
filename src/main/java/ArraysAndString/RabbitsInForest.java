package ArraysAndString;

import java.util.HashMap;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        // rabbit answer
        HashMap<Integer, Integer> count = new HashMap<>();//map<color, count>
        for(int ans : answers){
            count.put(ans, count.getOrDefault(ans, 0)+1); // count how many of them has the same color.
        }
        int sum =0;
        // {1->2, 2->1} two rabbit said 1 other with same color as me , 1 said 2 other with same color as me.
        for(int colorCount: count.keySet()){
            if(count.get(colorCount) > 1)
                sum+=colorCount + 1;
            else if(count.get(colorCount) == 1){
                sum+= colorCount + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RabbitsInForest ob = new RabbitsInForest();
        System.out.println(ob.numRabbits(new int[]{1,1,2}));;
    }
}
