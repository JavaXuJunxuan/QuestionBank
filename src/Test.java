public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(6);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        Test test = new Test();
        head = test.addAtHead(0,head);
        for (int i = 5; i >= 0 ; i--){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode addAtHead(int val, ListNode head) {
        ListNode pre = new ListNode(val);
        pre.next = head;
        ListNode temp = pre;
        pre = head;
        head = temp;
        return head;
    }
    /*public ListNode addAtHead(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        while (head.next != null){
            head.next.next = head;
            head = head.next;
        }
    }*/
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
