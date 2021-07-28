import java.util.Arrays;

public class Problem42_TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    static int trap (int[] height){
        int waterTrapped = 0;

        //can only have trapped water if of at least length 3
        if(height == null || height.length <= 2){
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        //compute highest bar left of the current position
        //by seeing if the closest left bar is higher than the previous leftMax.
        //maunually set the first bar, since nothing to compare to before it
        leftMax[0] = height[0];
        for(int i =1; i< height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        //vice versa for the right
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }

        //water can be filled if both side of it has a higher bar
        //we have tracked the left and right highest bar for each index
        //we take the min of the two side and if that is also higher than our current bar,
        //it means it can be filled.
        //we can get negatives when current bar is higher than min of the two side
        //so therefore we want to ignore those when adding to the total water trapped.
        for(int i =0; i<height.length; i++){
            if((Math.min(leftMax[i], rightMax[i])-height[i])>0){
                waterTrapped += Math.min(leftMax[i], rightMax[i])-height[i];
            }

        }

        return waterTrapped;
    }
}
