package Tree;

import Entity.TreeNode;

public class Easy_530 {
	int min = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
