// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// APPROACH -> https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/8804/Simple-Java-solution-in-one-pass

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next=head;   
        ListNode  slow=start , fast=start;   
        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1 ; i<=n+1 ; i++){
            fast=fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //Skip the desired node
        slow.next=slow.next.next;
        return start.next;
    }
}
