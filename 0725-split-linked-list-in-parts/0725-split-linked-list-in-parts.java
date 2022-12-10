/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        int len=0;
        for(ListNode node=head ; node!=null ; node=node.next){
            len++;
        }
        int n=len/k , r=len%k ; // n : minimum guaranteed part size ; r : extra nodes spread to the first r parts
        ListNode node = head , prev = null;
        for(int i=0 ; node!=null && i<k ; r--,i++){ // 
            parts[i]=node;
            for(int j=0 ; j<n+(r>0?1:0) ; j++){ // 
                prev=node;
                node=node.next;
            }
            prev.next=null;
        }
        return parts;
    }
}


// for Example : (minpartSize)n=10/3=>3.something means you can take 4
//               (extrasize)r=10%3=>3.something means you can take 4
// first loop consider how many parts will become
// second loop consider how many nodes will be inserted in one parts individually
// pvev.next will works as 1,2,3,4,null | 5,6,7,null | 8,9,10,null