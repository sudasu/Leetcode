import entity.Node;

public class Medium_116 {
	public Node connect(Node root) {
        if(root==null)
            return null;
        Node temp = root;
        while(temp!=null){
            conn(temp);
            temp = temp.left;
        }
        return root;
    }

    public void conn(Node temp){
        if(temp.left==null){
            return;
        }
        temp.left.next = temp.right;
        while(temp.next!=null){
            temp.right.next = temp.next.left;
            temp.next.left.next = temp.next.right;
            temp = temp.next;
        }
    }
}
