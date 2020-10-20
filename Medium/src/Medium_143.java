import java.util.Deque;
import java.util.LinkedList;

import entity.ListNode;

public class Medium_143 {
	Deque<ListNode> que = new LinkedList<ListNode>();
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        while(head!=null){
            que.offerLast(head);
            head = head.next;
        }
        while(que.size()>2){
            que.pollFirst().next = que.peekLast();
            que.pollLast().next = que.peekFirst();
        }
        que.pollLast().next = null;
    }
}
