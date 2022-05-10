package 链表;

/**
 * 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * 下面的解法是使用单链表并且设置虚拟头结点的解法
 */

public class Q707Two {
    class ListNode{
        int val;
        ListNode next,prev;
        ListNode(int x){
            this.val = x;
        }
    }
    int size = 0;
//    head，tail为虚拟头尾结点
    ListNode head,tail;
    public Q707Two(){
        size = 0;
//        下面是为了虚拟头尾节点初始化，在真正的链表中是不存在的
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        if (index < (size - 1) / 2){
            for (int i = 0; i <= index; i++){
                cur = cur.next;
            }
        }else {
            cur = tail;
            for (int i = 0; i <= size - 1 - index; i++){
                cur = cur.prev;
            }
        }
        return cur.val;
    }
    public void addAtHead(int val){
//        当前的虚拟头结点
        ListNode cur = head;
//        要插入的新的头结点
        ListNode newNode = new ListNode(val);
//        把原来头结点和新头结点做交接
        newNode.next = cur.next;
        cur.next.prev = newNode;
//        把新头结点和虚拟头结点做交接
        cur.next = newNode;
        newNode.prev = cur;
        size++;
    }
    public void addAtTail(int val) {
//          当前的虚拟尾结点
        ListNode cur = tail;
//        要插入的新的头结点
        ListNode newNode = new ListNode(val);
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        size++;
    }
    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        newNode.next.prev = newNode;
        newNode.prev = cur;
        size++;
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
//        下面的顺序不能颠倒，一旦颠倒了那么cur的下一个节点就变为了下下个节点，那么99行代码就会修改原本cur的下下下个节点
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }
}
