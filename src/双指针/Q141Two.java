package 双指针;

public class Q141Two {
    public boolean hasCycle(ListNode head) {
//        是用来判断空链表的，head，next可以试试去掉
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
//        当快慢指针相等时表明快指针进入了循环，否则慢指针不可能追的上快指针
        while (slow != fast){
//            只要出现空节点时说明一定没有环，因为有环一定不会出现空节点总会回到链表中
//            判断fast.next可以避免21行代码出现空指针异常
            if (fast == null || fast.next == null){
                return false;
            }
//            因为快指针总是比慢指针多走一步
//            所以哪怕第一次正好差2步，下次会差一步，下下次就碰上了
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
