import java.util.ArrayList;
import java.util.List;

public class Easy_1002 {
	 public List<String> commonChars(String[] A) {
        //�ȵõ���һ���ַ�������ÿ���ַ������
        int[] charCount = new int[26];
        for(int i = 0; i < A[0].length(); i++){
            charCount[A[0].charAt(i) - 'a']++;
        }

        //�ӵ�1����ʼ������бȽ�
        for(int i = 1; i < A.length; i++){
            int[] curCount = new int[26];
            
            //������i���ַ���
            for(int j = 0; j < A[i].length(); j++){
                curCount[A[i].charAt(j) - 'a']++;
            }

            //����ʱ���ڵ�i���ַ����������charCount�Աȣ�ȡС�ļ���
            for(int k = 0; k < 26; k++){
                charCount[k] = Math.min(charCount[k], curCount[k]);
            }
        }

        //��ʱ��charCount��Ϊ���е��ַ������ֵĹ��е���СԪ�صĸ���
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            while(charCount[i] != 0){
                result.add(String.valueOf((char)(i + 'a')));
                charCount[i]--;
            }
        }

        return result;
    }
}
