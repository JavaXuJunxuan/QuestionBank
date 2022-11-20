class Node<K,V>{
    K key;
    V value;

    public Node() {
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class Heap {
    private Node<String,Integer>[] data;//存储堆的数组
    private int size;//堆中元素的数量
    public Heap(int capacity){
        data = new Node[capacity];//初始化数组
        size = 0;//初始化数量
    }

    /**
     * 插入元素
     */
    public void insert(Node s) throws Exception{
        if(size == data.length)
            throw new Exception("堆已满");
        else{
            data[size] = s;//将新插入的元素放在堆的末尾
            int i = size;
            size ++;
            while(i > 0){//对堆进行调整，直至满足条件
                int p = (i - 1) / 2;
                if(data[i].getValue() < data[p].getValue()){
                    Node temp = data[i];
                    data[i] = data[p];
                    data[p] = temp;
                    i = p;
                }
                else
                    break;
            }
        }
    }

    /**
     * 删除堆中的元素
     * @return
     * @throws Exception
     */
     public String delMin() throws Exception{
        String res;
        if(size == 0)
            throw new Exception("为空");
        else{
            res = data[0].getKey();//返回索引为0的元素
            size -- ;
            data[0] = data[size];//将堆中最后一个元素填充至索引为0的位置
            int i = 0;
            while(2 * i + 1 < size){//对堆进行调整
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                if(right < size && data[right].getValue() < data[left].getValue() && data[right].getValue() < data[i].getValue()){
                    Node temp = data[i];
                    data[i] = data[right];
                    data[right] = temp;
                    i = right;
                }
                else if(data[left].getValue() < data[i].getValue() && (right >= size || data[right].getValue() >= data[left].getValue())){
                    Node temp = data[i];
                    data[i] = data[left];
                    data[left] = temp;
                    i = left;
                }
                else
                    break;
            }
        }
        return res;
    }

    //测试
    public static void main(String[] args) throws Exception {
        Heap heap = new Heap(7);
        Node node1 = new Node("aaa",15);
        Node node2 = new Node("bbb",1);
        Node node3 = new Node("ccc",8);
        Node node4 = new Node("ddd",59);
        Node node5 = new Node("eee",24);
        Node node6 = new Node("fff",11);
        Node node7 = new Node("ggg",5);
        heap.insert(node1);
        heap.insert(node2);
        heap.insert(node3);
        heap.insert(node4);
        heap.insert(node5);
        heap.insert(node6);
        heap.insert(node7);

        System.out.println(heap.delMin());
        System.out.println(heap.delMin());
        System.out.println(heap.delMin());
    }
}
