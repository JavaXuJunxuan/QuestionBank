package 递归;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

public class J06_1Two {
    int[] res;
    int i = 0;
    int j = 0;
    public int[] reversePrint(ListNode head) {
        solve(head);
        return res;
    }
    public void solve(ListNode head){
//        当执行这一步的时候，递归到了尾结点的下一个空节点，此时初始化数组然后返回
        if (head == null){
            res = new int[i];
            return;
        }
        i++;
//        第一次执行完这里是到链表空节点时,传入的是尾结点的下一个空节点,但此时的head还是尾结点
        solve(head.next);
//        此时j=0,所以数组的第一个下标位置填入的就是尾结点的值
        res[j] = head.val;
//        每次向数组加入一个元素就把下标加一
        j++;
    }
}
