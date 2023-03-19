package 排序;

/**
 * @Author: Xjx
 * @Create: 2023/2/24 - 12:59
 */
public class a {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        ListNode[] lis = {l1,l4,l6};
        a a = new a();
        a.mergeKLists(lis);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length == 0)return null;
        minHeap pq = new minHeap(length);
        for(ListNode head : lists){
            if(head != null){
                pq.insert(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            cur.next = pq.delete();
            cur = cur.next;
            if(cur.next != null){
                pq.insert(cur.next);
            }
        }
        return dummy.next;
    }

}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class minHeap{
    ListNode[] value;
    int size;

    public minHeap(int siz){
        value = new ListNode[siz];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int left(int i){
        return 2 * i + 1;
    }
    public int right(int i){
        return 2 * i + 2;
    }
    public int parent(int i){
        return (i - 1) / 2;
    }

    public void insert(ListNode node){
        value[size] = node;
        swim(size);
        size++;
    }
    public ListNode delete(){
        ListNode res = value[0];
        swap(0, size - 1);
        value[size - 1] = null;
        size--;
        sink(0);
        return res;
    }
    public void swap(int i, int j){
        ListNode temp = value[i];
        value[i] = value[j];
        value[j] = temp;
    }
    public void swim(int i){
        while(i > 0 && less(i, parent(i))){
            swap(i, parent(i));
            i = parent(i);
        }
    }
    public void sink(int i ){
        while(left(i) < size && less(left(i), i)){
            if(right(i) < size && less(right(i), left(i))){
                swap(i, right(i));
                i = right(i);
            }
            swap(i, left(i));
            i = left(i);
        }
    }
    public boolean less(int i, int j){
        ListNode l1 = value[i];
        ListNode l2 = value[j];
        if(l1.val < l2.val){
            return true;
        }
        return false;
    }
}
