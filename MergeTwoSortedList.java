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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int k = 0;
        int l1Len = 0;
        int l2Len = 0;
        ListNode res = new ListNode();
        ListNode curr = res;
        while(l1 != null && l2 != null){
            if(l1.val == l2.val){ 
                ListNode newNode1 = new ListNode(l1.val);
                curr.next = newNode1;
                ListNode newNode = new ListNode(l2.val);
                newNode1.next = newNode;
                curr = newNode;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1.val < l2.val){
                ListNode newNode = new ListNode(l1.val);
                curr.next = newNode;
                curr = newNode;
                l1 = l1.next;
            }
            else{
                ListNode newNode = new ListNode(l2.val);
                curr.next = newNode;
                curr = newNode;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            ListNode newNode = new ListNode(l1.val);
            curr.next = newNode;
            curr = newNode;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode newNode = new ListNode(l2.val);
            curr.next = newNode;
            curr = newNode;
            l2 = l2.next;
        }
        return res.next;
    }
}