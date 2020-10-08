
public class Easy_334 {
	public void reverseString(char[] s) {
        int idx = 0;
        char temp;
         while(idx<s.length/2){
             temp = s[idx];
             s[idx] = s[s.length-1-idx];
             s[s.length-1-idx] = temp;
             idx++;
         }
         
    }
}
