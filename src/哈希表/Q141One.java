package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */

public class Q141One {
    public boolean hasCycle(ListNode head) {
//        利用set集合不可重复的特点来存储每个节点，因为如果有环的话会重复把一个节点添加到set集合中，此时add会返回false
        Set<ListNode> set = new HashSet<>();
//        当当前节点不为空就会继续遍历
        while (head != null){
//            把当前节点添加到set集合中，失败则说明之前添加过这个元素
            if (!set.add(head)){
                return true;
            }
//            每次遍历之后会把下一个元素取出继续遍历
            head = head.next;
        }
//        当遍历完最后一个节点还没有返回true时表明没有环
        return false;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
