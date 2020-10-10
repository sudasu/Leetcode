import Entity.ListNode;

public class Easy_141 {
	// 判圈法，龟兔赛跑，如果存在圈，则一定会相遇
	// 引申：若想求圈长度，则第一次相遇后，再继续跑，第二次相遇前fast-slow的长度即为圈长
	 public boolean hasCycle(ListNode head) {
	        if(head==null || head.next==null)
	            return false;
	        ListNode fast = head.next;
	        ListNode slow = head;
	        while(fast!=slow){
	            if(fast==null || fast.next==null)
	                return false;
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        return true;
	    }
}
