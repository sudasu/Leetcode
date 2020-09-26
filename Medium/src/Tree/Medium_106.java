package Tree;

import java.util.HashMap;
import java.util.Map;

public class Medium_106 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        
        TreeNode root = buildTree(0, inorder.length-1, 0, postorder.length-1, postorder);
        return root;
    }

    public TreeNode buildTree(int ls, int le, int rs, int re, int[] postorder){
        if(le < ls || re < re){
            return null;
        }

        TreeNode root = new TreeNode(postorder[re]);
        int idx = map.get(postorder[re]);
        root.left = buildTree(ls, idx-1, rs, rs+idx-ls-1, postorder);
        root.right = buildTree(idx+1, le, rs+idx-ls, re-1, postorder);
        return root;
    }
}
