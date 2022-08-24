// https://leetcode.com/problems/palindrome-linked-list/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
       } 
    slow=reverse(slow);
    fast=head;
// compare both halves
    while(slow!=null){
        if(fast.val!=slow.val){
            return false ;
        }
        slow=slow.next;
        fast=fast.next;
    }
       return true ; 
 } 
// this code is used to reverse the LinkedList  
    public ListNode reverse(ListNode head){
        ListNode prev = null ;
        while(head!=null){
                ListNode temp = head.next;
                head.next=prev;
                prev=head;
                head=temp; 
        }
        return prev;
    }
}
