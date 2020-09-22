
public class Hard_968 {
	 public int minCameraCover(TreeNode root) {
         int[] array = dfs(root);
         return array[1];
	 }
	 
	 public int[] dfs(TreeNode root) {
		 if(root == null)
			 return new int[] {Integer.MAX_VALUE/2, 0, 0};
		 
		 int[] leftArray = dfs(root.left);
		 int[] rightArray = dfs(root.right);
		 int[] array = new int[3];
		 
		 // ������������������root��װ��camera
		 array[0] = leftArray[2] + rightArray[2] + 1;
		 
		 // ���������������ǣ���rootҲ������
		 array[1] = Math.min(array[0], 
				 Math.min(leftArray[1] + rightArray[0], leftArray[0] + rightArray[1]));
		 
		 // ���������߱����ǣ�����root�Ƿ񱻸���
		 array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
		 
		 return array;
	 }
	 class TreeNode{
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode(int x){
				val = x;
			}
		}	 
	 
	 
}


