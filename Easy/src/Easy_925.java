
public class Easy_925 {
	 public boolean isLongPressedName(String name, String typed) {
        int firstIdx = 0;
        int secondIdx = 0;
        int repeatNum = 0;

        while(firstIdx<name.length()){
            for(int i=firstIdx; i<name.length(); i++){
                if(name.charAt(firstIdx)!=name.charAt(i)){
                    break;
                }else{
                    repeatNum++;
                }
            }

            for(int j=0; j<repeatNum; j++){
                if(name.charAt(firstIdx)!=typed.charAt(j+secondIdx)){
                    return false;
                }
            }

            firstIdx += repeatNum;
            int tempIdx = secondIdx+repeatNum-1;
            repeatNum=0;
            for(int i=tempIdx; i<typed.length(); i++){
                if(typed.charAt(i)!=typed.charAt(secondIdx)){
                    secondIdx = i;
                    break;
                }else if(i == typed.length() - 1){
                    secondIdx = typed.length() - 1;
                }
            }
        }

        return typed.charAt(secondIdx)==name.charAt(firstIdx-1);
    }
}
