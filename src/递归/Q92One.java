package 递归;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */

public class Q92One {
//    这里的后继节点就是区间中n下标位置节点的下一个节点
    ListNode successor = null; // 后继节点
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case，每次从头结点向后遍历，知道找到区间的头结点，把他当做下面那种head为起点的处理情况，n-m
        //始终为区间长度，所以m-1，n-1不会导致区间长度发生变化
        head.next = reverseBetween(head.next, m - 1, n - 1);
        //最外层递归head就是头结点
        return head;
    }
    // 反转以head（即第一个节点）为起点，的n个节点，返回新的头结点，每次递归方法中head都等于当前正在递归的节点，每次递归操作的都是
    //当前的head节点
    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        // 然后不断递归知道找到要反转区间的最后一个节点然后进入上面的if结束条件把最后一个节点返回，同时拿到区间最后一个节点的后继节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
//        last始终等于区间最后一个节点
        return last;
    }
}
