package 双指针;

public class J22_1One {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0){
            fast = fast.next;
        }
        //快慢指针一起移动，直到快指针指向null时跳出，此时slow指针指向倒数第k个节点
        //倒数第k个节点，距离尾结点距离为k-1（即慢指针走k-1步到达尾结点）
        //因为我们刚开始快节点多走了k步，因此这里快节点需要到null才结束
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
