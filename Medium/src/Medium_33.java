
public class Medium_33 {
	public int search(int[] nums, int target) {
	    int startIdx = 1;
	    for(int i=0; i<nums.length-1; i++){
	        if(nums[i]>nums[i+1]){
	            startIdx = i+1;
	            break;
	        }
	    }
	    int idx = findIdx(nums, 0, startIdx-1, target);
	    return idx==-1 ? findIdx(nums, startIdx, nums.length-1, target) : idx;
	
	}
	
	public int findIdx(int[] nums, int startIdx, int endIdx, int target){ 
	    if(startIdx < 0 || endIdx == nums.length || startIdx > endIdx)
	        return -1;
	
	    if(startIdx == endIdx)
	        return nums[startIdx]==target ? startIdx : -1;
	
	     if( nums[startIdx] > target || nums[endIdx] < target)
	        return -1;
	
	    int mid = (startIdx+endIdx)/2;
	    if(target == nums[mid]){
	        return mid;
	    }
	    if(target > nums[mid]){
	        startIdx = mid + 1;
	    }
	    if(target < nums[mid]){
	        endIdx = mid;
	    }
	    return findIdx(nums, startIdx, endIdx, target);
	}
	
	public static void main(String[] args) {
		Medium_33 m = new Medium_33();
		int[] nums = {4,5,6,7,0,1,2};
		int target = 4;
		int result = m.search(nums, target);
		System.out.println(result);
	}
}
