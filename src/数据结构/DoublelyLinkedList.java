package 数据结构;

/**
 * @Author: Xjx
 * @Create: 2023/3/16 - 20:47
 */
public class DoublelyLinkedList<T> {
    int size;
    Node<T> head;
    Node<T> tail;

    public void add(T value) {
        Node node = new Node(value);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }

    public void addLast(T value) {
        add(value);
    }

    public void addFirst(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        head.pre = node;
        node.next = head;
        head = node;
        size++;
    }

    public void add(T value, int index) {
        Node node = new Node(value);
        if(index < 0 || index > size) {
            throw new RuntimeException("下标越界");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++){
                temp = temp.next;
            }
            node.pre = temp;
            node.next = temp.next;
            temp.next.pre = node;
            temp.next = node;
            size++;
        }
    }

    public T removeFirst() {
        if (size == 0){
            throw new RuntimeException("链表为空！");
        }
        T data = head.value;
        head.next.pre = null;
        head = head.next;
        size--;
        return data;
    }

    public T removeLast() {
        if (size == 0){
            throw new RuntimeException("链表为空！");
        }
        T data = tail.value;
        tail.pre.next = null;
        tail = tail.pre;
        size--;
        return data;
    }

    public T remove(int index) {
        if(index < 0 || index >= size) {
            throw new RuntimeException("下标越界");
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
           return removeLast();
        } else {
            Node<T> temp = head;
            for (int i = 1; i < index; i++){
                temp = temp.next;
            }
            T data = temp.next.value;
            temp.next = temp.next.next;
            temp.next.pre = temp;
            size--;
            return data;
        }
    }

    public T getData(int index){
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index + "\tsize:" + size);
        }else if (size == 0){
            throw new RuntimeException("链表为空");
        }else if (size == 1){
            return head.value;
        }else {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.value;
        }
    }

    public void print(){
        if (size == 0) {
            System.out.println("该链表为空!");
        }
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
        System.out.println();
    }

    private class Node<T> {
        T value;
        Node<T> pre;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DoublelyLinkedList doublelyLinkedList = new DoublelyLinkedList();
        doublelyLinkedList.add(1);
        doublelyLinkedList.add(2, 1);
        doublelyLinkedList.addLast(3);
        doublelyLinkedList.addLast(4);
        doublelyLinkedList.addFirst(0);
        doublelyLinkedList.print();
        doublelyLinkedList.removeFirst();
        doublelyLinkedList.removeLast();
        doublelyLinkedList.remove(2);
        doublelyLinkedList.print();
        System.out.println(doublelyLinkedList.getData(1));
    }
}
