package easy;

public class easy_03 {
	public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]])
                    return nums[i];
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
