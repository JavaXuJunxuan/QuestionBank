import 数据结构.BinaryTreeNode;
import 数据结构.ListNode;
import 数据结构.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode dummy = new ListNode();
        ListNode next = null;
        while(node1 != null){
            ListNode temp = node1.next;
            dummy.next = node1;
            dummy.next.next = next;
            next = node1;
            node1 = temp;
        }
        while(dummy.next != null){
            System.out.println(dummy.next.val);
            dummy.next = dummy.next.next;
        }
    }
}




