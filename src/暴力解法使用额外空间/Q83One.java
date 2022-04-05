package 暴力解法使用额外空间;

import java.util.List;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次 。返回已排序的链表 。
 */

public class Q83One {
    public ListNode deleteDuplicates(ListNode head) {
//        首先判断一下传入的链表头节点是否为空
        if (head == null){
            return head;
        }
//        不为空则将头结点赋值给一个临时节点
        ListNode cur = head;
//        利用这个临时节点遍历链表。ps：当我们遍历到链表的最后一个节点时，cur.next为空节点，
//        如果不加以判断，访问cur.next对应的元素会产生运行错误。
//        因此我们只需要遍历到链表的最后一个节点，而不需要遍历完整个链表。
        while (cur.next != null){
//            当这个节点的值与它后继节点的值相等时则让这个节点的后继节点指向下个节点的后继节点（通过这种方式删除重复节点）
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
//                不相等时则不断向后遍历这个链表
            }else {
//                这个cur只是个指向链表节点的引用（cur储存在栈中，链表节点储存在堆中），改变它的值不会影响到链表，
//                上面代码能改变链表结构是因为当这个cur节点指向一个链表节点时把它的next属性修改了，
//                改变的是堆内存中这个对象的属性值
                cur = cur.next;
            }
        }
//        最后把头结点进行返回
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
