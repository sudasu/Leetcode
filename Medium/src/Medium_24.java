import entity.ListNode;

public class Medium_24 {
	public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode parent = null;
        while(first!=null && first.next!=null){
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            if(parent!=null){
                parent.next = second;
            }else{
                head = second;
            }
            parent = first;
            first = first.next;
        }
        return head;
    }
	
	public static void main(String[] args) {
		
	}
}
