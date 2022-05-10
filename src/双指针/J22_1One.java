package 双指针;

public class J22_1One {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode low = head;
        while (k-- > 0){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
