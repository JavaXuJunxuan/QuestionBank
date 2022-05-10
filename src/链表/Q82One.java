package 链表;

import java.util.*;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */

public class Q82One {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
//        map用来存储每一个节点出现的次数
        Map<Integer,Integer> map = new HashMap();
//        list存储那些重复出现的节点的节点值
        List list = new ArrayList();
//        创建一个节点充当指针表示当前正在遍历的节点，退出循环时当前链表遍历完毕
        ListNode cur = head;
//        遍历链表，最后cur指向尾结点的下一个节点（空节点）
        while (cur != null){
            map.put(cur.val,map.getOrDefault(cur.val,0) + 1);
            cur = cur.next;
        }
//        map集合无法遍历所以需要转成set集合
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if (entry.getValue() > 1){
                list.add(entry.getKey());
            }
        }
        ListNode prev = new ListNode();
//        prev始终是下面循环中正在遍历节点的前一个节点
        cur = head;
//        prev.next = cur;
        while (cur != null){
            if (list.contains(cur.val)){
//                如果当前遍历的是头结点，且头结点的节点值出现的次数>1那么就要向后移动头结点（因为=头结点值的节点都要被移除）
                if (head.val == cur.val) head = head.next;
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
