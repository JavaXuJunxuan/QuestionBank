package 数据结构;

/**
 * @Author: Xjx
 * @Create: 2023/3/16 - 18:58
 */
public class SingleList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public void setSize(int size) {
        this.size = size;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public Node<T> getTail() {
        return tail;
    }

    public Node<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    boolean addFirst(T data) {
        Node<T> node = new Node<>(data);
        if(head == null){
            tail = node;
        }else {
            node.setNext(head);
        }
        head = node;
        size++;
        return true;
    }

    boolean addLast(T data) {
        Node<T> node = new Node<>(data);
        if(head == null){
            head = node;
        }else {
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    public boolean add(int index, T data) {
        Node<T> node = new Node<>(data);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index + "\tsize:" + size);
        } else if (index == 0) {
            return addFirst(data);
        } else if (index == size) {
            return addLast(data);
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.setNext(temp.next);
            temp.setNext(node);
        }
        size++;
        return true;
    }

    public T removeFirst() {
        if (head == null) {
            throw new RuntimeException("链表为空！");
        } else {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    public T removeLast() {
        T data;
        if (head == null) {
            throw new RuntimeException("链表为空！");
        } else if (head == tail){
            data = head.data;
            head = null;
            tail = null;
        } else {
            Node<T> temp = head;
            while (temp.next != tail){
                head = head.next;
            }
            data = temp.data;
            tail = temp;
        }
        size--;
        return data;
    }

    public T remove(int index) {
        T data = null;
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index + "\tsize:" + size);
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1){
            removeLast();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
        }
        size--;
        return data;
    }

    public T getData(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index + "\tsize:" + size);
        } else {
            Node<T> node = head;
            for (int i = 0; i < index; i++){
                node = node.getNext();
            }
            return node.data;
        }
    }

    public void print() {
        if (size == 0) {
            System.out.println("链表为空");
        } else {
            Node<T> node = head;
            while (node != null) {
                System.out.println(node.data + "\t");
                node = node.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.add(0, 1);
        singleList.add(1, "111");
        Node node = singleList.getHead();
        System.out.println(node.getData());
        singleList.removeFirst();
        node = singleList.getHead();
        System.out.println(node.getData());
    }
}


