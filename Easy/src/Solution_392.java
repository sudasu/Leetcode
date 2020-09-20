
public class Solution_392 {
	
	/*
	 * 解法1
	 */
	 public boolean isSubsequence(String s, String t) {
	        int index = 0;
	        int flag = -1;
	        for(int i=0; i<s.length(); i++){
	            for(int j=index; j<t.length(); j++){
	            	index++;
	                if(s.charAt(i)==t.charAt(j)){
	                    flag = 1;
	                    break;
	                }
	            }
	            if(flag == -1)
	                return false;
	            flag = -1;
	        }
	        return true;
	    }
	 
	 /**
	      *  解法2
	  * @param args
	  */
	public boolean isSubsequence2(String s, String t) {
		int index = -1;
		for(char c : s.toCharArray()) {
			index = t.indexOf(c, index+1);
			if(index == -1)
				return false;
		}
		return true;
	}
	 
	public static void main(String[] args) {
		Solution_392 s = new Solution_392();
		System.out.println(s.isSubsequence2("acb","ahbgdc"));
	}
}
