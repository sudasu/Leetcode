import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Medium_416 {
	public boolean canPartition(int[] nums) {
        if(nums==null || nums.length<2)
            return false;
        int firstSetSum = 0;
        int secondSetSum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
        	secondSetSum += nums[i];
        }
        for(int i=0; i<nums.length-1; i++){   
        	if(set.contains(nums[i]))
        		continue;
            firstSetSum += nums[i];
            secondSetSum -= nums[i]; 
            set.add(nums[i]);
            if(firstSetSum == secondSetSum || subPartition(firstSetSum, secondSetSum, nums, i+1, new HashSet<Integer>()))
                return true;
            firstSetSum -= nums[i];
            secondSetSum += nums[i]; 
        }
        return false;
        
    }

    public boolean subPartition(int firstSetSum, int secondSetSum, int[] nums, int idx, Set<Integer> set){
    	
    	if(idx==nums.length-1 || firstSetSum > secondSetSum){
    		return false; 
    	}
        
        for(int i=idx; i<nums.length; i++){
        	System.out.println(set.toString());
        	if(set.contains(nums[i])) {
				continue;
        	}
    		firstSetSum += nums[i];
            secondSetSum -= nums[i];
            set.add(nums[i]);
            if(firstSetSum == secondSetSum)
                return true;
            else{
                if(subPartition(firstSetSum, secondSetSum, nums, i+1, new HashSet<Integer>())){
                	return true;
                }
            }  
            firstSetSum -= nums[i];
            secondSetSum += nums[i];
        }
        return false;
        
    }
    public static void main(String[] args) {
		Medium_416 m = new Medium_416();
		int[] nums= {4,4,4,4,4,4,4,4,8,8,8,8,8,8,8,8,12,12,12,12,12,12,12,12,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,40,40,40,40,40,40,40,40,44,44,44,44,44,44,44,44,48,48,48,48,48,48,48,48,52,52,52,52,52,52,52,52,56,56,56,56,56,56,56,56,60,60,60,60,60,60,60,60,64,64,64,64,64,64,64,64,68,68,68,68,68,68,68,68,72,72,72,72,72,72,72,72,76,76,76,76,76,76,76,76,80,80,80,80,80,80,80,80,84,84,84,84,84,84,84,84,88,88,88,88,88,88,88,88,92,92,92,92,92,92,92,92,96,96,96,96,96,96,96,96,97,99};
		System.out.println(m.canPartition(nums));
	}
}
