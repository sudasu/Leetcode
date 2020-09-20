import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        result.add(new ArrayList<>(tempList));
        backTrace(result, nums, tempList, 0);
        return result;
    }

    public void backTrace(List<List<Integer>> result, int[] nums, List<Integer> tempList, int index){
        if(index == nums.length)
            return;
        
        for(int i=index; i<nums.length; i++){
            tempList.add(nums[i]);
            result.add(new ArrayList<>(tempList));
            backTrace(result, nums, tempList, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}