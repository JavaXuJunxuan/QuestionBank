package 数据结构;
//本二叉堆为最大堆，最小堆结构与其类似
public class BinaryHeap<Key extends Comparable<Key>> {
    //存储元素的数组
    private Key[] value;
    //当前 Priority Queue 中的元素个数
    private int size = 0;

    public BinaryHeap(int cap){
        // 索引 0 不用，所以多分配一个空间
        value = (Key[]) new Comparable[cap + 1];
    }

    // 父节点的索引
    public int parent(int root){
        return root / 2;
    }

    // 左孩子的索引
    public int left(int root){
        return root * 2;
    }

    // 右孩子的索引
    public int right(int root){
        return root * 2 + 1;
    }

    /* 返回当前队列中最大元素 */
    public Key max(){
        return value[1];
    }

    /* 交换数组的两个元素 */
    private void swap(int i, int j){
        Key temp = value[i];
        value[i] = value[j];
        value[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j){
        return value[i].compareTo(value[j]) < 0;
    }

    /* 上浮第 x 个元素，以维护最大堆性质 */
    private void swim(int x) {
        // 如果浮到堆顶，就不能再上浮了
        while (x > 1 && less(parent(x), x)) {
            // 如果第 x 个元素比上层大
            // 将 x 换上去
            swap(parent(x), x);
            x = parent(x);
        }
    }

    /* 下沉第 x 个元素，以维护最大堆性质 */
    private void sink(int x) {
        // 如果沉到堆底，就沉不下去了
        while (left(x) <= size) {
            // 先假设左边节点较大
            int max = left(x);
            // 如果右边节点存在，比一下大小
            if (right(x) <= size && less(max, right(x)))
                max = right(x);
            // 结点 x 比俩孩子都大，就不必下沉了
            if (less(max, x)) break;
            // 否则，不符合最大堆的结构，下沉 x 结点
            swap(x, max);
            x = max;
        }
    }

    /* 插入元素 e */
    public void insert(Key e) {
        size++;
        // 先把新元素加到最后
        value[size] = e;
        // 然后让它上浮到正确的位置
        swim(size);
    }

    /* 删除并返回当前队列中最大元素 */
    public Key delMax() {
        // 最大堆的堆顶就是最大元素
        Key max = value[1];
        // 把这个最大元素换到最后，删除之
        swap(1, size);
        value[size] = null;
        size--;
        // 让 pq[1] 下沉到正确位置
        sink(1);
        return max;
    }
}
