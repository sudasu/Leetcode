package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Tree.Medium_106.TreeNode;

public class Medium_113 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result = new LinkedList<>();
        Deque<Integer> list = new LinkedList<>();
        // list.add(root.val);
        findPath(root, sum, list);
        return result;
    }

    public void findPath(TreeNode root, int complement, Deque<Integer> list){
        if(root == null)
            return;
        
        int length = list.size();
        list.offerLast(root.val);
        complement = complement - root.val;

        if(root.left==null && root.right==null && complement==0){
            result.add(new LinkedList<Integer>(list));
        }
        findPath(root.left, complement, list);
        findPath(root.right, complement, list);
        list.pollLast();
    }
}
