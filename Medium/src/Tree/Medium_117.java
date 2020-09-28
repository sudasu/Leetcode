package Tree;

import java.util.LinkedList;
import java.util.Queue;


public class Medium_117 {
	 Queue<Node> queue = new LinkedList<Node>();
	    public Node connect(Node root) {
	        if(root == null)
	            return null;
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int tempNum = queue.size();
	            for(int i=0; i<tempNum; i++){
	                Node tempNode = queue.poll();
	                 if(tempNode.left != null)
	                    queue.offer(tempNode.left);
	            
	                if(tempNode.right != null)
	                    queue.offer(tempNode.right);

	                if(i == tempNum-1){
	                    tempNode.next = null;
	                }else{
	                    tempNode.next = queue.peek();
	                }
	            }
	           
	        }
	        return root;
	    }
}

class Node{
	int val;
	Node left;
	Node right;
	Node next;
	public Node(int val, Node left, Node right, Node next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}
}
