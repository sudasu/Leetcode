package Tree;

import java.util.Deque;
import java.util.LinkedList;

import Entity.TreeNode;

/**
    *    没读题，题中是二叉搜索树
 * @author zpx
 *
 */
public class Easy_235 {
	int flag = -1;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        dfs(root, p, queue);
        while(queue.size()!=0){
            TreeNode tempRoot = queue.pollLast();
            if(findSonNode(tempRoot, q)){return tempRoot;}
        }
        return null;
    }

    public void dfs(TreeNode root, TreeNode target, Deque<TreeNode> queue){
        if(root==null)
            return;

        queue.offerLast(root);
        
        if(root.val==target.val){
            flag = 1;
            return;
        }
            
        if(flag != 1){
            dfs(root.left, target, queue);
            dfs(root.right, target, queue);
            queue.pollLast();
        }
    }

    public boolean findSonNode(TreeNode root, TreeNode target){
        if(root==null)
            return false;
        
        if(root.val==target.val){
            return true;
        }

        return findSonNode(root.left, target) ? findSonNode(root.left, target) : findSonNode(root.right, target);
    }
    
    
    // 正确解法
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        TreeNode ancestor = root;
//        while (true) {
//            if (p.val < ancestor.val && q.val < ancestor.val) {
//                ancestor = ancestor.left;
//            } else if (p.val > ancestor.val && q.val > ancestor.val) {
//                ancestor = ancestor.right;
//            } else {
//                break;
//            }
//        }
//        return ancestor;
//    }
}
